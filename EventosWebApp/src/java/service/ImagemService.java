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
public class ImagemService {

    private ImagemEventoDAO imagemDAO;

    public ImagemService() throws SQLException, ClassNotFoundException {
        this.imagemDAO = new ImagemEventoDAO();
    }

    public Imagem salvarImagem(HttpServletRequest request, Evento evento) throws Exception {
        Imagem img = prepararImgParaSalvarNoBanco(request, evento);
        salvarNoBanco(img);
        return img;
    }

    private Imagem mapRequestToImagem(HttpServletRequest request) {
        String nome = getImgNameFromRequest(request);
        Imagem img = new Imagem();
        img.setNome(nome);
        img.setPath(configureImagemPath(img));
        return img;
    }

    private Imagem salvarNoBanco(Imagem img) throws Exception {
        return this.imagemDAO.create(img);
    }

    private String configureImagemPath(Imagem img) {
        return PathEnums.PATH.value + "/" + img.getFk_evento() + "/" + img.getNome() + "";
    }

    private Imagem prepararImgParaSalvarNoBanco(HttpServletRequest request, Evento evento) {
        Imagem img = mapRequestToImagem(request);
        img.setFk_evento(evento.getId_evento());
        return img;
    }

    private String getImgNameFromRequest(HttpServletRequest request) {
        String nome = null;
        try {
            nome = (String) request.getParameter("nomeImagem");
            if (nome.trim().equals("")) {
                throw new IllegalArgumentException("Nome da imagem nao pode ser nulo");
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Nome da imagem nao pode ser nulo");
        }
        return nome;
    }
}
