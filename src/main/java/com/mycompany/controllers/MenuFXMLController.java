/**
 * Sample Skeleton for 'MenuFXML.fxml' Controller Class
 */

package com.hly.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MenuFXMLController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    public MenuFXMLController(){
        super();
    }
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

    }
    
    @FXML
    void handleExit(ActionEvent event) {

    }

    @FXML
    void handleNewGame(ActionEvent event) {

    }
}
