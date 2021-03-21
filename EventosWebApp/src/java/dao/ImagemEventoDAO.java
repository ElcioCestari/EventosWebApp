package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import connections.ConnectionFactory;
import dao.util.enums.NomeTabelaEnum;
import entidade.Imagem;
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
    public Imagem create(Imagem imagem) throws SQLException {
        String sql = "INSERT INTO " + tabela + "(nome,path, fk_evento)values(?,?,?);";
        
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, imagem.getNome());
        statement.setString(2, imagem.getPath());
        statement.setInt(3, imagem.getFk_evento());
        statement.execute();
        
        return null;
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Imagem upDate(Imagem imagem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Imagem findById(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
