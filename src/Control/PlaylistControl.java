package Control;

import DAO.Conexao;
import DAO.PlaylistDAO;
import View.PlaylistFrame;
import View.TelaPrincipal;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Lucas Galvano
 */
public class PlaylistControl {
    private TelaPrincipal view;
    private int userId;

    public PlaylistControl(TelaPrincipal view, int userId) {
        this.view = view;
        this.userId = userId;
    }

    public void abrirPlaylists() {
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            PlaylistDAO playlistDAO = new PlaylistDAO(conn);
            PlaylistFrame frame = new PlaylistFrame(playlistDAO, userId);
            frame.setVisible(true);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao abrir playlists: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }   
}
