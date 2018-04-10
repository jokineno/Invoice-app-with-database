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

public class AsiakasDao implements Dao <Asiakas, Integer> {
    
    private SQLiteDatabase = database; 
    
     @Override
    public Asiakas findOne(Integer key) throws SQLException {
        // ei toteutettu
        return null;
    }

    @Override
    public List<Asiakas> findAll() throws SQLException {
	// ei toteutettu
	return null;
    }

    @Override
    public Asiakas saveOrUpdate(Asiakas object) throws SQLException {
        // ei toteutettu
        return null;
    }
  
    @Override
    public void delete(Integer key) throws SQLException {
        // ei toteutettu
    }
    
}
