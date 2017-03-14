/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import banco.UsuarioDAO;
import javax.servlet.http.HttpServletRequest;
import model.Usuario;

/**
 * Classe utilizada para fazer o controle dos usuarios
 * 
 * @author Elcio Cestari Taira
 * @version 1.0
 * @since 13/mar/2017
 */
public class UserController {
    private static int id_usuario = 10;//VARIAVEL GLOBAL que representa a id e sera incrementado a cada novo usuario
    
    /**
     * Salva um usuario no banco.
     * caso não consiga  seta o parametro 'mensagem' do HttpServletRequest 
     * com uma mensagem negativa
     * caso contrario uma mensagem positiva
     * @param request
     * @return request 
     */
    public HttpServletRequest salvarUsuario(HttpServletRequest request) {
        Usuario usuario = null;
        String mensagem = null; 
        String nome = (String) request.getParameter("nome");//fazendo casting para atribuir os valores aos respectivos atributos
        String senha = (String) request.getParameter("senha");//fazendo casting para atribuir os valores aos respectivos atributos
        int idade = Integer.parseInt(request.getParameter("idade"));//fazendo casting para atribuir os valores aos respectivos atributos
        String login = (String) request.getParameter("login");//fazendo casting para atribuir os valores aos respectivos atributos
        
        //cria um novo usuario e incrementa a variavel global id_usuario
        usuario = new Usuario(login, nome, idade, ++id_usuario, senha);
        
        try {
            new UsuarioDAO().create(usuario);
            mensagem = "Dados salvo com sucesso!";//mensagem positiva
        } catch (Exception e) {
            id_usuario--;// decrementa a varial global de id
            mensagem = "Desculpe ocorreu um erro ao salvar os seus dados!";//mensagem que não conseguiu salvar
            mensagem = e.getMessage();//APENAS PARA DEBUG
        }finally{
            request.setAttribute("mensagem", mensagem);//seta a 'mensagem' do request
        };

        return request;//request para ser utilizado no servlet
    }
}
