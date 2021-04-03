package controller.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.LoadImageService;

/**
 *
 * @author elciotaira
 */
@WebServlet(name = "ExibirImagemServlet", urlPatterns = {"/ExibirImagemServlet"})
public class ExibirImagemServlet extends HttpServlet {
    private LoadImageService imageService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.imageService = new LoadImageService();
        this.imageService.loadImageFromDiskByImgFullPath(request, response);
    }

}
