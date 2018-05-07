/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskutusohjelma.ui;

import java.sql.SQLException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import laskutusohjelma.dao.FileAsiakasDao;
import laskutusohjelma.dao.FileUserDao;
import laskutusohjelma.domain.SQLiteDatabase;

/**
 *
 * @author ollijokinen
 */
public class Paaohjelma extends Application {
    
    Stage window; 
    Scene scene1, scene2;
    private SQLiteDatabase database;
    
    public void initializeDatabase() throws SQLException {
        database.getConnection();
    }
    
    
    @Override
    public void start(Stage stage) throws Exception {
        //initializing database
        initializeDatabase();
        
        //building and loading scene
        window = stage;
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/FXML.fxml"));
        window.initStyle(StageStyle.DECORATED);
        
        scene1 = new Scene(root);
        
        window.setScene(scene1);
        window.show();
        
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

   
