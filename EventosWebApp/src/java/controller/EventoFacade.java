/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import banco.dao.EventoDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Evento;
import model.Usuario;

/**
 * Essa classe prove uma abstração maior para poder acessar os recursos que são
 * relacionados aos Eventos. tais como: Criar evento, curtir evento, cancelar
 * curtir evento, etc.
 *
 * @author Elcio Cestari Taira
 */
public abstract class EventoFacade {

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

    }
}
