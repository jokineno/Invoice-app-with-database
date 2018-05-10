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
import javafx.collections.ObservableList;
public interface AsiakasDao<T, K> {
    //T findOne(K key) throws SQLException; //tätä tarvitaan kun haetaan nimellä
    ObservableList<T> findAll() throws SQLException; // kun halutaan kaikki esiin valikosta
    K findYNumber(K name) throws SQLException;
    void createCustomer(T customer) throws SQLException;
    //T save(T object) throws SQLException; //halutaan päivittää tietoja
    //void delete(K key) throws SQLException; // halutaan poistaa joku 
}
