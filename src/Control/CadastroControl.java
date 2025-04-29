package Control;

import DAO.Conexao;
import DAO.UsuariosDAO;
import Model.Usuario;
import View.CadastroFrame;
import View.LoginFrame;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Galvano
 */
public class CadastroControl {
    private CadastroFrame view;
    
    public CadastroControl(CadastroFrame view){
        this.view = view;
    }    
    
    public void salvarUsuario(){
        String usuario = view.getTxt_usuario_cadastro().getText();
        String senha = view.getTxt_senha_cadastro().getText();
        Usuario usuarioSalvo = new Usuario(usuario,senha);   
        
        Conexao conexao = new Conexao();   
        
        try {
            Connection conn = conexao.getConnection();
            UsuariosDAO dao = new UsuariosDAO(conn);
            dao.inserir(usuarioSalvo);
            JOptionPane.showMessageDialog(view, "Usuario Cadastrado!","Aviso", JOptionPane.INFORMATION_MESSAGE);
            

            //Fecha a tela de cadastro p/ voltar a tela de login
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);
            view.dispose();
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Usuário não cadastrado!","Erro", JOptionPane.ERROR_MESSAGE);        
        }
    }
}
