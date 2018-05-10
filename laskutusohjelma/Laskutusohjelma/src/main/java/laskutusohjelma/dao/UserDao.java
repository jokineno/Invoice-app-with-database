/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskutusohjelma.dao;

import java.sql.SQLException;
import java.util.List;
import laskutusohjelma.domain.User;

/**
 *
 * @author ollijokinen
 * @param <T>
 * @param <K>
 */
public interface UserDao <T,K> {
    void create(T user) throws SQLException;
    boolean findByUsername(K username) throws SQLException;
    K returnUsernameByName (K name) throws SQLException;
    K returnNameByUsername (K username) throws SQLException;
    K returnYNumber (K name) throws SQLException;
    K returnBankAccount (K username) throws SQLException;
    void save(T user) throws SQLException;
    T returnUserByName (K name) throws SQLException;

}
