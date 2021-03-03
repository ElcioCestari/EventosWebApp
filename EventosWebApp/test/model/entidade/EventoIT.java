package model.entidade;

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
public class EventoIT {
    
    public EventoIT() {
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
     * Test of getFaixaEtaria method, of class Evento.
     */
    @Test
    public void testGetFaixaEtaria() {
        System.out.println("getFaixaEtaria");
        Evento instance = new Evento();
        int expResult = 0;
        int result = instance.getFaixaEtaria();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFaixaEtaria method, of class Evento.
     */
    @Test
    public void testSetFaixaEtaria() {
        System.out.println("setFaixaEtaria");
        int faixaEtaria = 0;
        Evento instance = new Evento();
        instance.setFaixaEtaria(faixaEtaria);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId_evento method, of class Evento.
     */
    @Test
    public void testGetId_evento() {
        System.out.println("getId_evento");
        Evento instance = new Evento();
        int expResult = 0;
        int result = instance.getId_evento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTipo method, of class Evento.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        Evento instance = new Evento();
        String expResult = "";
        String result = instance.getTipo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTipo method, of class Evento.
     */
    @Test
    public void testSetTipo() {
        System.out.println("setTipo");
        String tipo = "";
        Evento instance = new Evento();
        instance.setTipo(tipo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescricao method, of class Evento.
     */
    @Test
    public void testGetDescricao() {
        System.out.println("getDescricao");
        Evento instance = new Evento();
        String expResult = "";
        String result = instance.getDescricao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescricao method, of class Evento.
     */
    @Test
    public void testSetDescricao() {
        System.out.println("setDescricao");
        String descricao = "";
        Evento instance = new Evento();
        instance.setDescricao(descricao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValor method, of class Evento.
     */
    @Test
    public void testGetValor() {
        System.out.println("getValor");
        Evento instance = new Evento();
        double expResult = 0.0;
        double result = instance.getValor();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValor method, of class Evento.
     */
    @Test
    public void testSetValor() {
        System.out.println("setValor");
        double valor = 0.0;
        Evento instance = new Evento();
        instance.setValor(valor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNome method, of class Evento.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Evento instance = new Evento();
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNome method, of class Evento.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "";
        Evento instance = new Evento();
        instance.setNome(nome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId_usuario method, of class Evento.
     */
    @Test
    public void testGetId_usuario() {
        System.out.println("getId_usuario");
        Evento instance = new Evento();
        int expResult = 0;
        int result = instance.getId_usuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId_usuario method, of class Evento.
     */
    @Test
    public void testSetId_usuario() {
        System.out.println("setId_usuario");
        int id_usuario = 0;
        Evento instance = new Evento();
        instance.setId_usuario(id_usuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
