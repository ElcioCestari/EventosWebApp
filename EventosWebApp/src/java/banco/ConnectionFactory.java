/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.sql.Connection;
import java.sql.DriverManager;
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

    private String url;
    private String user;
    private String password;

    /**
     * Inicializa os parametros para serem feitos a conexao com o SGBD 
     * @param url - caminho utilizado para abrir a conexao. Exemplo: jdbc:mysql://localhost:3306/meubanco
     * @param user - usuario do SGBD. Exemplo: admin
     * @param password - senha do SGBD. Exemplo: admin
     */
    public ConnectionFactory(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }
    
    
    /**
     * Obtem uma conexão com o SGBD
     * @return Conexão com o SGBD  
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public Connection getConnection() throws ClassNotFoundException, SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            new SQLException("Não foi possível conectar-se ao banco de dados");
        } catch (ClassNotFoundException e) {
            new ClassNotFoundException("Não foi possivel registrar o driver jdbc do mysql");
        }
        return null;
    }
    
    /**
     * 
     * @param url - caminho utilizado para abrir a conexao
     * @param user - usuario do SGBD 
     * @param password - senha do usuario do sgbd
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public Connection getConnection(String url, String user, String password) throws ClassNotFoundException, SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            new SQLException("Não foi possível conectar-se ao banco de dados");
        } catch (ClassNotFoundException e) {
            new ClassNotFoundException("Não foi possivel registrar o driver jdbc do mysql");
        }
        return null;
    }
}
