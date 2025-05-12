package Control;


import DAO.Conexao;
import DAO.MusicaDAO;
import View.MusicasCurtidasFrame;
import View.TelaPrincipal;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Galvano
 */
public class MusicasCurtidasControl {
    private TelaPrincipal view;
    private int userId;

    public MusicasCurtidasControl(TelaPrincipal view, int userId) {
        this.view = view;
        this.userId = userId;
    }

    public void abrirMusicasCurtidas() {
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            MusicaDAO dao = new MusicaDAO(conn);
            MusicasCurtidasFrame tela = new MusicasCurtidasFrame(dao, userId);
            tela.setVisible(true);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao carregar músicas curtidas: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }    
}
