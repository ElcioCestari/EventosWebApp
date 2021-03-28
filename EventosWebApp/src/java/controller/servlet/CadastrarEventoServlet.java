package controller.servlet;

import entidade.Evento;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.EventoService;

/**
 *
 * @author elciotaira
 */
@MultipartConfig
@WebServlet(name = "CadastrarEventoServlet", urlPatterns = {"/CadastrarEvento"})
public class CadastrarEventoServlet extends HttpServlet {

    private static final String TITULO_DA_PAGINA = "/CadastrarEvento";
    private EventoService eventoService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!usuarioLogado(request.getSession())) {
            this.enviaParaPaginaDeLogin(request, response);
            return;
        }
        try {
            eventoService = new EventoService();
            Evento evento = this.eventoService.criarEvento(request);
            request.setAttribute("resultado", "evento cadastrado com sucesso!");
            response.sendRedirect(request.getContextPath() + "/home");
        } catch (Exception ex) {
            request.setAttribute("error", "Ocorreu o seguinte erro: " + ex.getLocalizedMessage() + "Não foi possível salvar o evento, tente novamente ou mais tarde. " );
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
