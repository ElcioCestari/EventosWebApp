package controller.servlet;

import controller.facade.UsuarioFacade;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author elciotaira
 */
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/cadastrar_usuario", "/SalvarUsuario"})
public class UsuarioServlet extends HttpServlet {

    private UsuarioFacade usuarioFacade;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("cadastrar_usuario.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        usuarioFacade = new UsuarioFacade();
        usuarioFacade.salvarUsuario(request);
    }

}
