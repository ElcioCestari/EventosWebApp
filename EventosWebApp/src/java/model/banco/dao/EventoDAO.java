/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.banco.dao;

import banco.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.entidade.Evento;

/**
 * Essa classe implementa os metodos de consultas e inserções no Banco de Dados
 *
 * @author      Elcio Cestari Taira
 * @version     1.0
 * @since       26/mar/2017
 */
public class EventoDAO extends ConnectionFactory implements InterfaceDAO<Object> {

    
    /**
     * Metodo que recebe um Object que deve ser uma instancia de Evento, pois
     * sera feito o casting nesse metodo. E salva-o no banco na tabela evento
     *
     * @param t                         Objeto que deve ser do tipo Evento
     * @throws SQLException             Caso haja algum erro ao tentar acessar ou salvar no banco
     * @throws ClassNotFoundException   Caso haja algum erro em instanciar a o tipo da classe
     */
    @Override
    public void create(Object t) throws SQLException, ClassNotFoundException {
        try {
            Evento evento = (Evento) t;//fazendo casting

            String sql = "INSERT INTO evento(tipo_evento,valor,nome,id_evento,faixaEtaria, id_usuario)Values(?,?,?,?,?,?);";

            PreparedStatement statement = getConnection().prepareStatement(sql);

            statement.setString(1, evento.getTipo());//valor que será salvo na coluna  tipo_evento
            statement.setDouble(2, evento.getValor());//valor que será salvo na coluna valor
            statement.setString(3, evento.getNome());//valor que será salvo na coluna nome
            statement.setInt(4, evento.getId_evento());//valor que será salvo na coluna id_evento. Essa coluna é uma PRIMARY KEY
            statement.setInt(5, evento.getFaixaEtaria());//valor que será salvo na coluna faixa_etaria.
            statement.setInt(6, evento.getId_usuario());//valor que sera salvo como id_usuario.  CHAVE ESTRANGEIRA
            statement.execute();//executando a instrução SQL.
            
        } catch (SQLException sqle) {
            throw new SQLException(sqle.getMessage() + " Houve um erro ao salvar o Evento");
        } catch (ClassNotFoundException cnfe) {
            throw new ClassNotFoundException(cnfe.getMessage() + " Houve um erro ao salvar o Evento");
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

    @Override
    public Object findById(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
