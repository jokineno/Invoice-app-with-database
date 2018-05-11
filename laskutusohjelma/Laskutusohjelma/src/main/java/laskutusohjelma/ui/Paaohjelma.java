
package laskutusohjelma.ui;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import laskutusohjelma.dao.FileAsiakasDao;
import laskutusohjelma.dao.FileUserDao;
import laskutusohjelma.domain.InvoiceService;
import laskutusohjelma.domain.SQLiteDatabase;

/**
 * Sets the program and gives methods to move from scene to scene
 * @author ollijokinen
 */
public class Paaohjelma extends Application {
    
    Stage stage; 
    Scene startViewScene, signUpScene, invoiceScene, profileScene;
    
    private InvoiceService invoiceService; 
   
    
    /**
     * builds and opens login scene
     * @param stage stage
     * @throws Exception avoid system failure
     */
    @Override
    public void start(Stage stage) throws Exception {
        //building and loading scene
        this.stage = stage;
        setLoginScene();
        stage.show();
        
    }
    
    /**
     * downloads views, sets FileUserDao, FileAsiakasDao, SQLiteDatabase,
     * Invoice Service, and sets database configurations. 
     * @throws Exception avoid system failure
     */
    @Override 
    public void init() throws Exception {
        //properties define database configurations
        Properties properties = new Properties();
        properties.load(new FileInputStream("config.properties"));
        String databaseFile = properties.getProperty("mainDatabase");
        SQLiteDatabase database = new SQLiteDatabase(databaseFile);
        
        FileUserDao userDao = new FileUserDao(database);
        FileAsiakasDao asiakasDao = new FileAsiakasDao(database);
        
        invoiceService = new InvoiceService(userDao, asiakasDao, database);
        invoiceService.createTables();
        
        FXMLLoader startView = new FXMLLoader(getClass().getResource("/fxml/FXML.fxml"));
        Parent loginPane = startView.load();
        FXMLController startViewController = startView.getController();
        startViewController.setInvoiceService(invoiceService); 
        startViewController.setApplication(this);
        startViewScene = new Scene(loginPane);
        
        FXMLLoader signUpView = new FXMLLoader(getClass().getResource("/fxml/FXMLSignupInfo.fxml"));
        Parent signUpPane = signUpView.load();
        FXMLSignupInfoController signUpViewController = signUpView.getController();
        signUpViewController.setInvoiceService(invoiceService); 
        signUpViewController.setApplication(this);
        signUpScene = new Scene(signUpPane);
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/FXMLLasku.fxml"));
        Parent invoicePane = loader.load();
        FXMLLaskuController invoiceViewController = loader.getController();
        invoiceViewController.setInvoiceService(invoiceService); 
        invoiceViewController.setApplication(this);
        invoiceViewController.fillReceiverAndYNumber();
        invoiceViewController.fillComboBox();
        invoiceViewController.initData();
        invoiceScene = new Scene(invoicePane);
        
        
        FXMLLoader profileView = new FXMLLoader(getClass().getResource("/fxml/Profile.fxml"));
        Parent profilePane = profileView.load();
        ProfileController profileViewController = profileView.getController();
        profileViewController.setInvoiceService(invoiceService); 
        profileViewController.setApplication(this);
        profileScene = new Scene(profilePane);
       
    }
    
    /**
     * builds loginscene
     */
    public void setLoginScene() {
        stage.setScene(startViewScene);
    }
    
    /**
     * builds signup scene
     */
    public void setSignUpScene() {
        stage.setScene(signUpScene);
    }   
    
    /**
     * builds profile scene
     */
    public void setProfileScene() {
        stage.setScene(profileScene);
    }
    
    /**
     * 
     * @throws IOException input output error
     * @throws SQLException database error
     */
    public void setProfileScene2() throws IOException, SQLException {
        FXMLLoader profileView = new FXMLLoader(getClass().getResource("/fxml/Profile.fxml"));
        Parent profilePane = profileView.load();
        ProfileController profileViewController = profileView.getController();
        profileViewController.setInvoiceService(invoiceService); 
        profileViewController.setApplication(this);
        profileViewController.initDataToProfile1();
        profileViewController.initUserName();
        profileScene = new Scene(profilePane);
        stage.setScene(profileScene);
    }
    
    /**
     * builds invoice scene. used in init method
     */
    public void setInvoiceScene() {
        stage.setScene(invoiceScene);
    }
    
    /**
     * builds invoice scene while using a program. Downloads also a combobox and receiver and yNumber textfields based on a selection. 
     * @throws IOException input output error
     * @throws SQLException database error catch
     */
    public void setInvoiceScene2() throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/FXMLLasku.fxml"));
        Parent invoicePane = loader.load();
        FXMLLaskuController invoiceViewController = loader.getController();
        invoiceViewController.setInvoiceService(invoiceService); 
        invoiceViewController.setApplication(this);
        invoiceViewController.fillReceiverAndYNumber();
        invoiceViewController.fillComboBox();
        invoiceViewController.initData();
        invoiceScene = new Scene(invoicePane);
        stage.setScene(invoiceScene);
    }
    
    /**
     * Launches a program
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

   
