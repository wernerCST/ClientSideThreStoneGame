/**
 * Sample Skeleton for 'IPInputFXML.fxml' Controller Class
 */

package com.mycompany.controllers;

import com.mycompany.stones.MainApp;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
        //should check if IP is valid or not
        Pattern pattern = Pattern.compile("\\d{1,3}+\\.\\d{1,3}+\\.\\d{1,3}+(\\.\\d{1,3}+)?");
        if(pattern.matcher(IPTextField.getText()).matches()){
            try {
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader();
                
                loader.setLocation(MainApp.class.getResource("/fxml/MenuFXML.fxml"));
                
                Parent parent = (AnchorPane) loader.load();
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                
                stage.show();
                
                Stage close = (Stage) inputBtn.getScene().getWindow();
                close.close();
                
            } catch (IOException ex) {
                Logger.getLogger(IPInputFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            Alert dialog = new Alert(Alert.AlertType.ERROR);
            dialog.initModality(Modality.NONE);
            dialog.setTitle("Error");
            dialog.setHeaderText("There was an error connecting to the server.");
            dialog.setContentText("The ip provided is not valid.");
            dialog.show();
        }
    }
}
