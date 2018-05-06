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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import laskutusohjelma.dao.FileUserDao;
import laskutusohjelma.domain.SQLiteDatabase;
import laskutusohjelma.domain.User;

/**
 * FXML Controller class
 *
 * @author ollijokinen
 */
public class FXMLSignupInfoController implements Initializable {
    
    /**
     * Initializes the controller class.
     */
    
    private FileUserDao userDao;
    private SQLiteDatabase database;
    
    @FXML
    private TextField username;
    
    @FXML
    private TextField password;
    
    @FXML
    private TextField companyname;
    
    @FXML
    private TextField accountNumber;
    
    @FXML
    private TextField yNumber;
    
    
   /* private SQLiteDatabase database;
    private FileUserDao userDatabase;
    */
     /**
     * käyttäjä luo uuden tilin
     * @param event
     * @throws IOException 
     */
    
    /**
     * käyttäjä luo uuden tilin
     * @param event
     * @throws IOException
     * 
     */
    public void createAccountPressed(ActionEvent event) throws IOException, SQLException {
        System.out.println("Creating an account and signing up...");
        
        User user = new User(companyname.getText(), username.getText(), yNumber.getText(), accountNumber.getText());
        userDao = new FileUserDao(database);
        userDao.create(user);
        
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/FXMLLasku.fxml"));
        Parent scene1Parent = loader.load();
        Scene scene1View = new Scene(scene1Parent);
        
        FXMLLaskuController controller = loader.getController();
        controller.initData(companyname.getText());
        controller.fillComboBox();
        createScene(event, scene1View);
        
    }
    
     /**
     * käyttäjä voi palata etusivulle
     * @param event
     * @throws IOException 
     */
    
    public void backPressed(ActionEvent event) throws IOException {
        System.out.println("Signup pressed...");
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("/fxml/FXML.fxml"));
        Scene scene2View = new Scene(scene2Parent);
        createScene(event, scene2View);
        
    }
    
     /**
     * vältetään toisteista koodia. luodaan uusi scene
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
        // TODO
    }    
    
}
