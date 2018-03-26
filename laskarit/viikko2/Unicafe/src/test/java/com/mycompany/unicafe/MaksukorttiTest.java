package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }
    
    @Test
    public void konstruktoriAsettaaSaldonOikein() {
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void kortilleVoiLadataRahaa() {
        kortti.lataaRahaa(25);
        assertEquals("saldo: 0.35", kortti.toString());
    }
    
    @Test //kortti ei ota rahaa, jos otetaan enemmän kuin mitä saldo on
    public void kortiltaEiOtetaLiikaaRahaa() {
        kortti.otaRahaa(12);
        assertEquals("saldo: 0.10", kortti.toString());
        assertFalse(1==2); //rahat eivät riitä -> palauta false
    }
    @Test
    public void kortiltaVoiOttaaRahaa() {
        kortti.otaRahaa(5);
        assertEquals("saldo: 0.05", kortti.toString());
        assertTrue(1==1); //rahat riittävät -> palauta true
        
    }
    
    
    
    
    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
}
