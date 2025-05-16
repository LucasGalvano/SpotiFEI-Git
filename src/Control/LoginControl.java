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
    
    // Métodos
    public void loginUsuario() {
        String username = view.getTxt_usuario_login().getText();
        String password = view.getTxt_senha_login().getText();

        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            UsuariosDAO dao = new UsuariosDAO(conn);
            ResultSet res = dao.consultarUsuario(new Usuario(0, username, password));

            if (res.next()) {
                Usuario usuarioAutenticado = new Usuario(
                    res.getInt("user_id"),
                    res.getString("name"),
                    res.getString("password")
                );

                
                if (usuarioAutenticado.autenticar(username, password)) {
                    JOptionPane.showMessageDialog(view, "Login efetuado!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    TelaPrincipal telaPrincipal = new TelaPrincipal(usuarioAutenticado);
                    telaPrincipal.setVisible(true);
                    view.dispose();
                } else {
                    JOptionPane.showMessageDialog(view, "Username ou senha incorretos!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(view, "Usuário não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro de conexão: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
}
}
