package controller.servlet;

import controller.facade.EventoFacade;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.entidade.Evento;

/**
 *
 * @author elciotaira
 */
@WebServlet(name = "CadastrarEventoServlet", urlPatterns = {"/CadastrarEvento"})
public class CadastrarEventoServlet extends HttpServlet {

    private static final String TITULO_DA_PAGINA = "/CadastrarEvento";
    private EventoFacade eventoFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!usuarioLogado(request.getSession())) {
            this.enviaParaPaginaDeLogin(request, response);
            return;
        }
        try {
            eventoFacade = new EventoFacade();
            Evento evento = this.eventoFacade.criarEvento(request);
            request.setAttribute("resultado", "evento cadastrado com sucesso!");
            response.sendRedirect(request.getContextPath() + "/home");
        } catch (Exception ex) {
            Logger.getLogger(CadastrarEventoServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("resultado", ex.getMessage().toString());
            request.getRequestDispatcher("cadastrar_evento.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!usuarioLogado(request.getSession())) {
            this.enviaParaPaginaDeLogin(request, response);
            return;
        }
        request.setAttribute("tituloDaPagina", TITULO_DA_PAGINA);
        request.getRequestDispatcher("cadastrar_evento.jsp").forward(request, response);
    }

    private boolean usuarioLogado(HttpSession session) {
        if (session.getAttribute("autorizacao") != null) {
            return (boolean) session.getAttribute("autorizacao");
        }
        return false;
    }

    private void enviaParaPaginaDeLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login");
        dispatcher.forward(request, response);
    }
}
