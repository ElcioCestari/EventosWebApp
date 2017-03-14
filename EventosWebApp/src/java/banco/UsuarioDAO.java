/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;

/**
 * Classe que realiza as operações no banco de dados, tais como: create, read,
 * update e delete.
 *
 * @author Elcio Cestari Taira
 * @version 1.0
 * @since 13/mar/2017
 */
public class UsuarioDAO extends ConnectionFactory implements BaseDAO {

    private String sql = null;//sera a variavel que contera as instruções em sql
    private PreparedStatement statement = null;//prepara o SQL que será executado
    private ResultSet resultado = null;//sera usado para o armazenar temporariamente o resultado das query

    /**
     * Construtor padrao estabelece uma conexão com o banco mysql
     */
    public UsuarioDAO() {
        super();
    }

    /**
     * <p>
     * Recebe um objeto do tipo Usuario configura os seguintes atributos:
     * <br/>
     * login, nome, idade e senha
     * <br/>
     * E salva-os no banco de dados.
     * <p/>
     * @param object - Usuario
     * @throws Exception
     */
    @Override
    public void create(Object object) throws Exception {

        Usuario usuario = (Usuario) object;//casting 

        this.sql = "INSERT INTO usuario" + "(login, nome, idade, senha, id_usuario)" + "VALUES(?,?,?,?,?)";//operação que sera executa no banco

        try {
            statement = getConnection().prepareStatement(sql);//estabelece conexão com o banco e prepara o sql
        } catch (ClassNotFoundException ex) {
            throw new Exception("ERRO AO ESTABELECER UMA CONEXAO: " + ex.getMessage());
        }

        //configura os atributos que serão salvos no banco    
        try {
            statement.setString(1, usuario.getLogin());
            statement.setString(2, usuario.getNome());
            statement.setInt(3, usuario.getIdade());
            statement.setString(4, usuario.getSenha());
            statement.setInt(5, usuario.getId_usuario());

        } catch (SQLException e) {
            throw new Exception("Erro ao configurar os parametros do usuario: " + e.getMessage());
        }
        //executa o sql no banco
        try {
            statement.execute();
        } catch (SQLException e) {
            throw new Exception("Erro ao executar a inserção no banco: " + e.getMessage());
        } finally {
            statement.close();//encerra conexao
            getConnection().close();//encerra conexao
        }
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void upDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@TODO
    @Override
    public Usuario findById(int id_usuario) throws Exception {
        String nome = null;
        this.sql = "SELECT * FROM usuario WHERE id_usuario = " + id_usuario;

        try {
            statement = getConnection().prepareStatement(sql);//estabelece conexão com o banco e prepara o sql
        } catch (ClassNotFoundException ex) {
            throw new Exception("ERRO AO ESTABELECER UMA CONEXAO: " + ex.getMessage());
        } catch (SQLException e) {
            throw new Exception("ERRO AO ESTABELECER UMA CONEXAO: " + e.getMessage());
        }
        
        try {
            resultado = statement.executeQuery();
            while(resultado.next()){
                nome = resultado.getString("nome");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage() + " NAO FOI POSSIVEL ENCONTRAR O USUARIO");
        }
        //TODO
        return new Usuario("", "", id_usuario, id_usuario, "");
    }

}
