package Model;

/**
 *
 * @author Lucas Galvano
 */
public class Playlist {
    private int playlistId;
    private String nomePlaylist;

    // Construtor
    public Playlist(int playlistId, String nomePlaylist) {
        this.playlistId = playlistId;
        this.nomePlaylist = nomePlaylist;
    }

    // Getters e Setters
    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public String getNomePlaylist() {
        return nomePlaylist;
    }

    public void setNomePlaylist(String nomePlaylist) {
        this.nomePlaylist = nomePlaylist;
    }

    
}
