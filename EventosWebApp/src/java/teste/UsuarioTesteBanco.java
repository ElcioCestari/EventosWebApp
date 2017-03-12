/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import banco.ConnectionFactory;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elcio Cestari Taira
 */
public class UsuarioTesteBanco {

    private String mensagem = null;
    private String nome;

    public UsuarioTesteBanco(String nome) {
        this.nome = nome;
        try {
            new ConnectionFactory("jdbc:mysql://localhost:3306/bancoteste", "admin", "admin").getConnection();
            mensagem = "CONECTADO COM SUCESSO!!!!";
        } catch (ClassNotFoundException ex) {
            mensagem = "NAO CONECTOU!!!!";
        } catch (SQLException ex) {
            mensagem = "NAO CONECTOU!!!!";
        }
    }

    public String getNome() {
        return nome;
    }

    public String getMensagem() {
        return mensagem;
    }
    

}
