/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskutusohjelma;

/**
 *
 * @author ollijokinen
 */
public class Asiakas {
    private String nimi; 
    private String tilinumero;
    private String yTunnus;
    
    
    public Asiakas (String nimi, String tilinumero, String yTunnus) {
        this.nimi = nimi;
        this.tilinumero = tilinumero;
        this.yTunnus = yTunnus;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getTilinumero() {
        return tilinumero;
    }

    public void setTilinumero(String tilinumero) {
        this.tilinumero = tilinumero;
    }

    public String getyTunnus() {
        return yTunnus;
    }

    public void setyTunnus(String yTunnus) {
        this.yTunnus = yTunnus;
    }
}
