/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stones;

import com.mycompany.clientside.connection.Connection;
import com.mycompany.clientside.connection.Connection;
import com.mycompany.controllers.IPInputFXMLController;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
/**
 *
 * @author 1511430
 */

public class MainApp extends Application {

    private Stage stage;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        this.stage = stage;
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("/fxml/IPInputFXML.fxml"));
        Parent root = (AnchorPane) loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        
        stage.setTitle("IP Input");
        stage.show();
        
        //Connection con = new Connection();
        //con.connectToServer();
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
}
