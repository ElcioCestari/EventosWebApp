package service;

import dao.ImagemEventoDAO;
import entidade.Evento;
import entidade.Imagem;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import util.enums.PathEnums;

/**
 *
 * @author elciotaira
 */
public class ImagemService {

    private ImagemEventoDAO imagemDAO;
    private Part filePart;

    public ImagemService() throws SQLException, ClassNotFoundException {
        this.imagemDAO = new ImagemEventoDAO();
    }

    public Imagem salvarImagem(HttpServletRequest request, Evento evento) throws Exception {
        Imagem img = prepararImgParaSalvarNoBanco(request, evento);
        this.salvarImagemNoDiretorio(img);
        salvarCaminhoDaImagemNoBanco(img);
        return img;
    }

    private Imagem mapRequestToImagem(HttpServletRequest request) {
        Imagem img = null;
        try {
            filePart = request.getPart("nomeImagem");
            final String fileName = filePart.getName();
            final String path = configureImagemPath(fileName);
            img = new Imagem();
            img.setNome(fileName);
            img.setPath(path);
        } catch (IOException ex) {
            Logger.getLogger(ImagemService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(ImagemService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return img;
    }

    private Imagem salvarCaminhoDaImagemNoBanco(Imagem img) throws Exception {
        return this.imagemDAO.create(img);
    }

    private String configureImagemPath(String imgName) {
        return PathEnums.PATH.value + File.separator + imgName;
    }

    private Imagem prepararImgParaSalvarNoBanco(HttpServletRequest request, Evento evento) {
        Imagem img = mapRequestToImagem(request);
        img.setFk_evento(evento.getId_evento());
        return img;
    }

    /**
     * @deprecated - este metodo foi depreciado pois estou realizando outra
     * abordagem.
     * @param request
     * @return
     */
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

    private void salvarImagemNoDiretorio(Imagem img) {
        OutputStream out = null;
        InputStream filecontent = null;
        try {
            out = new FileOutputStream(new File(img.getPath()));
            filecontent = filePart.getInputStream();
            int read = 0;
            final byte[] bytes = new byte[1024];
            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            Logger.getLogger(Level.INFO + "imagem salva com sucesso");
        } catch (Exception e) {
            Logger.getLogger(Level.WARNING + e.getMessage());
            throw new RuntimeException("erro ao salvar a imagem do evento");
        }

    }
}
