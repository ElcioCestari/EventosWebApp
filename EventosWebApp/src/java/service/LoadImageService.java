package service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoadImageService {

    private InputStream inputStream;
    private BufferedInputStream bufferedInputStream;
    private BufferedOutputStream bufferedOutputStream;

    public void loadImageFromDiskByImgFullPath(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("image/jpg");
        String fullPath = readImgPathFromRequest(request);
        try {
            inputStream = new FileInputStream(new File(fullPath));
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(response.getOutputStream());
            for(int data; (data = bufferedInputStream.read()) > -1; ){
                bufferedOutputStream.write(data);
            }
        } catch (IOException ex) {
            Logger.getLogger(LoadImageService.class.getName()).log(Level.SEVERE, null, ex);
            throw new IllegalArgumentException("Ocorreu um erro ao abrir a imagem");
        }
    }

    private String readImgPathFromRequest(HttpServletRequest request) {
        String fullPath = request.getParameter("img_path");
        if (fullPath == null) {
            throw new IllegalArgumentException("O caminho " + fullPath + " nao existe");
        }
        return fullPath;
    }
}
