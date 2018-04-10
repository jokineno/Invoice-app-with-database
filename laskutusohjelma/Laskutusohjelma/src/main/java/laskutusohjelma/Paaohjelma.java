/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskutusohjelma;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ollijokinen
 */
public class Paaohjelma {
    
    public static void main(String[] args) {
       Connection c = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:asiakasrekisteriDB.db");
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Opened database successfully");
        
    }
    
}
