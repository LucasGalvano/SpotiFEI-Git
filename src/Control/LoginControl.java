package Control;

import DAO.UsuariosDAO; 
import DAO.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Model.Usuario;
import View.TelaPrincipal;
import View.LoginFrame;


/**
 *
 * @author Lucas Galvano
 */


public class LoginControl {
    private LoginFrame view;

    //Construtores
    public LoginControl(LoginFrame view) {
        this.view = view;
    }    
    
    // função
    public void loginUsuario(){
        Usuario usuario = new Usuario(
            view.getTxt_usuario_login().getText(),
            view.getTxt_senha_login().getText()
        );
        
        Conexao conexao = new Conexao();
        try{
            
            Connection conn = conexao.getConnection();
            UsuariosDAO dao = new UsuariosDAO(conn);
            ResultSet res = dao.consultar(usuario);
            
            if(res.next()){
                JOptionPane.showMessageDialog(view, "Login efetuado!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                Usuario usuarioAutenticado = new Usuario(res.getString("name"), res.getString("password"));

                
                // Fecha a tela de login e abre a principal
                TelaPrincipal telaPrincipal = new TelaPrincipal(usuarioAutenticado);
                telaPrincipal.setVisible(true);
                view.dispose(); // fecha a tela de login
            } 
            else{
                JOptionPane.showMessageDialog(view, "Login NÃO efetuado!", "Aviso", JOptionPane.ERROR_MESSAGE);
            }
        }catch(SQLException e){    
            JOptionPane.showMessageDialog(view, "Erro de conexão!", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }
}
