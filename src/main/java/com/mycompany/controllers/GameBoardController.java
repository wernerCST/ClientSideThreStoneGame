package com.mycompany.controllers;

import com.mycompany.clientside.connection.Connection;
import com.mycompany.stones.MainApp;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
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
import javafx.stage.Stage;

public class GameBoardController {
    
    private int previousX, previousY, playedX, playedY, leftX, leftY, counter;
    private Connection con;
    private final ThreeStonesBoard board;
    Image black;
    Image white;
    
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
    
    public GameBoardController() {
        super();
        black = new Image("images/black.png");
        white = new Image("images/white.png");
        board = new ThreeStonesBoard();
        previousX = 0;
        previousY = 0;
        playedX = 0;
        playedY = 0; 
        leftX = 0; 
        leftY = 0; 
        counter = 0;
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() { 
        setButtonsOnBoard();
    }
    
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
     * Handles the sending of the selected index (x,y) the user
     * has clicked on, disables the button in the process. Gets
     * and places the server response, that includes the servers move, scores, 
     * stones and if there was a winner.
     * @param e 
     */
    public void onPlayerMove(ActionEvent e){
        String[] xy = board.getIndexOfStone((Button)e.getSource()).split(",");
        if(counter == 0) {
            playedX = Integer.parseInt(xy[0]);
            playedY =  Integer.parseInt(xy[1]);    
        } else {
            playedX = Integer.parseInt(xy[0]);
            playedY =  Integer.parseInt(xy[1]);  
            determineSlotsLeftXY(xy);
            if(!validateMove()) {
                errorAlert("Invalid move plases try again.");
                return;
            }
        }
        
        int[] msg = new int[3];
                msg[0] = 2;
                msg[1] = Integer.parseInt(xy[0]);
                msg[2] = Integer.parseInt(xy[1]);
                ImageView img = new ImageView();
                
        Button temp = board.getStoneAt(Integer.parseInt(xy[0]), Integer.parseInt(xy[1]));   
        temp.setGraphic(new ImageView(white));
        temp.setDisable(true);
       
       if(con.connectToServer(msg)) {
        if(con.serverRead()) {
            byte[] response = con.getRes();
            board.getStoneAt(response[1], response[2]).setGraphic(new ImageView(black));
            board.getStoneAt(response[1], response[2]).setStyle("-fx-border-color: #f00; -fx-border-width: 2px;");
            if(counter > 0) {
              board.getStoneAt(previousX, previousY).setStyle("-fx-border-color: none; -fx-border-width: 0px;");
            }
            board.getStoneAt(response[1], response[2]).setDisable(true);
            
            pScoreLbl.setText("" + response[3]);
            cScoreLbl.setText("" + response[4]);            
            pLeftLbl.setText("" + response[5]);
            cLeftLbl.setText("" + response[5]);
            
            
            if(response[0] == 4){
                if(response[3] > response[4]) {
                    //player won
                    launchGameOverPage(e, board.getStoneAt(response[1], 
                            response[2]), response[3], response[4], "You won congrats!!");
                } else {
                    //ai won
                    launchGameOverPage(e, board.getStoneAt(response[1], 
                            response[2]), response[3], response[4], "You lost, please play again");
                }
                
            }
            previousX = response[1]; 
            previousY = response[2];
        }//end of server read
       }//end of message sending to server.   
       
       leftX = 0;
       leftY = 0;
       counter++;       
    }
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
            errorAlert(ex.getMessage());
        }
    }
    
    /**
     * Launches the GameOverFXML and will set the scores as well as the string
     * message with the result of who won the game.
     * @param e
     * @param btn
     * @param player
     * @param ai
     * @param msg 
     */
    private void launchGameOverPage(ActionEvent e, Button btn, int player, 
                                        int ai, String msg) {
        try {
            Stage primaryStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/GameOverFXML.fxml"));
            Parent rootPane = (AnchorPane) loader.load();
            Scene scene = new Scene(rootPane);
            primaryStage.setScene(scene);
            GameOverFXMLController gameover = loader.getController();
            gameover.setContext(con, player, ai, msg);
            
            primaryStage.show();
            Stage close = (Stage) btn.getScene().getWindow();
            close.close();
        } catch (IOException ex) {
            errorAlert(ex.getMessage());
        }
    }

    /**
     * Sets the local Connection bean to the same reference as set in 
     * previous views.
     * @param con 
     */
    public void setConnectionObject(Connection con) {
            this.con = con;
    }    
    /**
     * Helper method for user move validation.
     * @return 
     */
    boolean validateMove(){            
        if(!(leftX == 0 && leftY == 0)){
            if(previousX == playedX){
                return true;
            }
            if(previousY == playedY){
                return true;
            }
            else{
                return false;
            }
        }
        return true;
    }
    
    /**
     * Determines if the button clicked by the user (x,y) is a
     * valid one, that meets the standards of the rules of the game.
     * @param xy 
     */
    private void determineSlotsLeftXY(String[] xy) {
        boolean validClick = false;
        for (int i = 0; i < 11; i++) {
            if (!board.getStoneAt(Integer.parseInt(xy[1]), i).isDisable()) {
                leftY++;
                validClick = true;
            } else if(!board.getStoneAt(i, Integer.parseInt(xy[0])).isDisable()){                    
                leftX++;
                validClick = true;
            }
        }
    }
    
    /**
     * Helper method that sets the two dimantional Button array
     * in the ThreeStonesBoard bean to the there corresponding buttons
     * on the board (on the window).
     */
    private void setButtonsOnBoard() {
        //row 1, has 3 tiles.
        board.setStoneAt(btn42, 2, 4);
        board.setStoneAt(btn52, 2, 5);
        board.setStoneAt(btn62, 2, 6);
        //row 2, has 5 tiles.
        board.setStoneAt(btn33, 3, 3);
        board.setStoneAt(btn43, 3, 4);
        board.setStoneAt(btn53, 3, 5);
        board.setStoneAt(btn63, 3, 6);
        board.setStoneAt(btn73, 3, 7);
        //row 3, has 7 tiles
        board.setStoneAt(btn24, 4, 2);
        board.setStoneAt(btn34, 4, 3);
        board.setStoneAt(btn44, 4, 4);
        board.setStoneAt(btn54, 4, 5);
        board.setStoneAt(btn64, 4, 6);
        board.setStoneAt(btn74, 4, 7);
        board.setStoneAt(btn84, 4, 8);
        //row 4, has 7 tiles
        board.setStoneAt(btn25, 5, 2);
        board.setStoneAt(btn35, 5, 3);
        board.setStoneAt(btn45, 5, 4);
        // center at 5,5
        board.setStoneAt(btn65, 5, 6);
        board.setStoneAt(btn75, 5, 7);
        board.setStoneAt(btn85, 5, 8);
        //row 5, has 7 tiles
        board.setStoneAt(btn26, 6, 2);
        board.setStoneAt(btn36, 6, 3);
        board.setStoneAt(btn46, 6, 4);
        board.setStoneAt(btn56, 6, 5);
        board.setStoneAt(btn66, 6, 6);
        board.setStoneAt(btn76, 6, 7);
        board.setStoneAt(btn86, 6, 8);
        //row 6, has 5 tiles.
        board.setStoneAt(btn37, 7, 3);
        board.setStoneAt(btn47, 7, 4);
        board.setStoneAt(btn57, 7, 5);
        board.setStoneAt(btn67, 7, 6);
        board.setStoneAt(btn77, 7, 7);
        //row 7, has 3 tiles.
        board.setStoneAt(btn48, 8, 4);
        board.setStoneAt(btn58, 8, 5);
        board.setStoneAt(btn68, 8, 6);       
        
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