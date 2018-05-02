/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskutusohjelma.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
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
public class FXMLSignupInfoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    public void createAccountPressed(ActionEvent event) throws IOException {
        System.out.println("Creating an account...");
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("/fxml/FXMLLasku.fxml"));
        Scene scene2View = new Scene(scene2Parent);
        
        //this line get stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene2View);
        window.show();
    }
    
    public void backPressed(ActionEvent event) throws IOException {
        System.out.println("Signup pressed...");
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("/fxml/FXML.fxml"));
        Scene scene2View = new Scene(scene2Parent);
        
        //this line get stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene2View);
        window.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
