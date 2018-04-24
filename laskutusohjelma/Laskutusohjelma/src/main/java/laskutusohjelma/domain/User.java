/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskutusohjelma.domain;

/**
 *
 * @author ollijokinen
 */
public class User {
    private String name; 
    private String username; //email address
    private String ytunnus;
    private String tilinumero;
    
    //tähän on lisätty tilinumero -> muokkaa testejä
    public User (String name, String username, String ytunnus, String tilinumero) {
        this.name = name; 
        this.username = username; 
        this.ytunnus = ytunnus;
        this.tilinumero = tilinumero;
    }

    public String getName() {
        return this.name;
    }

    public String getUsername() {
        return this.username;
    }
    
    public String getYtunnus () {
        return this.ytunnus;
    }
    
    public String getTilinumero() {
        return this.tilinumero;
    }
    
    public String toString() {
        return "name: " + this.name + ", username: " + this.username + ", yTunnus: " + this.ytunnus + ", tilinumero: " + this.tilinumero;
    }
}
