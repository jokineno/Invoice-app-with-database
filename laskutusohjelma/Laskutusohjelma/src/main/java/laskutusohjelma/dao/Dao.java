package laskutusohjelma.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ollijokinen
 */
import java.util.*;
import java.sql.*;
public interface Dao <T,K> {
    T findOne(K key) throws SQLException; //tätä tarvitaan kun haetaan nimellä
    List<T> findAll() throws SQLException; // kun halutaan kaikki esiin valikosta
    T save(T object) throws SQLException; //halutaan päivittää tietoja
    void delete(K key) throws SQLException; // halutaan poistaa joku 
}
