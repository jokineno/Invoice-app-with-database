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
    private Integer id;
    private String name; 
    private String yTunnus;
    
    
    public Asiakas (Integer id, String name, String yTunnus) {
        this.id = id;
        this.name = name;
        this.yTunnus = yTunnus;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   
    public String getyTunnus() {
        return yTunnus;
    }

    public void setyTunnus(String yTunnus) {
        this.yTunnus = yTunnus;
    }
    
    public String toString() {
        return "id: " + this.id + ", name: " + this.name + ", yTunnus: " + this.yTunnus;
    }
}
