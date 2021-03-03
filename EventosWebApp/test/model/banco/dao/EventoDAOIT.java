package model.banco.dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import model.entidade.Evento;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author elciotaira
 */
public class EventoDAOIT {
    public EventoDAOIT() {
    }
    @BeforeClass
    public static void setUpClass() {
    }
    @AfterClass
    public static void tearDownClass() {
    }
    @Before
    public void setUp() {
    }
    @After
    public void tearDown() {
    }

    /**
     * Test of selectAll method, of class EventoDAO.
     */
    @Test
    public void testSelectAll() {
        System.out.println("selectAll");
        ArrayList<Evento> list = null;
        EventoDAO instance = new EventoDAO();
        
        ArrayList<Evento> expResult = null;
        ArrayList<Evento> result = instance.selectAll(list);
        assertEquals(expResult, result);
    }
}
