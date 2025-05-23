package Model;

/**
 *
 * @author Lucas Galvano
 */
public abstract class Pessoa {
    protected int userId;
    protected String username;
    protected String password;

    
    // Construtor
    public Pessoa(int userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }    
    
    
    // Getters e Setters

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
