/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.facade;

import model.banco.dao.UsuarioDAO;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.entidade.Usuario;

/**
 * Classe utilizada para fazer o controle dos usuarios
 *
 * @author Elcio Cestari Taira
 * @version 1.0
 * @since 13/mar/2017
 */
public class UsuarioFacade {

    /**
     *id_usuario é uma variavel que será utilizada para setar o id_usuario no model Usuario.
     *Fiz a declaração desse método aqui pois não estava conseguindo acessar o atributo id_usuario
     *através do método get em um objeto Usuario salvo na sessao (HttpSession) ao contrario dos outros atributos.
     *Por isso, alterei a visibilidade do atributo id_usuario na classe Usuario retirando static e declarei ele aqui como static.
     *Sendo assim, esse método deve ser utilizado para colocar um valor no atributo id_usuario da classe Usuario.
     */
    private static Integer id_usuario;
    private static ArrayList<Usuario> listaDeUsuarios;//VARIAVEL GLOBAL que representa todos os usuarios

    /**
     * Construtor padrão. Ao ser invoado ele ira verificar se ja existe uma
     * lista de Usuarios no sistema. Caso não existe ele ira instanciar uma
     * nova. Caso existe ele fará nada.
     *
     */
    public UsuarioFacade() {
        if (listaDeUsuarios == null) {
            listaDeUsuarios = new ArrayList<>();
        }
        if (id_usuario == null) {
            id_usuario = 1;
        }
    }

    /**
     * Esse metodo retorna um arrayList de Usuarios
     *
     * @return ArrayList - um arrayList de Usuarios
     */
    public static ArrayList<Usuario> getListaDeUsuarios() {
        return listaDeUsuarios;
    }

    /**
     * Método estatico que verifica se o usuario esta logado através do metodo
     * <code>estaLogado()</code>. Caso esteja ele pega o usuario da
     * <code>listaDeUsuarios</code> através do método <code>getUsuario()</code>
     * e retorna <code>Usuario</code> caso encontre-o e <code>null</code> caso
     * não encontre-o.
     * <p>
     * @return Usuario
     * @param request - HttpServletRequest
     * @see <code>estaLogado()</code> , <code>getUsuario()</code> e
     * <code>Usuario</code>
     */
    public static Usuario getUsuarioDaSessao(HttpServletRequest request) {

        if (estaLogado(request)) {
            return getUsuario((String) request.getSession().getAttribute("usuario.login"));
        }
        return null;
    }

    /**
     * Percorre a lista de usuarios salvos no sistema os compara com o parametro
     * login. Caso algum usuario tenha o mesmo login ele o retorna, caso
     * contrario retorna null.
     *
     * @param login - exemplo: seuemail@email.com
     * @return - if true: Usuario. else: null.
     */
    public static Usuario getUsuario(String login) {
        setListaDeUsuarios();
        for (int i = 0; i < listaDeUsuarios.size(); i++) {
            if (listaDeUsuarios.get(i).getLogin().equals(login)) {
                return listaDeUsuarios.get(i);
            }
        }
        return null;
    }
    
    /**
     * verifica se a listaDeUsuarios no sistema é menor que a do banco, caso seja iguala ambas
     */
    public static void setListaDeUsuarios(){
        if(listaDeUsuarios.size() < new UsuarioDAO().size()){
            listaDeUsuarios = new UsuarioDAO().getAll();
        }
    }

    /**
     * Recebe um request e pega os paremetros login e senha salvos nesse request
     * e depois faz uma busca no banco na tabela usuario e verifica se as
     * colunas login e senha conferem cos os parametros repassados atraves do
     * request. Caso esses parametros sejam os mesmos ele cria uma nova sessao e
     * seta o atributo da sessao autorizao como true.
     *
     * @param request requisição vinda do usuario (browser)
     * @return - true: caso os valores dos paremetros sejam iguais aos valores
     * do banco, false: caso contrario.
     * @throws Exception - caso não seja possível fazer o login
     */
    public boolean logar(HttpServletRequest request) throws Exception {
        String login = (String) request.getParameter("login");
        String senha = (String) request.getParameter("senha");

        try {
            if (new UsuarioDAO().verificaAutenticacao(login, senha)) {//Se o login e senha digitados pelo usuario baterem...
                request.getSession().invalidate();//finalizando a sessão por questões de segurança
                HttpSession session = request.getSession(true);//criando uma sessao
                session.setAttribute("autorizacao", true);//Autorizando o usuario na sessao
                session.setAttribute("usuario", getUsuario(login));//colocando um usuario na sessao

                request.setAttribute("mensagem", "Logado com sucesso");
                return true;
            }
        } catch (Exception ex) {
            request.setAttribute("mensagem", "Login falhou!");
            throw new Exception(ex.getMessage());
        }
        return false;

    }

    /**
     * Salva um usuario no banco. caso não consiga, seta o parametro 'mensagem'
     * do HttpServletRequest com uma mensagem negativa caso contrario, uma
     * mensagem positiva
     *
     * @param request - requisiação vinda do usuario(browser)
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
        int id_usuario = new UsuarioDAO().getLastLogin() + 1;//recupera o maior id do usuario salvo no banco e soma 1 para ser inserido um numero diferente no banco
        try {

            boolean b = new UsuarioDAO().findByLogin(login);//verifica se existe o login 
            if (b) {//caso exista o login lanca exceção
                mensagem = "Ja existe este login cadastrado";
                throw new IllegalArgumentException(mensagem);
            }

            usuario = new Usuario(login, nome, idade, id_usuario, senha);
            new UsuarioDAO().create(usuario);
            listaDeUsuarios.add(usuario);//adiciona um novo usuario a listadeUsuarios
            logar(request);//faz o login, o que inclui um usuario na sessão
            mensagem = "Dados salvo com sucesso!";//mensagem positiva
        } catch (Exception e) {
            mensagem = e.getMessage();//APENAS PARA DEBUG
        } finally {
            request.setAttribute("mensagem", mensagem);//seta a 'mensagem' do request
        }
        return request;//request para ser utilizado no servlet
    }

    /**
     * Verifica na sessao através do atributo 'autorizacao' se o usuario esta ou
     * não logado
     *
     * @param request - requisição vinda do usuario
     * @return boolean - true: se o usuario esta logado na sessao; false: caso
     * não esteja
     * @see  <code>logar()</code>
     */
    public static boolean estaLogado(HttpServletRequest request) {
        if (request.getSession().getAttribute("autorizacao") == null
                || request.getSession().getAttribute("autorizacao").equals(false)) {
            return false;
        }
        return true;
    }
    
    /**
     * Desloga o usuario da sessao, invalidando a sessao
     * @param request HttpServletRequest de sera capturado a sessao
     */
    public static void logout(HttpServletRequest request) {
        request.getSession().invalidate();
    }
}
