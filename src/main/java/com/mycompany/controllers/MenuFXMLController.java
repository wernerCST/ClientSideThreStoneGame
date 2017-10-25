/**
 * Sample Skeleton for 'MenuFXML.fxml' Controller Class
 */

package com.mycompany.controllers;

import com.mycompany.clientside.connection.Connection;
import com.mycompany.stones.MainApp;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
        System.out.println("-1-- handleNewGame");
        int[] msg = new int[1];
        msg[0] = 1;
        con.connectToServer(msg);
        byte[] response = con.serverRead();
        System.out.println("-2-- handleNewGame");
        if(response[0] == 1){  
            System.out.println("-3-- handleNewGame");
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
    private void errorAlert(String msg) {
        Alert dialog = new Alert(Alert.AlertType.ERROR);
        dialog.setTitle("Error");
        dialog.setHeaderText("!!");
        dialog.setContentText(msg);
        dialog.show();
    } 

    public void setConnectionObject(Connection con) {
        this.con = con;
    }
    
}
