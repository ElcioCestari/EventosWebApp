package service;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import dao.LocalDAO;
import entidade.Endereco;
import entidade.Local;

/**
 *
 * @author Elcio Cestari Taira
 */
public class LocalFacade {

    private static ArrayList<Local> listaDeLocais;
    public void criarLocal(HttpServletRequest request, Endereco endereco) throws RuntimeException, ClassCastException, ClassNotFoundException, SQLException, Exception {
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
