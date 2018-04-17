/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import laskutusohjelma.Asiakas;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ollijokinen
 */
public class AsiakasTest {
    
    public AsiakasTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    /*@Test
    public void hello() {}*/
    
    @Test
    public void konstruktoriToimiiOikein() {
        Asiakas asiakas = new Asiakas (1, "pena", "1234567-8");
        
        
        
        assertEquals("id: 1, name: pena, yTunnus: 1234567-8", asiakas.toString());
    }
}
