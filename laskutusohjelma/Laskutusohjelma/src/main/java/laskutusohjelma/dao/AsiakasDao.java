package laskutusohjelma.dao;


import java.util.*;
import java.sql.*;
import javafx.collections.ObservableList;

/**
 * defines methods used in FileAsiakasDao
 * @author ollijokinen
 * @param <T> first parameter 
 * @param <K> second parameter
 */
public interface AsiakasDao<T, K> {
    ObservableList<T> findAll() throws SQLException;
    K findYNumber(K name) throws SQLException;
    void createCustomer(T customer) throws SQLException;
    
}
