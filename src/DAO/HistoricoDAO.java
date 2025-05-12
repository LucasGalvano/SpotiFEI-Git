package DAO;


import Model.Musica;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas Galvano
 */
public class HistoricoDAO {
    private Connection conn;

    public HistoricoDAO(Connection conn) {
        this.conn = conn;
    }

    
    
    // Procura as ultimas buscas feitas pelo user
    public List<Musica> procurarBuscas(int userId) throws SQLException{
        List<Musica> musicas = new ArrayList<>();
        String sql = "SELECT m.music_id, m.music_name, a.artist_name, m.genre, m.duration " +
                     "FROM search_history h " +
                     "JOIN music m ON h.music_id = m.music_id " +
                     "JOIN artista a ON m.artist_id = a.artist_id " +
                     "WHERE h.user_id = ? " +
                     "ORDER BY h.search_id DESC LIMIT 10";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Time time = rs.getTime("duration");
                int duracaoSegundos = time.toLocalTime().toSecondOfDay();
                Musica musica = new Musica(
                        rs.getInt("music_id"),
                        duracaoSegundos,
                        rs.getString("music_name"),
                        rs.getString("artist_name"),
                        rs.getString("genre")
                );
                musicas.add(musica);
            }
        }
        return musicas;
    }

    
    //Registra as buscas recentes (10)
    public void registrarBusca(int userId, int musicId) throws SQLException {
        String sql = "INSERT INTO search_history (user_id, music_id) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, musicId);
            stmt.executeUpdate();
        }
    }    
}
