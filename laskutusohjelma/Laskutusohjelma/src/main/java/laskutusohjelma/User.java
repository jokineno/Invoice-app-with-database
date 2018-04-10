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
public class User {
    private String name; 
    private String username; 
    private String ytunnus;
    
    public User (String name, String username, String ytunnus) {
        this.name = name; 
        this.username = username; 
        this.ytunnus = ytunnus;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }
    
    
}
