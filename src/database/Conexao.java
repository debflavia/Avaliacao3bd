package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private Connection conn;

    public Conexao() {
        try {
            System.out.println("Conectado!");
            this.conn = DriverManager.getConnection("jbdc:mysql://localhost/beatrizceratto_e_flaviadebortolli", "root", "");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public Connection getConexao (){
        return this.conn;
    }
}
