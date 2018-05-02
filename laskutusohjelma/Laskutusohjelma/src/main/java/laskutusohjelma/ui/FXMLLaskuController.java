package laskutusohjelma.ui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ollijokinen
 */
public class FXMLLaskuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    public void logoutPressed(ActionEvent event) throws IOException {
        System.out.println("user loggin out...");
        Parent scene1Parent = FXMLLoader.load(getClass().getResource("/fxml/FXML.fxml"));
        Scene scene1View = new Scene(scene1Parent);
        
        //this line get stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene1View);
        window.show();
    }
    
    @FXML
    public void profilePressed(ActionEvent event) throws IOException {
        System.out.println("loading profile..");
        Parent scene1Parent = FXMLLoader.load(getClass().getResource("/fxml/FXMLProfile.fxml"));
        Scene scene1View = new Scene(scene1Parent);
        
        //this line get stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene1View);
        window.show();
    }
    
    @FXML
    public void createPdfInvoicePressed(ActionEvent event) {
        
    }
    
    
    @FXML
    public boolean logInInformation() {
        return true;
    }
    
            
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
