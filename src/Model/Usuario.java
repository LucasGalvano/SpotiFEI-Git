package Model;


/**
 *
 * @author Lucas Galvano
 */


public class Usuario {
    private String usuario, senha;
    private int userId; // Adição para evitar conflitos de musicas curtidas e playlists no BD
    
    // Construtores
    public Usuario() {
    }

    
    public Usuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }
    
    
    public Usuario(int userId,String usuario, String senha) { //  Novo contrutor p/ o login autenticado add o id p/ evitar conflitos
        this.userId = userId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
   
    
    @Override
    public String toString() {
        return "Usuario{" + "usuario=" + usuario + ", senha=" + senha + '}';
    }  
}
