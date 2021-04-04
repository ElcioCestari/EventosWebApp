package controller.servlet;

import entidade.Evento;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.EventoService;

/**
 *
 * @author elciotaira
 */
@WebServlet(name = "EventoDetalhesServlet", urlPatterns = {"/evento_detalhado"})
public class EventoDetalhesServlet extends HttpServlet {

    private EventoService eventoService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String eventoId = request.getParameter("eventoId");
        Evento evento = null;
        try {
            this.eventoService = new EventoService();
            evento = this.eventoService.getEventoById(Integer.parseInt(eventoId));
        } catch (SQLException | ClassNotFoundException | RuntimeException ex) {
            Logger.getLogger(EventoDetalhesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("evento", evento);
        request.getRequestDispatcher("evento.jsp").forward(request, response);
    }
}
