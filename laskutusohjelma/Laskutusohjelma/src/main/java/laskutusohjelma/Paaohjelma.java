/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskutusohjelma;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ollijokinen
 */
public class Paaohjelma {
    
    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/ollijokinen/Documents/Yliopisto/Tietojenkäsittelytiede/otm-harjoitustyo/laskutusohjelma/asiakasrekisteriDB.db");
        
        //LUODAAN KYSELY, JOLLA HAETAAN KAIKKI ASIAKASREKISTERISTÄ
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM ASIAKAS");
        ResultSet rs = statement.executeQuery();
        
        List<Asiakas> asiakkaat = new ArrayList<>();
        
        while (rs.next()) {
            Asiakas a = new Asiakas (rs.getInt("id"), rs.getString("name"), rs.getString("ytunnus"));
            
            asiakkaat.add(a);
        }
        
        for (Asiakas a : asiakkaat) {
            System.out.println(a);
        }
        statement.close();
        rs.close();
        
        connection.close();
        
        
    }
    
}