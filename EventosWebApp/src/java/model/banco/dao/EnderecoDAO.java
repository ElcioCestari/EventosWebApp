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
import model.entidade.Endereco;

/**
 *
 * @author Elcio Cestari Taira
 */
public class EnderecoDAO extends ConnectionFactory implements InterfaceDAO {

    private PreparedStatement statement;//Prepara a instrução SQL que sera executa
    private ResultSet resultSet;//Contém uma tabela com todas as rows do SQL executado
    private String sql;//String que armezenara temporariamente as instruções SQL que deverão ser executadas

    @Override
    public void create(Object t) throws Exception {
        try {
            Endereco endereco = (Endereco) t;//fazendo casting. throw ClassCastException
            
            this.sql = "INSERT INTO endereco" + "(rua,numero,bairro,cidade,estado)"
                    + "VALUES(?,?,?,?,?);";//preparando a query 
            
            statement = super.getConnection().prepareStatement(sql);//preparando a query que será executada

            statement.setString(1, endereco.getRua());
            statement.setInt(2, endereco.getNumero());
            statement.setString(3, endereco.getBairro());
            statement.setString(4, endereco.getCidade());
            statement.setString(5, endereco.getEstado());
            statement.execute();
            
        } catch (ClassCastException e) {
            throw new RuntimeException("Ocorreu um erro: " + e.getMessage());
        } catch (SQLException e) {
            throw new RuntimeException("Houve um erro na preparaçao da instrução do banco de dados: " + e.getMessage());
        }

    }//fim do método create

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

}
