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


    
    // Métoods
    public List<Musica> buscarMusica(String termo, int userId) throws SQLException {
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
                Time time = rs.getTime("duration");
                int duracaoSegundos = time.toLocalTime().toSecondOfDay();
                Musica musica = new Musica(
                    rs.getInt("music_id"),
                    duracaoSegundos,
                    rs.getString("music_name"),
                    rs.getString("artist_name"),
                    rs.getString("genre")
                );
                musica.setCurtida(isMusicaCurtida(musica.getId(), userId));
                resultados.add(musica);
            }
        }
        return resultados;
    }
    
    
    public void curtirMusica(int musicId, int userId) throws SQLException{
        String sql = "INSERT INTO liked_music (music_id, user_id, liked) " +
                     "VALUES (?, ?, TRUE) " +
                     "ON CONFLICT (music_id, user_id) DO UPDATE SET liked = TRUE";
        
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, musicId);
            stmt.setInt(2, userId);
            stmt.executeUpdate();
        }
    }
    
    
    public void descurtirMusica(int musicId, int userId) throws SQLException{
        String sql = "INSERT INTO liked_music (music_id, user_id, liked) " +
                     "VALUES (?, ?, FALSE) " +
                     "ON CONFLICT (music_id, user_id) DO UPDATE SET liked = FALSE";
        
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, musicId);
            stmt.setInt(2, userId);
            stmt.executeUpdate();
        }
    }
    
    public boolean isMusicaCurtida(int musicId, int userId) throws SQLException {
        String sql = "SELECT liked FROM liked_music WHERE music_id = ? AND user_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, musicId);
            stmt.setInt(2, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return rs.getBoolean("liked");
        }
        return false;
    }
}