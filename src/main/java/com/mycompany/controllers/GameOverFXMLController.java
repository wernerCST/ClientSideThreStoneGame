/**
 * Sample Skeleton for 'GameOverFXML.fxml' Controller Class
 */

package com.hly.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GameOverFXMLController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="playAgainButton"
    private Button playAgainButton; // Value injected by FXMLLoader

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
        assert playAgainButton != null : "fx:id=\"playAgainButton\" was not injected: check your FXML file 'GameOverFXML.fxml'.";
        assert exitBtn != null : "fx:id=\"exitBtn\" was not injected: check your FXML file 'GameOverFXML.fxml'.";
        assert scorePlayerLabel != null : "fx:id=\"scorePlayerLabel\" was not injected: check your FXML file 'GameOverFXML.fxml'.";
        assert scoreComputerLabel != null : "fx:id=\"scoreComputerLabel\" was not injected: check your FXML file 'GameOverFXML.fxml'.";

    }
    
    @FXML
    void handleExit(ActionEvent event) {

    }

    @FXML
    void handlePlayAgain(ActionEvent event) {

    }
}
