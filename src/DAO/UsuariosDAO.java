package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import Model.Usuario;


/**
 *
 * @author Lucas Galvano
 */


public class UsuariosDAO {
    private Connection conn;

    public UsuariosDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet consultarUsuario(Usuario usuario) throws SQLException{
        String sql = "select * from usuario where name = ? and password = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getUsername());
        statement.setString(2, usuario.getPassword());
        statement.execute();   
        ResultSet resultado = statement.getResultSet();
        return resultado;        
    }
    
    public void inserirUsuario(Usuario usuario) throws SQLException{
        String sql = "insert into usuario (name, password) values ('"
                      + usuario.getUsername() + "', '"
                      + usuario.getPassword()   + "')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
}
