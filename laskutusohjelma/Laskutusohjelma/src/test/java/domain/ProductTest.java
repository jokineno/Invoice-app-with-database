/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import laskutusohjelma.domain.Product;
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
public class ProductTest {
    private Product product;
    
    public ProductTest() {
        
    }
    
   
    
    @Before
    public void setUp() {
        product = new Product("beer", 24, 100, 100.5, 10, "oujeah", "21.2.2012");
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void constructorTest() {
        assertEquals("beer", product.toString());
    }
    
    @Test
    public void nameTest() {
        assertEquals("beer", product.getPname());
    }
    
    @Test
    public void vatTest() {
        assertEquals(24, product.getVat());
    }
    
    @Test
    public void amountTest() {
        assertTrue(100.5 == product.getAmount());
    }
    
    @Test
    public void ppuTest() {
        assertTrue(10 == product.getPpu());
    }
    
    @Test
    public void messageTest() {
        assertEquals("oujeah", product.getMessage());
    }
    
    @Test
    public void dateTest() {
        assertEquals("21.2.2012", product.getDate());
    }   
    
    @Test
    public void setAmountTest() {
        product.setAmount(1);
        assertTrue(1 == product.getAmount());
    }
    
    @Test
    public void getPrice() {
        assertTrue(100 == product.getPrice());
    }
}
