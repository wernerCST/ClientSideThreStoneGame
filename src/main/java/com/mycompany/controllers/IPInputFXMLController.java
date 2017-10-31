package com.mycompany.controllers;

import com.mycompany.clientside.connection.Connection;
import com.mycompany.stones.MainApp;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
        con = new Connection();
    }
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() { }
    /**
     * Launches the the MenuFXML view if the IP is valid and if the server
     * response with (0) indicating that a new session has been created.
     * @param event 
     */
    
    @FXML
    void handleInput(ActionEvent event)  {
        //check if IP is valid or not
        String ip = IPTextField.getText();
        Pattern pattern = Pattern.compile("\\d{1,3}+\\.\\d{1,3}+\\.\\d{1,3}+(\\.\\d{1,3}+)?");
        if(!pattern.matcher(IPTextField.getText()).matches()) {
            errorAlert("Sorry that is n0ot a valid ip");
            return;
        }
        
       try{
           con.setIP(ip);
       } catch (IOException ex) {
           errorAlert(ex.getMessage());
       }
        int[] msg = new int[3];
        msg[0] = 0;
        con.connectToServer(msg);
        con.serverRead();
        byte[] response = con.getRes();
        
        if(response[0] == 0){                
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
                errorAlert(ex.getMessage());
            }
        } else {
            errorAlert("Sorry please try again");
        }
    }
    
    /**
     * Helper method to display a dialog box with a given message
     * being passed in.
     * @param msg 
     */
    private void errorAlert(String msg) {
        Alert dialog = new Alert(Alert.AlertType.ERROR);
        dialog.setTitle("Error");
        dialog.setHeaderText("!!");
        dialog.setContentText(msg);
        dialog.show();
    }  
}
