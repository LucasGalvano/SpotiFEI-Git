package DAO;


import Model.Musica;
import Model.Playlist;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Lucas Galvano
 */
public class PlaylistDAO {
    private Connection conn;

    // Construtor
    public PlaylistDAO(Connection conn) {
        this.conn = conn;
    }

    
    //Métodos
    public void criarPlaylist(int userId, String nomePlaylist) throws SQLException {
        String sql = "INSERT INTO playlist (playlist_name, user_id) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nomePlaylist);
            stmt.setInt(2, userId);
            stmt.executeUpdate();
        }
    }

    public void excluirPlaylist(int userId, String nomePlaylist) throws SQLException {
        String sql = "DELETE FROM playlist WHERE user_id = ? AND playlist_name = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setString(2, nomePlaylist);
            stmt.executeUpdate();
        }
    }

    public List<Playlist> playlistUsuario(int userId) throws SQLException {
        List<Playlist> playlists = new ArrayList<>();
        String sql = "SELECT playlist_id, playlist_name FROM playlist WHERE user_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                playlists.add(new Playlist(rs.getInt("playlist_id"), rs.getString("playlist_name")));
            }
        }
        return playlists;
    }
    
    public List<Musica> verPlaylist(int playlistId) throws SQLException {
        List<Musica> musicas = new ArrayList<>();
        String sql = "SELECT m.music_id, m.music_name, a.artist_name, m.genre, m.duration " +
                     "FROM playlist_music pm " +
                     "JOIN music m ON pm.music_id = m.music_id " +
                     "JOIN artista a ON m.artist_id = a.artist_id " +
                     "WHERE pm.playlist_id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, playlistId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Time duracao = rs.getTime("duration");
                musicas.add(new Musica(
                    rs.getInt("music_id"),
                    duracao.toLocalTime().toSecondOfDay(),
                    rs.getString("music_name"),
                    rs.getString("artist_name"),
                    rs.getString("genre")
                ));
            }
        }
        return musicas;
    }

    public void adicionarMusicaNaPlaylist(int playlistId, int musicId) throws SQLException {
        String sql = "INSERT INTO playlist_music (playlist_id, music_id) VALUES (?, ?) ON CONFLICT DO NOTHING";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, playlistId);
            stmt.setInt(2, musicId);
            stmt.executeUpdate();
        }
    }    
}
