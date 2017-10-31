/**
 * Sample Skeleton for 'GameOverFXML.fxml' Controller Class
 */

package com.mycompany.controllers;

import com.mycompany.clientside.connection.Connection;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GameOverFXMLController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    
    @FXML
    private Label winLoseMsgLable;


    @FXML // fx:id="playAgainButton"
    private Button playAgainBtn; // Value injected by FXMLLoader

    @FXML // fx:id="exitBtn"
    private Button exitBtn; // Value injected by FXMLLoader

    @FXML // fx:id="scorePlayerLabel"
    private Label scorePlayerLabel; // Value injected by FXMLLoader

    @FXML // fx:id="scoreComputerLabel"
    private Label scoreComputerLabel; // Value injected by FXMLLoader
    private Connection con;
    private String msg;
    private int playerScore, aiScore;
    public GameOverFXMLController(){
        super();
        msg = "";
        playerScore = 0;
        aiScore = 0;
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {        
        
    }
    /**
     * When the exit button is clicked this handler will send a message 
     * to the server that the user has left. It also closes the socket
     * and will lunch the IPInputFXML view.
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
            showIpWindo();
        } catch (IOException ex) {
            errorAlert(ex.getMessage());
        }
    }
    /**
     * Helper method that handles the call to open the IPInputFXML view.
     */
     private void showIpWindo() {
        try {
            Stage primaryStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/IPInputFXML.fxml"));
            Parent rootPane = (AnchorPane) loader.load();
            Scene scene = new Scene(rootPane);
            primaryStage.setScene(scene);            
            primaryStage.show();
        } catch (IOException ex) {
            errorAlert(ex.getMessage());
        }
    }

   
     /**
      * Lunches the GameBoardFXML view and restarts the game from scratch,
      * it also sends a request to the server to restart the game on the server side
      * as well.
      * @param event 
      */
    @FXML
    void playAgain(ActionEvent event) {
        try {
            int[] msg = new int[1];
                msg[0] = 3;
            if(con.connectToServer(msg)) {
                if(con.serverRead()) {           
                byte[] response = con.getRes();
                if(response[0] == 3) {
                    
                
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader();                
                loader.setLocation(MainApp.class.getResource("/fxml/GameBoardFXML.fxml"));                
                Parent parent = (BorderPane) loader.load();
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                GameBoardController game = loader.getController();
                game.setConnectionObject(con);                
                stage.show();
                
                Stage close = (Stage) playAgainBtn.getScene().getWindow();
                close.close();
                }
             }
          }                
            } catch (IOException ex) {
                errorAlert(ex.getMessage());
            }
    }
    /**
     * Setter to obtain the reference of the Connection bean.
     * @param con 
     */
    void setContext(Connection con, int player, int ai, String msg) {
        this.con = con;
        this.msg = msg;
        this.playerScore = player;
        this.aiScore = ai;
        scorePlayerLabel.setText(" " + this.playerScore);
        scoreComputerLabel.setText(" " + this.aiScore);
        winLoseMsgLable.setText(msg);
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
}
