package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lucas Galvano
 */

public class Conexao {
    public static Connection getConnection() throws SQLException {
        Connection conexao = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/BD-SpotFEI", "postgres", "paocomovo234");
        return conexao;
    }   
}
