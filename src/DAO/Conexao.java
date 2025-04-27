package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lucas Galvano
 */

public class Conexao {
    public static Connection getConnection() {
        Connection conexao = null;
        try {
            // Configurações ESPECÍFICAS para seu BD:
            String url = "jdbc:postgresql://localhost:5432/BD-SpotFEI";
            String usuario = "postgres";
            String senha = "paocomovo234";
            
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão estabelecida com BD-SpotFEI!");
        } catch (SQLException e) {
            System.err.println("Erro na conexão: " + e.getMessage());
        }
        return conexao;
    }   
}
