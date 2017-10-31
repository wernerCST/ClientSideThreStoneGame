package com.mycompany.controllers;

import com.mycompany.clientside.connection.Connection;
import com.mycompany.stones.MainApp;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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

    private Connection con;
    
    public MenuFXMLController(){
        super();
    }
    
    @FXML
    void initialize() {  }
    
    /**
     * when the exit button is clicked the socket is closed and the window
     * is closed as well and the IPInputFXMLController is launched.
     * @param event 
     */
    @FXML
    void handleExit(ActionEvent event) {
        try {
            int[] msg = new int[1];
            msg[0] = 4;
            con.connectToServer(msg);
            Stage close = (Stage) exitBtn.getScene().getWindow();
            close.close();
            con.closeSocket(); 
            showIpWindow();
        } catch (IOException ex) {
            errorAlert(ex.getMessage());
        }
    }
    
    /**
     * Helper method that handles the call to launch the IPInputFXML.
     */
     private void showIpWindow() {
        try {
            Stage primaryStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/IPInputFXML.fxml"));
            Parent rootPane = (AnchorPane) loader.load();
            Scene scene = new Scene(rootPane);
            primaryStage.setScene(scene);            
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(GameBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     /**
      * Even handler for when the user decides to play the game.
      * @param event 
      */
    @FXML
    void handleNewGame(ActionEvent event) {
        int[] msg = new int[1];
        msg[0] = 1;
        con.connectToServer(msg);
        con.serverRead();
        byte[] response = con.getRes();
        if(response[0] == 1){  
        try {
            Stage primaryStage = new Stage();
            FXMLLoader loader = new FXMLLoader();               
            loader.setLocation(MainApp.class.getResource("/fxml/GameBoardFXML.fxml"));                
            Parent rootPane = (BorderPane) loader.load();
            Scene scene = new Scene(rootPane);
            primaryStage.setScene(scene);
            GameBoardController game = loader.getController();
            game.setConnectionObject(con);
                
            primaryStage.show();

            Stage close = (Stage) newGameBtn.getScene().getWindow();
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
        dialog.setHeaderText("Error");
        dialog.setContentText(msg);
        dialog.show();
    } 
    
    /**
     * setter to get the reference of the Connection bean.
     * @param con 
     */
    public void setConnectionObject(Connection con) {
        this.con = con;
    }
    
}
