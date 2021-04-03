
package controller.servlet;

import service.EnderecoFacade;
import service.EventoService;
import service.UsuarioFacade;
import java.io.IOException;
import java.rmi.AccessException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    private String jsp = null;//variavel utilizada para configurar qual arquivo JSP será selecionado

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            if (request.getRequestURI().endsWith("/index")) {//faz o redirecionamento para a home, com os dados carregados
                jsp = "home.jsp";

            } else if (request.getRequestURI().endsWith("/Home")) {//Requisição feita para acessar a JSP home
                request.setAttribute("tituloDaPagina", "Home");
                request.setAttribute("listaDeEventos", new EventoService().getListaDeEventos());
                jsp = "home.jsp";

            } else if (request.getRequestURI().endsWith("/Evento")) {//Requisição feita para acessar a JSP EVENTO
                verificaAutorizacao(request);
                request.setAttribute("tituloDaPagina", "Evento");
                request.setAttribute("evento", new EventoService().getEventoById(request));//buscanco o evento que o usuario clicou
                jsp = "evento.jsp";

            } else if (request.getRequestURI().endsWith("/LoginPage")) {//Requisição feita para acessar a JSP LOGIN
                request.setAttribute("tituloDaPagina", "Login");
                jsp = "login.jsp";

            } else if (request.getRequestURI().endsWith("/CadastrarEvento")) {//Requisição feita para acessar a JSP CADASTRAR EVENTO
                verificaAutorizacao(request);//verifica se o usuario tem autorizacao
                request.setAttribute("tituloDaPagina", "Cadastrar Evento");
                jsp = "cadastrar_evento.jsp";

            } else if (request.getRequestURI().endsWith("/CadastrarUsuario")) {//Requisição feita para acessar a JSP CADASTRAR USUARIO
                request.setAttribute("tituloDaPagina", "Novo Usuario");
                jsp = "cadastrar_usuario.jsp";

            } else if (request.getRequestURI().endsWith("/Mensagem")) {//Requisição feita para acessar a JSP MENSAGEM
                request.setAttribute("tituloDaPagina", "Mensagem");
                jsp = "mensagem.jsp";

            } else if (request.getRequestURI().endsWith("/Perfil")) {//Requisição feita para acessar a JSP PERFIL
                verificaAutorizacao(request);
                request.setAttribute("tituloDaPagina", "Perfil");
                jsp = "perfil.jsp";

            } else if (request.getRequestURI().endsWith("/SalvarUsuario")) {//Requisição feita para SALVAR USUARIO
                request = new UsuarioFacade().salvarUsuario(request);
                request.setAttribute("tituloDaPagina", "Mensagem");
                jsp = "mensagem.jsp";

            } else if (request.getRequestURI().endsWith("/Logar")) {//Requisição feita para LOGAR
                new UsuarioFacade().logar(request);
                jsp = "perfil.jsp";

            } else if (request.getRequestURI().endsWith("/salvarEvento")) {//Requisição feita na jsp cadastrar_evento.jsp e eh serva para salvar um vento no banco
                verificaAutorizacao(request);//verifica autorização
                new EventoService().criarEvento(request);//cria um evento
                request.setAttribute("mensagem", "Evento salvo com sucesso!");
                jsp = "mensagem.jsp";

            } else if (request.getRequestURI().endsWith("/Sair")) {//Requisição para que o usuario deslogue
                UsuarioFacade.logout(request);//desloga o usuario da sessao
                jsp = "home.jsp";//direciona para a home
                
            }else if (request.getRequestURI().endsWith("/teste")) {//APENAS PARA TESTAR 
                EnderecoFacade enderecoFacade = new EnderecoFacade();
                enderecoFacade.criaEndereco(request);
                enderecoFacade.configuraAtributoEnderecoDoRequest(request);
                
                jsp = "teste.jsp";
            }
        } catch (Exception e) {//caso aja algum erro durante alguma execução, aqui sera capturado e exibida a JSP mensagem com a mesagem de erro
            request.setAttribute("mensagem", e.getMessage());
            jsp = "mensagem.jsp";
        }//FIM dos redirecionamento

        request.getRequestDispatcher(jsp).forward(request, response);
    }

    /**
     * Verifica se usuario esta logado na sessao. caso esteja retorna true. caso
     * não esteja redireciona para a pagina "mensagem" exibindo uma mensagem que
     * ele precisa estar logado
     *
     * @see estaLogado
     * @param request
     * @param jsp
     * @deprecated foi substituido pelo metodo de mesmo nome porém com retorno
     * void, pois, caso o usuario não esteja logado o novo método ira lançar uma
     * exceção ao invés de rotornar false.
     */
    private boolean verificaAutorizacao(HttpServletRequest request, String jsp) {
        if (UsuarioFacade.estaLogado(request)) {
            return true;
        } else {
            jsp = "mensagem.jsp";
            request.setAttribute("mensagem", "Para acessar esta pagina é preciso estar logado");
            return false;
        }
    }

    /**
     * Verifica se o usuario esta logado, caso não esteja ira lançar uma exceção
     * </p>
     * Este método veio para substituir o método:
     * <code>verificaAutorizacao(HttpServletRequest request, String jsp)</code>
     * que retornava um booleano
     *
     * @param request Uma HttpServletRequest utilizada para verificar dados do
     * usuario da sessao
     * @throws AccessException Caso o usuario não esteja logado na sessao
     */
    private void verificaAutorizacao(HttpServletRequest request) throws AccessException {
        if (!(UsuarioFacade.estaLogado(request))) {//se o usuario NAO estiver logado...
            throw new AccessException("Você precisa estar logado!");
        }
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
