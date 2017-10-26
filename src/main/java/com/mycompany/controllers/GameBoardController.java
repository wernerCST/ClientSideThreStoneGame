/**
 * Sample Skeleton for 'GameBoardFXML.fxml' Controller Class
 */

package com.mycompany.controllers;

import com.mycompany.clientside.connection.Connection;
import com.mycompany.stones.MainApp;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GameBoardController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btn42"
    private Button btn42; // Value injected by FXMLLoader

    @FXML // fx:id="btn52"
    private Button btn52; // Value injected by FXMLLoader

    @FXML // fx:id="btn62"
    private Button btn62; // Value injected by FXMLLoader

    @FXML // fx:id="btn33"
    private Button btn33; // Value injected by FXMLLoader

    @FXML // fx:id="btn43"
    private Button btn43; // Value injected by FXMLLoader

    @FXML // fx:id="btn53"
    private Button btn53; // Value injected by FXMLLoader

    @FXML // fx:id="btn63"
    private Button btn63; // Value injected by FXMLLoader

    @FXML // fx:id="btn73"
    private Button btn73; // Value injected by FXMLLoader

    @FXML // fx:id="btn24"
    private Button btn24; // Value injected by FXMLLoader

    @FXML // fx:id="btn34"
    private Button btn34; // Value injected by FXMLLoader

    @FXML // fx:id="btn44"
    private Button btn44; // Value injected by FXMLLoader

    @FXML // fx:id="btn54"
    private Button btn54; // Value injected by FXMLLoader

    @FXML // fx:id="btn64"
    private Button btn64; // Value injected by FXMLLoader

    @FXML // fx:id="btn74"
    private Button btn74; // Value injected by FXMLLoader

    @FXML // fx:id="btn84"
    private Button btn84; // Value injected by FXMLLoader

    @FXML // fx:id="btn25"
    private Button btn25; // Value injected by FXMLLoader

    @FXML // fx:id="btn35"
    private Button btn35; // Value injected by FXMLLoader

    @FXML // fx:id="btn45"
    private Button btn45; // Value injected by FXMLLoader

    @FXML // fx:id="btn65"
    private Button btn65; // Value injected by FXMLLoader

    @FXML // fx:id="btn75"
    private Button btn75; // Value injected by FXMLLoader

    @FXML // fx:id="btn85"
    private Button btn85; // Value injected by FXMLLoader

    @FXML // fx:id="btn26"
    private Button btn26; // Value injected by FXMLLoader

    @FXML // fx:id="btn36"
    private Button btn36; // Value injected by FXMLLoader

    @FXML // fx:id="btn46"
    private Button btn46; // Value injected by FXMLLoader

    @FXML // fx:id="btn56"
    private Button btn56; // Value injected by FXMLLoader

    @FXML // fx:id="btn66"
    private Button btn66; // Value injected by FXMLLoader

    @FXML // fx:id="btn76"
    private Button btn76; // Value injected by FXMLLoader

    @FXML // fx:id="btn86"
    private Button btn86; // Value injected by FXMLLoader

    @FXML // fx:id="btn37"
    private Button btn37; // Value injected by FXMLLoader

    @FXML // fx:id="btn47"
    private Button btn47; // Value injected by FXMLLoader

    @FXML // fx:id="btn57"
    private Button btn57; // Value injected by FXMLLoader

    @FXML // fx:id="btn67"
    private Button btn67; // Value injected by FXMLLoader

    @FXML // fx:id="btn77"
    private Button btn77; // Value injected by FXMLLoader

    @FXML // fx:id="btn48"
    private Button btn48; // Value injected by FXMLLoader

    @FXML // fx:id="btn58"
    private Button btn58; // Value injected by FXMLLoader

    @FXML // fx:id="btn68"
    private Button btn68; // Value injected by FXMLLoader

    @FXML // fx:id="pScoreLbl"
    private Label pScoreLbl; // Value injected by FXMLLoader

    @FXML // fx:id="pLeftLbl"
    private Label pLeftLbl; // Value injected by FXMLLoader

    @FXML // fx:id="cScoreLbl"
    private Label cScoreLbl; // Value injected by FXMLLoader

    @FXML // fx:id="cLeftLbl"
    private Label cLeftLbl; // Value injected by FXMLLoader

    @FXML // fx:id="exitBtn"
    private Button exitBtn; // Value injected by FXMLLoader

    @FXML
    void handleExit(ActionEvent event) {
          t++;
       int[] msg = new int[3];
                msg[0] = 2;
                msg[1] = 4;
                msg[2] = 2;
                ImageView img = new ImageView();
                
                
        con.connectToServer(msg);
        System.out.println("-------PAUSE FOR SERVER-- "+ t + " -----");
        byte[] response = con.serverRead();
        
        if(t == 1) {
            btn58.setGraphic(new ImageView(white));
            btn67.setGraphic(new ImageView(black));
        }else if(t == 2) {
            btn58.setGraphic(new ImageView(black));
            btn67.setGraphic(new ImageView(white));
            t = 0;
        }
        System.out.println(Arrays.toString(response) + "       <------------");
    }
    
    private int t = 0;
    private Connection con;
    Image black;
    Image white;
  //  Image white = new Image("white.png");
    public GameBoardController() {
        super();
        black = new Image("images/black.png");
        white = new Image("images/white.png");
    }

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
        assert pScoreLbl != null : "fx:id=\"pScoreLbl\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert pLeftLbl != null : "fx:id=\"pLeftLbl\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert cScoreLbl != null : "fx:id=\"cScoreLbl\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert cLeftLbl != null : "fx:id=\"cLeftLbl\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert exitBtn != null : "fx:id=\"exitBtn\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";

    }
    public void setConnectionObject(Connection con) {
            this.con = con;
    }
    
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