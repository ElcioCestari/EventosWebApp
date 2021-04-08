package dao;

import connections.ConnectionFactory;
import entidade.Mapa;

/**
 *
 * @author Elcio Cestari Taira
 */
public class MapaDAO extends ConnectionFactory implements InterfaceDAO<Mapa>{ 

    @Override
    public Mapa create(Mapa t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Mapa upDate(Mapa t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Mapa findById(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
