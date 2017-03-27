/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Cria uma fabrica de conexoes com o SGBD
 *
 * @author Elcio Cestari Taira
 * @version 1.0
 * @since 11/mar/2017
 *
 */
public class ConnectionFactory {

    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/eventoswebapp";
    private static final String user = "admin";
    private static final String password = "admin";


    private PreparedStatement statement = null;
    
    /**
     * Obtem uma conexão com o SGBD
     *
     * @return Conexão com o SGBD
     * @throws ClassNotFoundException caso não consiga configurar o drive de conexao com o banco
     * @throws SQLException caso ocorra algum erro em estabelecer uma comunicação com o banco
     */
    public Connection getConnection() throws ClassNotFoundException, SQLException {

        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            new SQLException("Não foi possível conectar-se ao banco de dados");
        } catch (ClassNotFoundException e) {
            new ClassNotFoundException("Não foi possivel registrar o driver jdbc do mysql");
        }
        return null;
    }
}
