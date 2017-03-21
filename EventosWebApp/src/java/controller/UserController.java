/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import banco.dao.UsuarioDAO;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Usuario;

/**
 * Classe utilizada para fazer o controle dos usuarios
 *
 * @author Elcio Cestari Taira
 * @version 1.0
 * @since 13/mar/2017
 */
public class UserController {

    private static ArrayList<Usuario> listaDeUsuarios = new ArrayList<Usuario>();//VARIAVEL GLOBAL que representa todos os usuarios

    public static ArrayList<Usuario> getListaDeUsuarios() {
        return listaDeUsuarios;
    }

    /**
     * Recebe um request e pega os paremetros login e senha salvos nesse request
     * e depois faz uma busca no banco na tabela usuario e verifica se as
     * colunas login e senha conferem cos os parametros repassados atraves do
     * request. Caso esses parametros sejam os mesmos ele cria uma nova sessao e
     * seta o atributo da sessao autorizao como true.
     *
     * @param request
     * @return - true: caso os valores dos paremetros sejam iguais aos valores
     * do banco, false: caso contrario.
     */
    public boolean logar(HttpServletRequest request) {

        String login = null;
        String senha = null;
        login = (String) request.getParameter("login");
        senha = (String) request.getParameter("senha");

        try {
            if (new UsuarioDAO().verificaAutenticacao(login, senha)) {
                request.getSession().invalidate();
                HttpSession session = request.getSession(true);
                session.setAttribute("autorizacao", new Boolean(true));
                
                /*
                if (request.getSession().getAttribute("autorizacao") == null) {
                    request.getSession().setAttribute();
                }
                */
                request.setAttribute("mensagem", "Logado com sucesso");
                return true;
            }
        } catch (Exception ex) {
            request.setAttribute("mensagem", "Login falhou!");
            return false;
        }
        return false;

    }

    /**
     * Salva um usuario no banco. caso não consiga, seta o parametro 'mensagem'
     * do HttpServletRequest com uma mensagem negativa caso contrario, uma
     * mensagem positiva
     *
     * @param request
     * @return request - com o parametro 'mensagem' configurado com uma mensagem
     * positiva ou negativa.
     */
    public HttpServletRequest salvarUsuario(HttpServletRequest request) {
        Usuario usuario = null;
        String mensagem = null;
        String nome = (String) request.getParameter("nome");//fazendo casting para atribuir os valores aos respectivos atributos
        String senha = (String) request.getParameter("senha");//fazendo casting para atribuir os valores aos respectivos atributos
        int idade = Integer.parseInt(request.getParameter("idade"));//fazendo casting para atribuir os valores aos respectivos atributos
        String login = (String) request.getParameter("login");//fazendo casting para atribuir os valores aos respectivos atributos

        try {

            boolean b = new UsuarioDAO().findByLogin(login);//verifica se existe o login 
            if (b) {//caso exista o login lanca exceção
                mensagem = "Ja existe este login cadastrado";
                throw new IllegalArgumentException(mensagem);
            }

            usuario = new Usuario(login, nome, idade, senha);
            new UsuarioDAO().create(usuario);
            logar(request);
            mensagem = "Dados salvo com sucesso!";//mensagem positiva
            listaDeUsuarios.add(usuario);//adiciona um novo usuario a listadeUsuarios
        } catch (Exception e) {
            //usuario = null;
            mensagem = "Desculpe ocorreu um erro ao salvar os seus dados!";//mensagem que não conseguiu salvar
            mensagem = e.getMessage();//APENAS PARA DEBUG
        } finally {
            request.setAttribute("mensagem", mensagem);//seta a 'mensagem' do request
        };
        return request;//request para ser utilizado no servlet
    }

    /**
     * Verifica na sessao através do atributo 'autorizacao' se o usuario esta ou
     * não logado
     *
     * @see - logar()
     * @param - request
     * @return - true: se o usuario esta logado na sessao; false: caso não
     * esteja
     */
    public boolean estaLogado(HttpServletRequest request) {
        
        if (request.getSession().getAttribute("autorizacao") == null ||
            request.getSession().getAttribute("autorizacao").equals(false)){
            
            return false;
        }
        return true;
    }
}
