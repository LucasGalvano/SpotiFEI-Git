package Control;


import DAO.Conexao;
import DAO.MusicaDAO;
import Model.Musica;
import View.ResultadoBusca;
import View.TelaPrincipal;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author Lucas Galvano
 */
public class ResultadoBuscaControl {
    private TelaPrincipal view;
    private int userId;
    
    // Construtores
    public ResultadoBuscaControl(TelaPrincipal view, int userId) {
        this.view = view;
        this.userId = userId;
    }
    
    
    //Métodos
    public void buscarMusicas() {
        String termo = view.getTxt_busca_home().getText().trim();

        if (termo.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Digite um termo para buscar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Conexao conexao = new Conexao();
        try {
            
            Connection conn = conexao.getConnection();
            MusicaDAO dao = new MusicaDAO(conn);
            List<Musica> resultados = dao.buscarMusica(termo, userId);

            if (resultados.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Nenhuma música encontrada.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                ResultadoBusca resultadoView = new ResultadoBusca(resultados, dao, userId);
                resultadoView.setVisible(true);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao buscar músicas: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
