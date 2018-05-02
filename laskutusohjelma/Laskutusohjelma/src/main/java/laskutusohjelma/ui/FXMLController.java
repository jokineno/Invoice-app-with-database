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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author ollijokinen
 */
public class FXMLController implements Initializable {
    
    @FXML
    private Label label;
    private Button button; //login
    
    /*
    When you call this method, you'll login and change the scene to scene2 where you can
    create an invoice. 
    */
    
    @FXML
    public void loginPressed(ActionEvent event) throws IOException {
        System.out.println("User loggin' in...");
        
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("/fxml/FXMLLasku.fxml"));
        Scene scene2View = new Scene(scene2Parent);
        createScene(event, scene2View);
    }
    
    @FXML
    public void signUpPressed(ActionEvent event) throws IOException {
        System.out.println("Signup pressed...");
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("/fxml/FXMLSignupInfo.fxml"));
        Scene scene2View = new Scene(scene2Parent);
        createScene(event, scene2View);
    }
    
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
