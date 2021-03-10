package model.banco.dao;

import model.banco.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.entidade.Usuario;

/**
 * Classe que realiza as operações no banco de dados, tais como: create,
 * findByLogin e verificaAutenticacao
 *
 * @author Elcio Cestari Taira
 * @version 1.0
 * @since 13/mar/2017
 */
public class UsuarioDAO extends ConnectionFactory implements InterfaceDAO {

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
     * <br>
     * login, nome, idade e senha
     * <br>
     * E salva-os no banco de dados.
     * <p>
     * @param object - Usuario
     * @throws Exception - caso haja algum erro ao salvar no banco
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

        try {
            statement.execute();//executa o sql no banco
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
        } catch (ClassNotFoundException | SQLException ex) {
            throw new Exception("ERRO AO ESTABELECER UMA CONEXAO: " + ex.getMessage());
        }

        try {
            resultado = statement.executeQuery();
            while (resultado.next()) {
                nome = resultado.getString("nome");
            }
        } catch (SQLException e) {
            throw new Exception(e.getMessage() + " NAO FOI POSSIVEL ENCONTRAR O USUARIO");
        }
        //TODO
        return null;
    }

    /**
     * Faz um select no banco buscando os logins: SELECT * FROM usuario WHERE
     * login = (parametro repassado para o metodo)
     *
     * @param login String que deve ser no modelo de um email
     * @return true se encontrou o login e false caso contrario
     * @throws RuntimeException caso haja algum erro ao realizar a consulta SQL
     */
    public boolean findByLogin(String login) throws RuntimeException {
        this.sql = "SELECT * FROM usuario WHERE login = " + "'" + login + "';";
        try {
            statement = getConnection().prepareStatement(sql);
            resultado = statement.executeQuery();
            while (resultado.next()) {
                if (resultado.getString("login").equals(login)) {
                    return true;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Houve um problema ao verificar o login: " + ex.getMessage());
        } finally {
            try {
                statement.close();
                resultado.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    /**
     * Verifica se existe o usuario no banco
     * <p>
     * Metodo que verfica se os parametro passados (login e senha) batem com os
     * valores salvos na tabela usuario nos campos login e senha. Caso sejam os
     * mesmos returna true, caso contrario false.
     * <p>
     * Esse metodo é interessando para veriricar se o usuario pode logar.
     *
     * @param login - String que representa o login do Usuario
     * @param senha - String que representa a senha do Usuario
     * @return boolean - true: existe o usuario e confere a senha, false: não
     * confere a senha
     * @throws SQLException - caso haja algum erro ao executar alguma instrução
     * SQL
     * @throws Exception - Caso haja algum erro ao executar alguma instrução SQL
     */
    public boolean verificaAutenticacao(String login, String senha) throws SQLException, Exception {

        //SELECT * FROM usuario WHERE login = 'elcio@email.com' AND senha = 123;
        //instrução SQL q sera executada no banco
        //deve percorrer todas as tuplas da tabela usuario
        //e retornar a row com usuario e sinha igual aos repassados no paratro do metodo
        this.sql = "SELECT * FROM usuario WHERE login = " + "'" + login + "'"
                + "AND senha = " + "'" + senha + "';";

        statement = getConnection().prepareStatement(sql);
        resultado = statement.executeQuery();

        while (resultado.next()) {
            if (resultado.getString("senha").equals(senha) && resultado.getString("login").equals(login)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Recupera o maior id do usuario que esta salvo no banco
     * @return int  que corresponde ao maior id do usuario
     * @throws RuntimeException caso ocorra um erro de SQL OU CLASS
     */
    public int getLastLogin() throws RuntimeException{
        int lastLogin = 0;// utlizada para armazenar temporariamente o maior inteiro da tabela usuario da coluna id_usuario
        try {
            this.sql = "SELECT MAX(id_usuario) as max_id_usuario FROM usuario;";//instrução SQL que recupera o maior id_usuario. tive que criar a aliase max_id_usuario pois sem estava dando erro
            statement = getConnection().prepareStatement(sql);//prepara a query
            resultado = statement.executeQuery();//executa a query
            while(resultado.next()){//loop que deve rodar apenas 1 vez devido a instrução SQL
                lastLogin = resultado.getInt("max_id_usuario");//atribui a variavel o resultado da query;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Não foi possivel recuperar o ultimo id do usuario: " + e.getMessage());
        } finally{//trecho para liberar recursos
            try {
                statement.close();
                resultado.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lastLogin;//retorna o maior id_usuario do banco
    }
    
    /**
     * Busca no banco todas as instancias da classe Usuario e adiciona a um ArrayList 
     * @return ArrayList    contendo todos os Usuarios do banco
     * @throws RuntimeException caso ocorra algum erro ao buscar no banco
     */
    public ArrayList getAll() throws RuntimeException{
        ArrayList<Usuario> listaDeUsuarios = new ArrayList();
        Usuario usuario;
        sql = "SELECT * FROM usuario;";
        try {
            statement = getConnection().prepareStatement(sql);
            resultado = statement.executeQuery();
            while (resultado.next()) {
                usuario = new Usuario(resultado.getString("login"), 
                        resultado.getString("nome"), 
                        resultado.getInt("idade"), 
                        resultado.getInt("id_usuario"), 
                        resultado.getString("senha"));
                
                listaDeUsuarios.add(usuario);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Ocorreu um erro ao buscar a lista de usuarios: " + ex.getMessage());
        }finally{
            endConnection();
        }
        return listaDeUsuarios;
    }
    
    /**
     * conta a quantidade de tuplas usuario no banco 
     * @return int a quantidade de usuarios
     * @throws RuntimeException caso ocorra um erro na consulta
     */
    public int size() throws RuntimeException{
        int size = 0;
        sql = "SELECT count(*) as size FROM usuario;";
        this.conectsAndExecutes(sql);
        try {
            while (resultado.next()) {
                size = resultado.getInt("size");
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Ocorreu um erro: " + ex.getMessage());
        }
        return size;        
    } 
    
    /**
     * Conecta e executa a query repassada como parametro 
     * @param sql   a instrução sql que será executada no banco
     * @throws RuntimeException caso ocorra um erro no banco
     */
    private void conectsAndExecutes(String sql) throws RuntimeException{
        try {
            statement = getConnection().prepareStatement(sql);
            resultado = statement.executeQuery();
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Ocorreu um erro ao realizar a pesquisa no banco: " + ex.getMessage());
        }
    }
    
    /**
     * Finaliza a conexão com o banco
     */
    private void endConnection(){ 
        try {
            statement.close();
            resultado.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

