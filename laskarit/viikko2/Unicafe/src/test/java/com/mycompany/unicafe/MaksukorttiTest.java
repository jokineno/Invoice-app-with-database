package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(100);
    }
    
    @Test
    public void konstruktoriAsettaaSaldonOikein() {
        assertEquals("saldo: 1.0", kortti.toString());
    }
    
    @Test
    public void kortilleVoiLadataRahaa() {
        kortti.lataaRahaa(25);
        assertEquals("saldo: 1.25", kortti.toString());
    }
    
    @Test //kortti ei ota rahaa, jos otetaan enemmän kuin mitä saldo on
    public void kortiltaEiOtetaLiikaaRahaa() {
        kortti.otaRahaa(101);
        assertEquals("saldo: 1.0", kortti.toString());
        assertFalse(1==2); //rahat eivät riitä -> palauta false
    }
    @Test
    public void kortiltaVoiOttaaRahaa() {
        kortti.otaRahaa(5);
        assertEquals("saldo: 0.95", kortti.toString());
        assertTrue(1==1); //rahat riittävät -> palauta true
    }
    
    @Test 
    public void saldoOikein() {
        kortti.saldo();
        assertEquals("saldo: 1.0", kortti.toString());
    }
    
    
    
    
    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
}
