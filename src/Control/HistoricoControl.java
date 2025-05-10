package Control;

import DAO.Conexao;
import java.sql.Connection;
import DAO.MusicaDAO;
import View.HistoricoFrame;
import View.TelaPrincipal;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Galvano
 */
public class HistoricoControl {
    private TelaPrincipal view;
    private int userId;
    
    //Construtores

    public HistoricoControl(TelaPrincipal view, int userId) {
        this.view = view;
        this.userId = userId;
    }
    
    
    public void abrirHistorico(){
        Conexao conexao = new Conexao();
        
        try{
            Connection conn = conexao.getConnection();
            MusicaDAO dao = new MusicaDAO(conn);
            HistoricoFrame historico = new HistoricoFrame(dao, userId);
            historico.setVisible(true);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Erro ao carregar histórico: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
