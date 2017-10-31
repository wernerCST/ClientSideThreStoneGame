/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stones;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
/**
 * This class when run will lunch the application it 
 * launches the IPInputFXML view.
 * @author 1511430
 */

public class MainApp extends Application {

    private Stage stage;
    private Stage primaryStage;
    private Parent rootPane;
    
    public MainApp() {
        super();        
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
        initRootLayout();
        primaryStage.show(); 
    }
    public void initRootLayout() {
        try {
            // Instantiate a FXMLLoader object
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/IPInputFXML.fxml"));
            rootPane = (AnchorPane) loader.load();
            Scene scene = new Scene(rootPane);
            primaryStage.setScene(scene);
        } catch (IOException ex) {
            errorAlert(ex.getMessage());
        }
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    private void errorAlert(String msg) {
        Alert dialog = new Alert(Alert.AlertType.ERROR);
        dialog.setTitle("Error");
        dialog.setHeaderText("!!");
        dialog.setContentText(msg);
        dialog.show();
    }  
}
