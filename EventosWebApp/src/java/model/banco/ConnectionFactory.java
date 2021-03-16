package model.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
    private Connection connection;

    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/eventoswebapp";
    private static final String user = "root";
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
        if(this.connection != null) return this.connection;
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            Exception ex = e;
            new SQLException("Não foi possível conectar-se ao banco de dados");
        } catch (ClassNotFoundException e) {
            new ClassNotFoundException("Não foi possivel registrar o driver jdbc do mysql");
        }
        return null;
    }
    
    /**
     * finaliza a conexão com o banco.
     * @throws ClassNotFoundException   gera quando a classe não foi encontrada.
     * @throws SQLException caso  haja algum erro de com o banco.
     * @see ConnectionFactory   Veja o atributo <code>driver</code> na classe <code>ConnectionFactory</code> em <code>model.banco</code> 
     */
    public void close() throws ClassNotFoundException, SQLException{
        this.getConnection().close();
    }
}
