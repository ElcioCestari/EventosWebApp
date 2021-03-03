package model.banco;

import java.sql.Connection;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author elciotaira
 */
public class ConnectionFactoryIT {
    /**
     * Test of getConnection method, of class ConnectionFactory.
     */
    @Test
    public void testGetConnection() throws Exception {
        System.out.println("getConnection");
        ConnectionFactory instance = new ConnectionFactory();
        Connection result = instance.getConnection();
        assertNotNull(result);
    }
}
