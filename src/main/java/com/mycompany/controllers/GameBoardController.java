package com.mycompany.controllers;

import com.mycompany.controllers.IPInputFXMLController;
import com.mycompany.stones.MainApp;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GameBoardController{

    private boolean gameOver;
    String color = "black";
    Button[][] buttons = new Button[11][11];
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Button btn42;

    @FXML
    private Button btn52;

    @FXML
    private Button btn62;

    @FXML
    private Button btn33;

    @FXML
    private Button btn43;

    @FXML
    private Button btn53;

    @FXML
    private Button btn63;

    @FXML
    private Button btn73;

    @FXML
    private Button btn24;

    @FXML
    private Button btn34;

    @FXML
    private Button btn44;

    @FXML
    private Button btn54;

    @FXML
    private Button btn64;

    @FXML
    private Button btn74;

    @FXML
    private Button btn84;

    @FXML
    private Button btn25;

    @FXML
    private Button btn35;

    @FXML
    private Button btn45;

    @FXML
    private Button btn55;

    @FXML
    private Button btn65;

    @FXML
    private Button btn75;

    @FXML
    private Button btn85;

    @FXML
    private Button btn26;

    @FXML
    private Button btn36;

    @FXML
    private Button btn46;

    @FXML
    private Button btn56;

    @FXML
    private Button btn66;

    @FXML
    private Button btn76;

    @FXML
    private Button btn86;

    @FXML
    private Button btn37;

    @FXML
    private Button btn47;

    @FXML
    private Button btn57;

    @FXML
    private Button btn67;

    @FXML
    private Button btn77;

    @FXML
    private Button btn48;

    @FXML
    private Button btn58;

    @FXML
    private Button btn68;

    @FXML
    private Button exitBtn;
    
     @FXML
    private Label pScoreLbl;

    @FXML
    private Label pLeftLbl;

    @FXML
    private Label cScoreLbl;

    @FXML
    private Label cLeftLbl;

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btn42 != null : "fx:id=\"btn42\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert btn52 != null : "fx:id=\"btn52\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert btn62 != null : "fx:id=\"btn62\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert btn33 != null : "fx:id=\"btn33\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert btn43 != null : "fx:id=\"btn43\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert btn53 != null : "fx:id=\"btn53\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert btn63 != null : "fx:id=\"btn63\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert btn73 != null : "fx:id=\"btn73\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert btn24 != null : "fx:id=\"btn24\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert btn34 != null : "fx:id=\"btn34\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert btn44 != null : "fx:id=\"btn44\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert btn54 != null : "fx:id=\"btn54\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert btn64 != null : "fx:id=\"btn64\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert btn74 != null : "fx:id=\"btn74\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert btn84 != null : "fx:id=\"btn84\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert btn25 != null : "fx:id=\"btn25\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert btn35 != null : "fx:id=\"btn35\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert btn45 != null : "fx:id=\"btn45\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert btn55 != null : "fx:id=\"btn55\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert btn65 != null : "fx:id=\"btn65\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert btn75 != null : "fx:id=\"btn75\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert btn85 != null : "fx:id=\"btn85\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert btn26 != null : "fx:id=\"btn26\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert btn36 != null : "fx:id=\"btn36\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert btn46 != null : "fx:id=\"btn46\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert btn56 != null : "fx:id=\"btn56\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert btn66 != null : "fx:id=\"btn66\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert btn76 != null : "fx:id=\"btn76\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert btn86 != null : "fx:id=\"btn86\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert btn37 != null : "fx:id=\"btn37\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert btn47 != null : "fx:id=\"btn47\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert btn57 != null : "fx:id=\"btn57\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert btn67 != null : "fx:id=\"btn67\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert btn77 != null : "fx:id=\"btn77\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert btn48 != null : "fx:id=\"btn48\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert btn58 != null : "fx:id=\"btn58\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert btn68 != null : "fx:id=\"btn68\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert exitBtn != null : "fx:id=\"exitBtn\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert pScoreLbl != null : "fx:id=\"pScoreLbl\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert pLeftLbl != null : "fx:id=\"pLeftLbl\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert cScoreLbl != null : "fx:id=\"cScoreLbl\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert cLeftLbl != null : "fx:id=\"cLeftLbl\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
                
        //initialize all the button action listener here or make a method and call it here
        //btn55.setOnAction(myHandler);
        
    }
    
    @FXML
    void handleExit(ActionEvent event) {
        //Platform.exit();
        gameOver();
    }
    
    //Figure out how gameOver is gonna be called. and figure out how to close the board.
    void gameOver(){
        //gameOver = true;
        if(Integer.parseInt(cLeftLbl.getText()) == 0){
            try {
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader();
                
                loader.setLocation(MainApp.class.getResource("/fxml/GameOverFXML.fxml"));
                
                Parent parent = (AnchorPane) loader.load();
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                
                stage.show();
                
                //Stage close = (Stage) newGameBtn.getScene().getWindow();
                //close.close();
                
            } catch (IOException ex) {
                Logger.getLogger(IPInputFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    //Have to add handleClick method to all the buttons
    @FXML
    void handleClick(ActionEvent event){
        
        if(validateMove()){
            if(color.equals("black")){
                Image black = new Image(getClass().getResourceAsStream("/images/black.png"));
                btn55.setGraphic(new ImageView(black));
                color = "white";
            }
            else if(color.equals("white")){
                    Image white = new Image(getClass().getResourceAsStream("/images/white.png"));
                    btn55.setGraphic(new ImageView(white));
                    color = "black";
            }
        }
    }
    
    /*EventHandler<ActionEvent> myHandler = new EventHandler<ActionEvent>(){
        @Override
        public void handle(final ActionEvent event) {
          onClick();
        }
    };
    
    void onClick(){
        if(color.equals("black")){
            Image black = new Image(getClass().getResourceAsStream("/images/black.png"));
            btn55.setGraphic(new ImageView(black));
            color = "white";
        }
        else if(color.equals("white")){
                Image white = new Image(getClass().getResourceAsStream("/images/white.png"));
                btn55.setGraphic(new ImageView(white));
                color = "black";
        }
    }*/
    
    //call this method after each move, so after each user click and each computer move
    void updateGameBoardInfo(){
        int score = 0;
        int pebbles = 0;
        pScoreLbl.setText(Integer.toString(score));
        cScoreLbl.setText(Integer.toString(score));
        
        pLeftLbl.setText(Integer.toString(pebbles));
        cLeftLbl.setText(Integer.toString(pebbles));
    }
    
    boolean validateMove(){
        int x = 1 , y = 2;
        int xo = 1, yo = 2;
        
        if(x == xo){
            if(y == yo){
                return true;
            }
            return false;
        }
        return false;
    }
}
