/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.banco.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.banco.ConnectionFactory;
import model.entidade.Local;

/**
 *
 * @author Elcio Cestari Taira
 */
public class LocalDAO extends ConnectionFactory implements InterfaceDAO {
    
    private PreparedStatement preparedStatement;//preparação para a instrução SQL que será executada
    private ResultSet resultSet;//tabela de dados recuperados através da execução do PreparedStatement 
    private String sql;//String que conterá o instrução SQL que será executada no banco através do PreparedStatement

    public LocalDAO() throws ClassNotFoundException, SQLException {
        super();
    }
    
    
    
    @Override
    public void create(Object t) throws ClassCastException, ClassNotFoundException, SQLException {
        Local local = (Local) t;//fazendo casting pode gerar ClassCastException
        setSql("INSERT INTO local" + "(capacidade,nome,id_endereco)" + "VALUES(?,?,?)");//configura a variavel sql com os campos que devem ser inseridos no banco
        this.setPreparedStatement(sql);
        
        preparedStatement.setInt(1, local.getCapacidade());
        preparedStatement.setString(2, local.getNome());
        //preparedStatement.setInt(3, local.get); DEVO CRIAR UMA LISTA DE ENDERECO NO EVENTO E PEGAR O ID_ENDEREO
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void upDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object findById(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setPreparedStatement(String sql) throws ClassNotFoundException, SQLException {
        this.preparedStatement = getConnection().prepareStatement(sql);
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
    

}
