package model.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.banco.ConnectionFactory;
import model.banco.util.enums.NomeTabelaEnum;
import model.entidade.Imagem;
/**
 *
 * @author elciotaira
 */
public class ImagemEventoDAO implements InterfaceDAO<Imagem>{
    
    private Connection con;
    private static final String tabela =  NomeTabelaEnum.IMAGEM.nome;

    public ImagemEventoDAO() throws ClassNotFoundException, SQLException {
        this.con = new ConnectionFactory().getConnection();
    }
    
    @Override
    public void create(Imagem imagem) throws SQLException {
        String sql = "INSERT INTO " + tabela + "(nome,path)values(?,?);";
        
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, imagem.getNome());
        statement.setString(2, imagem.getPath());
        statement.execute();
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void upDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Imagem findById(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
