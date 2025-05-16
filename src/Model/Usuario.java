package Model;


/**
 *
 * @author Lucas Galvano
 */


public class Usuario extends Pessoa implements Autenticacao {
    public Usuario(int userId, String username, String password) {
        super(userId, username, password);
    }
    
    
    @Override
    public boolean autenticar(String username, String senha) {
        return this.username.equals(username) && this.password.equals(senha);
    }
}
