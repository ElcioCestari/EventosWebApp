/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet responsavel por fazer os direcionamentos das requisiçoes recebe um
 * objeto HttpServletRequest verifica e direciona a requisição para o
 * responsavel e depois devolve um HttpServletResponse.
 *
 * @author Elcio Cestari Taira
 * @version 1.0
 * @since 20/mar/2017
 */
@WebServlet(name = "ControllerServlet", urlPatterns = {"/ControllerServlet"})
public class ControllerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String jsp = null;//variavel utilizada para configurar qual arquivo JSP será selecionado

        if (request.getRequestURI().endsWith("/index")) {//faz o redirecionamento para a home, com os dados carregados
            request.setAttribute("tituloDaPagina", "Home");
            jsp = "home.jsp";

        } else if (request.getRequestURI().endsWith("/Home")) {
            request.setAttribute("tituloDaPagina", "Home");
            jsp = "home.jsp";
        } else if (request.getRequestURI().endsWith("/Evento")) {
            request.setAttribute("tituloDaPagina", "Evento");
            jsp = "evento.jsp";
        } else if (request.getRequestURI().endsWith("/LoginPage")) {
            request.setAttribute("tituloDaPagina", "LoginPage");
            jsp = "login.jsp";
        } else if (request.getRequestURI().endsWith("/CadastrarEvento")) {
            request.setAttribute("tituloDaPagina", "Cadastrar Evento");
            jsp = "cadastrar_evento.jsp";
        } else if (request.getRequestURI().endsWith("/CadastrarUsuario")) {
            request.setAttribute("tituloDaPagina", "CadastrarUsuario");
            jsp = "cadastrar_usuario.jsp";
        } else if (request.getRequestURI().endsWith("/Mensagem")) {
            request.setAttribute("tituloDaPagina", "Mensagem");
            jsp = "mensagem.jsp";
        } else if (request.getRequestURI().endsWith("/Perfil")) {//requisição para entrar na pagina de perfil
            request.setAttribute("tituloDaPagina", "Perfil");
            jsp = "perfil.jsp";
        } else if (request.getRequestURI().endsWith("/SalvarUsuario")) {
            //requisição para salvar o usuário

            try {//tenta salvar um usuario
                request = new UserController().salvarUsuario(request);
            } catch (Exception e) {
                request.setAttribute("mensagem", e.getMessage());
            }

            request.setAttribute("tituloDaPagina", "Mensagem");
            jsp = "mensagem.jsp";
        } else if (request.getRequestURI().endsWith("/Logar")) {
            if (new UserController().logar(request)) {
            } else {
            }

            jsp = "mensagem.jsp";
        }

        request.getRequestDispatcher(jsp).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
