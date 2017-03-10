/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 201319020135
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

        String jsp = null;
        if (request.getRequestURI().endsWith("/Home")) {
            request.setAttribute("tituloDaPagina", "Home");
            jsp = "Home.jsp";
        } else if (request.getRequestURI().endsWith("/Evento")) {
            request.setAttribute("tituloDaPagina", "Evento");
            jsp = "Evento.jsp";
        } else if (request.getRequestURI().endsWith("/LoginPage")) {
            request.setAttribute("tituloDaPagina", "LoginPage");
            jsp = "LoginPage.jsp";
        } else if (request.getRequestURI().endsWith("/CadastrarEvento")) {
            request.setAttribute("tituloDaPagina", "CadastrarEvento");
            jsp = "CadastrarEvento.jsp";
        }else if (request.getRequestURI().endsWith("/CadastrarUsuario")) {
            request.setAttribute("tituloDaPagina", "CadastrarUsuario");
            jsp = "CadastrarUsuario.jsp";
        }else if (request.getRequestURI().endsWith("/Mensagem")) {
            request.setAttribute("tituloDaPagina", "Mensagem");
            jsp = "Mensagem.jsp";
        }else if (request.getRequestURI().endsWith("/Perfil")) {
            request.setAttribute("tituloDaPagina", "Perfil");
            jsp = "Perfil.jsp";
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
