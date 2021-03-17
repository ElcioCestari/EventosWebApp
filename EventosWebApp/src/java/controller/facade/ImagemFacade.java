package controller.facade;

import java.sql.SQLException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import model.banco.dao.ImagemEventoDAO;
import model.entidade.Imagem;
import util.enums.PathEnums;

/**
 *
 * @author elciotaira
 */
public class ImagemFacade {
    private ImagemEventoDAO imagemDAO;
    public ImagemFacade() throws SQLException, ClassNotFoundException {
        this.imagemDAO = new ImagemEventoDAO();
    }
    public Imagem salvarImagem(HttpServletRequest request) throws Exception {
        Imagem img = mapRequestToImagem(request);
        salvarNoBanco(img);
        return img;
    }
    private Imagem mapRequestToImagem(HttpServletRequest request) {
        String nome = "teste";
        if (nome == null || nome.trim().equals("")) {
            throw new IllegalArgumentException("Nome da imagem nao pode ser nulo");
        }
        Imagem img = new Imagem();
        img.setNome(nome);
        img.setPath(configureImagemPath());
        return img;
    }
    private void salvarNoBanco(Imagem img) throws Exception {
        this.imagemDAO.create(img);
    }

    private String configureImagemPath() {
        return PathEnums.PATH.value + "/nome-aleatorio.png";
    }
}
