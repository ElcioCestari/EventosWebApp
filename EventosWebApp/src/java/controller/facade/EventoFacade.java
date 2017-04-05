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
public abstract class EventoFacade {
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
    public static void criarEvento(HttpServletRequest request) throws Exception {

        String nomeEvento = (String) request.getParameter("nomeEvento");
        String tipo = (String) request.getParameter("tipo_evento");
        String descricao = (String) request.getParameter("descricao");
        double valor = Double.parseDouble(request.getParameter("valor"));
        int faixaEtaria = Integer.parseInt(request.getParameter("faixaEtaria"));
         

        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        
        Evento evento = new Evento(tipo, descricao, valor, faixaEtaria, nomeEvento, usuario.getId_usuario());

        new EventoDAO().create(evento);
        
        if(listaDeEventos == null){
            listaDeEventos = new ArrayList<>();
        }
        listaDeEventos.add(evento);
        String teste;

    }
    
    /**
     * retorna uma lista contentdo todos os eventos salvos no sistemas
     * @return Arraylist    uma lista contendo todos os eventos.
     */
    public static ArrayList<Evento> getListaDeEventos() {
        return listaDeEventos;
    }
    
    
    
    
    

}
