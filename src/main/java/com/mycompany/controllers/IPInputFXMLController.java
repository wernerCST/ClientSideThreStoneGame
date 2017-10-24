/**
 * Sample Skeleton for 'IPInputFXML.fxml' Controller Class
 */

package com.hly.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class IPInputFXMLController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="inputBtn"
    private Button inputBtn; // Value injected by FXMLLoader

    @FXML // fx:id="IPLabel"
    private Label IPLabel; // Value injected by FXMLLoader

    @FXML // fx:id="IPTextField"
    private TextField IPTextField; // Value injected by FXMLLoader
    
    public IPInputFXMLController(){
        super();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert inputBtn != null : "fx:id=\"inputBtn\" was not injected: check your FXML file 'IPInputFXML.fxml'.";
        assert IPLabel != null : "fx:id=\"IPLabel\" was not injected: check your FXML file 'IPInputFXML.fxml'.";
        assert IPTextField != null : "fx:id=\"IPTextField\" was not injected: check your FXML file 'IPInputFXML.fxml'.";

    }
    
    @FXML
    void handleInput(ActionEvent event) {

    }
    
    //if valid IP, call display() menu
}
