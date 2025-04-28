package Model;

/**
 *
 * @author Lucas Galvano
 */
public class Usuario {
    private String usuario, senha;
    
    // Construtores
    public Usuario() {
    }

    public Usuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }
    
    // Getters e setters

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuario=" + usuario + ", senha=" + senha + '}';
    }  
}
