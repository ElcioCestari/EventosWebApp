package dao;

import com.mysql.cj.protocol.Resultset;
import connections.ConnectionFactory;
import dao.util.enums.ImagemEventoColumnsNameEnum;
import dao.util.enums.NomeTabelaEnum;
import entidade.Imagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author elciotaira
 */
public class ImagemEventoDAO implements InterfaceDAO<Imagem> {

    private Connection con;
    private static final String tabela = NomeTabelaEnum.IMAGEM.nome;

    public ImagemEventoDAO() throws ClassNotFoundException, SQLException {
        this.con = new ConnectionFactory().getConnection();
    }

    @Override
    public Imagem create(Imagem imagem) throws SQLException {
        String sql = "INSERT INTO " + tabela + "(nome,path, fk_evento)values(?,?,?);";

        try {
            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, imagem.getNome());
            statement.setString(2, imagem.getPath());
            statement.setInt(3, imagem.getFk_evento());
            Integer rowsAfected = statement.executeUpdate();
            if (rowsAfected != null) {
                ResultSet result = statement.getGeneratedKeys();
                return this.findById(result.getInt("id"));
            }
        } catch (Exception e) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Imagem upDate(Imagem imagem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Imagem findById(int id) throws SQLException {
        String query = "SELECT * FROM " + tabela + " WHERE id = ?;";
        PreparedStatement statement = this.con.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();

        Imagem img = new Imagem();
        while (result.next()) {
            img.setId(result.getInt("id"));
            img.setFk_evento(result.getInt("fk_evento"));
//            img.setNome(result.getString("nome");
            img.setPath(result.getString("path"));
        }
        return img;
    }

    public List<Imagem> findByFkEvento(Integer fkEvento) throws SQLException {
        String sql = "SELECT * FROM " + tabela + " WHERE " + ImagemEventoColumnsNameEnum.FK_EVENTO.value + " = ?;";
        List<Imagem> imagens = new ArrayList<>();
        Imagem img = null;
        try {
            PreparedStatement preparedStatement = this.con.prepareStatement(sql);
            preparedStatement.setInt(1, fkEvento);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                img = new Imagem();
                img.setId(resultSet.getInt(ImagemEventoColumnsNameEnum.ID.value));
                img.setFk_evento(resultSet.getInt(ImagemEventoColumnsNameEnum.FK_EVENTO.value));
                img.setNome(resultSet.getString(ImagemEventoColumnsNameEnum.NOME.value));
                img.setPath(resultSet.getString(ImagemEventoColumnsNameEnum.PATH.value));
                imagens.add(img);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImagemEventoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException(ex.getMessage());
        }
        return imagens;
    }
}
