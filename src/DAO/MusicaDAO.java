package DAO;

import Model.Musica;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas Galvano
 */
public class MusicaDAO {
    private Connection conn;

    //Construtor
    public MusicaDAO(Connection conn) {
        this.conn = conn;
    }
    
    public List<Musica> buscarMusica(String termo) throws SQLException{
        List<Musica> resultados = new ArrayList<>();
        
        String sql = "SELECT m.music_id, m.music_name, a.artist_name, m.genre, m.duration " +
                     "FROM music m JOIN artista a ON m.artist_id = a.artist_id " +
                     "WHERE m.music_name ILIKE ? OR a.artist_name ILIKE ? OR m.genre ILIKE ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + termo + "%");
            stmt.setString(2, "%" + termo + "%");
            stmt.setString(3, "%" + termo + "%");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                resultados.add(new Musica(
                    rs.getInt("music_id"),
                    rs.getInt("duration"),     
                    rs.getString("music_name"),
                    rs.getString("artist_name"),
                    rs.getString("genre")
                ));
            }
        }
        return resultados;
    }
}
