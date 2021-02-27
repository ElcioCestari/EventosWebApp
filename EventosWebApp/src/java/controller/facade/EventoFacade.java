/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.facade;

import java.util.ArrayList;
import model.banco.dao.EventoDAO;
import javax.servlet.http.HttpServletRequest;
import model.entidade.Evento;
import model.entidade.Usuario;

/**
 * Essa classe prove uma abstração maior para poder acessar os recursos que são
 * relacionados aos Eventos. tais como: Criar evento, curtir evento, cancelar
 * curtir evento, etc.
 *
 * @author Elcio Cestari Taira
 */
public class EventoFacade {

    private static ArrayList<Evento> listaDeEventos;

    /**
     * Metodo que recebe como parametro um HttpServletRequest CONFIGURADO,ou
     * seja, com os atributos necessarios para criação de um evento conforme foi
     * modelado. Os atributos que o HttpServletRequest deve ter são os
     * seguintes: <br>
     * <ul>
     * <li>nomeEvento - String</li>
     * <li>tipo_evento - String</li>
     * <li>descricao -String</li>
     * <li>valor - double</li>
     * <li>faixaEtaria - int</li>
     * </ul>
     *
     * <br>
     * Com esses parametros ele criará um evento
     *
     * @param request - requisição feita pelo usuario
     * @throws Exception - caso não seja criado um evento
     */
    public void criarEvento(HttpServletRequest request) throws Exception {
        try {
            new EnderecoFacade().criaEndereco(request);

            String nomeEvento = (String) request.getParameter("nomeEvento");//Fazendo casting. throw ClassCastException 
            String tipo = (String) request.getParameter("tipo_evento");//Fazendo casting. throw ClassCastException
            String descricao = (String) request.getParameter("descricao");//Fazendo casting. throw ClassCastException
            double valor = Double.parseDouble(request.getParameter("valor"));//Fazendo casting. throw ClassCastException
            int faixaEtaria = Integer.parseInt(request.getParameter("faixaEtaria"));//Fazendo casting. throw ClassCastException

            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");//problema esta aqui

            Evento evento = new Evento(tipo, descricao, valor, faixaEtaria, nomeEvento, usuario.getId_usuario());

            new EventoDAO().create(evento);

            //estou tendo problemas aqui, pois o listaDeEventos ta null mas não ta entrando no if
            if (listaDeEventos == null) {
                listaDeEventos = new ArrayList<>();
            }
            listaDeEventos.add(evento);

        } catch (ClassCastException e) {
            throw new RuntimeException("Ocorreu um erro de sistema: " + e.getMessage() + " Por favor tente novamente!");
        } catch (Exception e) {
            throw new Exception(e.getMessage() + " Houve um erro ao cadastrar o evento. Por favor, tente novamente ou mais tarde!");
        }

    }

    /**
     * retorna uma lista contentdo todos os eventos salvos no sistemas
     *
     * @return Arraylist uma lista contendo todos os eventos.
     */
    public ArrayList<Evento> getListaDeEventos() {
        setListaDeEventos();
        return listaDeEventos;
    }

    /**
     * Configura uma ArrayList com todos os Eventos que tem no banco
     */
    public void setListaDeEventos() {
        listaDeEventos = new EventoDAO().selectAll(listaDeEventos);
    }

    /**
     * Busca um evento no banco
     *
     * @param request será utilizado para acessar o id no banco, o parametro do
     * request utlizado é o HttpServletRequest.getParameter("id")
     * @return Evento
     * @throws RuntimeException caso não seja possivel fazer o casting do
     * request.getParameter("id") para int
     */
    public Evento getEventoById(HttpServletRequest request) throws RuntimeException {
        Evento evento = null;
        try {
            int id = Integer.parseInt((String) request.getParameter("id"));//pode gerar exceção
            evento = getEventoByIdInTheList(id);//pegando o evento no arraylist
            if (evento != null) {//o evento esta na lista
                return evento;
            }else {//o evento não esta na lista
                evento = getEventoByIdInTheBase(id);//buscanco o evento no banco . . .
            }
            
        } catch (ClassCastException e) {
            throw new RuntimeException("O id do evento deve ser um numero. Erro: " + e.getMessage());
        }
        return evento;
    }

    /**
     * busca na listaDeEventos um Evento que corresponda ao id
     * @param id    inteiro que representa o id do evento   
     * @return      um Evento que contenha o id ou null caso não haja
     */
    public Evento getEventoByIdInTheList(int id) {
        for (int i = 0; i < listaDeEventos.size(); i++) {
            if (listaDeEventos.get(i).getId_evento() == id) {
                return listaDeEventos.get(i);
            }
        }
        return null;
    }

    /**
     * Busca no banco um evento pelo id
     * @param id    inteiro que deve ser o id do evento
     * @return      o evento correspondente ao id ou null caso não haja
     * @throws RuntimeException lançada pelo DAO
     */
    public Evento getEventoByIdInTheBase(int id) throws RuntimeException{
        return new EventoDAO().getById(id);
    }
    
    /**
     * busca todos os eventos que estao no banco e nao estao na listaDeEventos
     * @throws RuntimeException caso o corra algum erro no EventoDAO
     */
    public void refreshesListaDeEventos() throws RuntimeException{
        listaDeEventos = new EventoDAO().selectAll(listaDeEventos);
    }
}