/**
 * Sample Skeleton for 'MenuFXML.fxml' Controller Class
 */

package com.mycompany.controllers;

import com.mycompany.stones.MainApp;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuFXMLController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    
    @FXML
    private Button newGameBtn;

    @FXML
    private Button exitBtn;


    public MenuFXMLController(){
        super();
    }
    
    @FXML
    void initialize() {
        assert newGameBtn != null : "fx:id=\"newGameBtn\" was not injected: check your FXML file 'MenuFXML.fxml'.";
        assert exitBtn != null : "fx:id=\"exitBtn\" was not injected: check your FXML file 'MenuFXML.fxml'.";
    }
    
    @FXML
    void handleExit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void handleNewGame(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
                
            loader.setLocation(MainApp.class.getResource("/fxml/GameBoardFXML.fxml"));
                
            Parent parent = (BorderPane) loader.load();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
                
            stage.show();
               
            Stage close = (Stage) newGameBtn.getScene().getWindow();
            close.close();
                
        } catch (IOException ex) {
            Logger.getLogger(IPInputFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
