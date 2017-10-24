/**
 * Sample Skeleton for 'GameOverFXML.fxml' Controller Class
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
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GameOverFXMLController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="playAgainButton"
    private Button playAgainBtn; // Value injected by FXMLLoader

    @FXML // fx:id="exitBtn"
    private Button exitBtn; // Value injected by FXMLLoader

    @FXML // fx:id="scorePlayerLabel"
    private Label scorePlayerLabel; // Value injected by FXMLLoader

    @FXML // fx:id="scoreComputerLabel"
    private Label scoreComputerLabel; // Value injected by FXMLLoader
    
    public GameOverFXMLController(){
        super();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert playAgainBtn != null : "fx:id=\"playAgainButton\" was not injected: check your FXML file 'GameOverFXML.fxml'.";
        assert exitBtn != null : "fx:id=\"exitBtn\" was not injected: check your FXML file 'GameOverFXML.fxml'.";
        assert scorePlayerLabel != null : "fx:id=\"scorePlayerLabel\" was not injected: check your FXML file 'GameOverFXML.fxml'.";
        assert scoreComputerLabel != null : "fx:id=\"scoreComputerLabel\" was not injected: check your FXML file 'GameOverFXML.fxml'.";

    }
    
    @FXML
    void handleExit(ActionEvent event) {
        Platform.exit();
    }

    //Needs to put the final scores and who won/lost
    @FXML
    void handlePlayAgain(ActionEvent event) {
        try {
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader();
                
                loader.setLocation(MainApp.class.getResource("/fxml/GameBoardFXML.fxml"));
                
                Parent parent = (BorderPane) loader.load();
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                
                stage.show();
                
                Stage close = (Stage) playAgainBtn.getScene().getWindow();
                close.close();
                
            } catch (IOException ex) {
                Logger.getLogger(IPInputFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
