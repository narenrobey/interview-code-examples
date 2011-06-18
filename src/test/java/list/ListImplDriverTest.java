/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package list;

import list.ListImplDriver;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author robeyna
 */
public class ListImplDriverTest {

    public ListImplDriverTest()
    {
    }

    /**
     * Test of main method, of class ListImplDriver.
     */
    @Test
    public void testMain()
    {
        String[] args = null;
        ListImplDriver.main(args);
        assertTrue(true);
    }
    
    @Test
    public void testCreateDriver()
    {	
    	new ListImplDriver();
    }

}