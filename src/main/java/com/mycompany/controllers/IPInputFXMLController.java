/**
 * Sample Skeleton for 'IPInputFXML.fxml' Controller Class
 */

package com.mycompany.controllers;

import com.mycompany.clientside.connection.Connection;
import com.mycompany.stones.MainApp;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    private Connection con;
    public IPInputFXMLController(){
        super();
        if(con == null){System.out.println("4 fuck");}
    }
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert inputBtn != null : "fx:id=\"inputBtn\" was not injected: check your FXML file 'IPInputFXML.fxml'.";
        assert IPLabel != null : "fx:id=\"IPLabel\" was not injected: check your FXML file 'IPInputFXML.fxml'.";
        assert IPTextField != null : "fx:id=\"IPTextField\" was not injected: check your FXML file 'IPInputFXML.fxml'.";
        IPLabel.setText("10.172.15.30");
    }
    
    @FXML
    void handleInput(ActionEvent event) {
        //should check if IP is valid or not
        String ip = IPTextField.getText();
        System.out.println("1.1");
        System.out.println(ip);
        if(con == null){System.out.println("2 fuck");}
        byte[] response = con.connectToServer(ip, 0);
        
        if(response[0] == 1){                
            try {
                Stage primaryStage = new Stage();
                FXMLLoader loader = new FXMLLoader();               
                loader.setLocation(MainApp.class.getResource("/fxml/MenuFXML.fxml"));                
                Parent rootPane = (AnchorPane) loader.load();
                Scene scene = new Scene(rootPane);
                primaryStage.setScene(scene);
                MenuFXMLController menu = loader.getController();
                menu.setConnectionObject(con);
                
                primaryStage.show();
                
                Stage close = (Stage) inputBtn.getScene().getWindow();
                close.close();
                
            } catch (IOException ex) {
                Logger.getLogger(IPInputFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            errorAlert("Sorry please try again");
        }
    }
    private void errorAlert(String msg) {
        Alert dialog = new Alert(Alert.AlertType.ERROR);
        dialog.setTitle("Error");
        dialog.setHeaderText("!!");
        dialog.setContentText(msg);
        dialog.show();
    }  


    public void setConnectionObject(Connection con) {
        this.con = con;
        if(con == null){System.out.println("0 fuck");}
    }
}
