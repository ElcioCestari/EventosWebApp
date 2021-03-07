package controller.servlet;

import controller.facade.EventoFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entidade.Evento;

/**
 *
 * @author elciotaira
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {
    private static final String TITULO_DA_PAGINA = "/home";
    private EventoFacade eventoFacade = new EventoFacade();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        List<Evento> listEventos = eventoFacade.getListaDeEventos();
        request.setAttribute("listEventos", listEventos);
        request.setAttribute("tituloDaPagina", TITULO_DA_PAGINA);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}
