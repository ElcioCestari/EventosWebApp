/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import dao.EnderecoDAO;
import entidade.Endereco;

/**
 * Esta classe implementa os metodos para criação de um evento
 *
 * @author Elcio Cestari Taira
 * @version 1.0
 * @since 06/abr/2017
 */
public class EnderecoFacade {

    private Endereco endereco;
    private static ArrayList<Endereco> listaDeEndereco;

    /**
     * Metodo que abstrai os processos para criação de um endero e salvamento de
     * um endereço no banco
     *
     * @param request   <code>HttpServletRequest</code> contendo os atributos
     * necessarios para instanciar um objeto do tipo <code>Endereco</code>
     * @throws Exception podendo ser NullPointerException ou ClassCastException
     * @see Endereco
     */
    public void criaEndereco(HttpServletRequest request) throws Exception {
        try {
            
            int numero = Integer.parseInt(request.getParameter("numero"));//fazendo castingo. pode lançar ClassCastException 
            String rua = (String) request.getParameter("rua"); //fazendo castingo. pode lançar ClassCastException
            String bairro = (String) request.getParameter("bairro"); //fazendo castingo. pode lançar ClassCastException
            String cidade = (String) request.getParameter("cidade"); //fazendo castingo. pode lançar ClassCastException
            String estado = (String) request.getParameter("estado");//fazendo castingo. pode lançar ClassCastException

            endereco = new Endereco(numero, rua, bairro, cidade, estado);//instanciando objeto. pode lançar illegalARgumentException
            new EnderecoDAO().create(endereco);
            
            if(listaDeEndereco == null){
                listaDeEndereco = new ArrayList<Endereco>();
            }
            listaDeEndereco.add(endereco);
            
            new LocalFacade().criarLocal(request, endereco);
            
        } catch (ClassCastException e) {
            throw new RuntimeException(" " + e.getMessage());
        } catch (NullPointerException e) {
            throw new RuntimeException("Houve um erro: " + e.getLocalizedMessage());
        }
    }

    /**
     * Metodo que configura a variavel 'endereco' com o Endereco.toString() e
     * pode ser utilizado no JSP
     *
     * @param request HttpServletRequest contendo as requisições do usuario
     * @throws RuntimeException caso o atributo endereco não tenha sido instanciado 
     */
    public void configuraAtributoEnderecoDoRequest(HttpServletRequest request) throws RuntimeException{
        try {
            request.setAttribute("endereco", this.endereco.toString());//configurando variavel para ser utilizada nos JSP. pode gerar NullPointerException
        } catch (NullPointerException e) {
            throw new RuntimeException(" " + e.getMessage());
        }
    }
}
