/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import model.banco.dao.LocalDAO;
import model.entidade.Endereco;
import model.entidade.Local;

/**
 *
 * @author Elcio Cestari Taira
 */
public class LocalFacade {

    private static ArrayList<Local> listaDeLocais;
    public void criarLocal(HttpServletRequest request, Endereco endereco) throws RuntimeException, ClassCastException, ClassNotFoundException, SQLException {
        Local local;
        int capacidade;
        String nome;

        try {
            capacidade = Integer.parseInt(request.getParameter("capacidade"));
            nome = (String) request.getParameter("nome");
        } catch (ClassCastException e) {
            throw new RuntimeException("Não foi possível fazer a conversao dos dados");
        }
        
        local = new Local(nome, capacidade);
        new LocalDAO().create(local);
        
        if(listaDeLocais == null){
            listaDeLocais = new ArrayList<Local>();
        }
        listaDeLocais.add(local);

    }
}
