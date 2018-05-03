/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskutusohjelma.ui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import laskutusohjelma.dao.FileUserDao;
import laskutusohjelma.domain.SQLiteDatabase;

/**
 *
 * @author ollijokinen
 */
public class FXMLController implements Initializable {
    private FileUserDao userDao;
    private SQLiteDatabase database;
    
    @FXML
    private TextField username;
    
    /*
    When you call this method, you'll login and change the scene to scene2 where you can
    create an invoice. 
    */
    
    /**
     * loginPressed metodia kutsutaan, kun käyttäjä painaa login etusivulla. Jos tunnus on validi, niin käyttäjä kirjautuu
     * @param event
     * @throws IOException 
     */
    
    @FXML
    public void loginPressed(ActionEvent event) throws IOException, SQLException {
        System.out.println("User loggin' in...");
        
        database = new SQLiteDatabase();
        userDao = new FileUserDao(database);
        if(userDao.findByUsername(username.getText())){
            Parent scene2Parent = FXMLLoader.load(getClass().getResource("/fxml/FXMLLasku.fxml"));
            Scene scene2View = new Scene(scene2Parent);
            createScene(event, scene2View);
        }else {
            System.out.println("yritä uudestaan");
        }
        
        
        
        
    }
    
    /**
     * kun käyttäjä painaa signup niin kirjaudutaan signup sivula
     * @param event
     * @throws IOException 
     */
    
    @FXML
    public void signUpPressed(ActionEvent event) throws IOException {
        System.out.println("Signup pressed...");
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("/fxml/FXMLSignupInfo.fxml"));
        Scene scene2View = new Scene(scene2Parent);
        createScene(event, scene2View);
    }
    
    /**
     * createscene luo uuden scenen - vältetään copypaste koodia
     * @param event
     * @throws IOException 
     */
    
    public void createScene(ActionEvent event, Scene newScene) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Loading user data....");
    }    
    
}
