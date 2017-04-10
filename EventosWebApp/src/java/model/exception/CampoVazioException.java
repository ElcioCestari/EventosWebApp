/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.exception;

/**
 * Classe utilizada para lançar exceções aonde é esperado algo porém não ha.
 * Normalmente ocorre quando o usuario passa uma string vazia.
 * @author Elcio Cestari Taira
 * @version 1.0
 * @since 10/abr/2017
 */
public class CampoVazioException extends RuntimeException{
    
    /**
     * Cria uma CampoVazioException com a seguinte mensagem: "É necessário preencher o campo."
     */
    public CampoVazioException() {
        super("É necessário preencher o campo.");
    }
    
    /**
     * Cria uma CampoVazioException com o atributo message configurado com o parametro message passado
     * @param message String contendo o que levou o lançamento da exceção
     */
    public CampoVazioException(String message) {
        super(message);
    }
        
}
