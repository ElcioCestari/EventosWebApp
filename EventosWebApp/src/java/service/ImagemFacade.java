package service;

import java.sql.SQLException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import dao.ImagemEventoDAO;
import entidade.Evento;
import entidade.Imagem;
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
    public Imagem salvarImagem(HttpServletRequest request, Evento evento) throws Exception {
        Imagem img = prepararImgParaSalvarNoBanco(request, evento);
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

    private Imagem prepararImgParaSalvarNoBanco(HttpServletRequest request, Evento evento) {
        Imagem img = mapRequestToImagem(request);
        img.setFk_evento(evento.getId_evento());
        return img;
    }
}
