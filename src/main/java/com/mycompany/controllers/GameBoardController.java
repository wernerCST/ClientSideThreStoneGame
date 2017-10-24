/**
 * Sample Skeleton for 'GameBoardFXML.fxml' Controller Class
 */

import com.mycompany.controllers.IPInputFXMLController;
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
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GameBoardController{

    private boolean gameOver;
    
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

    @FXML // fx:id="btn55"
    private Button btn55; // Value injected by FXMLLoader

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

    @FXML // fx:id="iv42"
    private ImageView iv42; // Value injected by FXMLLoader

    @FXML // fx:id="iv52"
    private ImageView iv52; // Value injected by FXMLLoader

    @FXML // fx:id="iv62"
    private ImageView iv62; // Value injected by FXMLLoader

    @FXML // fx:id="iv33"
    private ImageView iv33; // Value injected by FXMLLoader

    @FXML // fx:id="iv43"
    private ImageView iv43; // Value injected by FXMLLoader

    @FXML // fx:id="iv53"
    private ImageView iv53; // Value injected by FXMLLoader

    @FXML // fx:id="iv63"
    private ImageView iv63; // Value injected by FXMLLoader

    @FXML // fx:id="iv73"
    private ImageView iv73; // Value injected by FXMLLoader

    @FXML // fx:id="iv24"
    private ImageView iv24; // Value injected by FXMLLoader

    @FXML // fx:id="iv34"
    private ImageView iv34; // Value injected by FXMLLoader

    @FXML // fx:id="iv44"
    private ImageView iv44; // Value injected by FXMLLoader

    @FXML // fx:id="iv54"
    private ImageView iv54; // Value injected by FXMLLoader

    @FXML // fx:id="iv64"
    private ImageView iv64; // Value injected by FXMLLoader

    @FXML // fx:id="iv74"
    private ImageView iv74; // Value injected by FXMLLoader

    @FXML // fx:id="iv84"
    private ImageView iv84; // Value injected by FXMLLoader

    @FXML // fx:id="iv25"
    private ImageView iv25; // Value injected by FXMLLoader

    @FXML // fx:id="iv35"
    private ImageView iv35; // Value injected by FXMLLoader

    @FXML // fx:id="iv45"
    private ImageView iv45; // Value injected by FXMLLoader

    @FXML // fx:id="iv55"
    private ImageView iv55; // Value injected by FXMLLoader

    @FXML // fx:id="iv65"
    private ImageView iv65; // Value injected by FXMLLoader

    @FXML // fx:id="iv75"
    private ImageView iv75; // Value injected by FXMLLoader

    @FXML // fx:id="iv85"
    private ImageView iv85; // Value injected by FXMLLoader

    @FXML // fx:id="iv26"
    private ImageView iv26; // Value injected by FXMLLoader

    @FXML // fx:id="iv36"
    private ImageView iv36; // Value injected by FXMLLoader

    @FXML // fx:id="iv46"
    private ImageView iv46; // Value injected by FXMLLoader

    @FXML // fx:id="iv56"
    private ImageView iv56; // Value injected by FXMLLoader

    @FXML // fx:id="iv66"
    private ImageView iv66; // Value injected by FXMLLoader

    @FXML // fx:id="iv76"
    private ImageView iv76; // Value injected by FXMLLoader

    @FXML // fx:id="iv86"
    private ImageView iv86; // Value injected by FXMLLoader

    @FXML // fx:id="iv37"
    private ImageView iv37; // Value injected by FXMLLoader

    @FXML // fx:id="iv47"
    private ImageView iv47; // Value injected by FXMLLoader

    @FXML // fx:id="iv57"
    private ImageView iv57; // Value injected by FXMLLoader

    @FXML // fx:id="iv67"
    private ImageView iv67; // Value injected by FXMLLoader

    @FXML // fx:id="iv77"
    private ImageView iv77; // Value injected by FXMLLoader

    @FXML // fx:id="iv48"
    private ImageView iv48; // Value injected by FXMLLoader

    @FXML // fx:id="iv58"
    private ImageView iv58; // Value injected by FXMLLoader

    @FXML // fx:id="iv68"
    private ImageView iv68; // Value injected by FXMLLoader

    @FXML // fx:id="exitBtn"
    private Button exitBtn; // Value injected by FXMLLoader

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
        assert iv42 != null : "fx:id=\"iv42\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert iv52 != null : "fx:id=\"iv52\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert iv62 != null : "fx:id=\"iv62\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert iv33 != null : "fx:id=\"iv33\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert iv43 != null : "fx:id=\"iv43\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert iv53 != null : "fx:id=\"iv53\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert iv63 != null : "fx:id=\"iv63\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert iv73 != null : "fx:id=\"iv73\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert iv24 != null : "fx:id=\"iv24\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert iv34 != null : "fx:id=\"iv34\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert iv44 != null : "fx:id=\"iv44\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert iv54 != null : "fx:id=\"iv54\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert iv64 != null : "fx:id=\"iv64\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert iv74 != null : "fx:id=\"iv74\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert iv84 != null : "fx:id=\"iv84\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert iv25 != null : "fx:id=\"iv25\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert iv35 != null : "fx:id=\"iv35\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert iv45 != null : "fx:id=\"iv45\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert iv55 != null : "fx:id=\"iv55\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert iv65 != null : "fx:id=\"iv65\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert iv75 != null : "fx:id=\"iv75\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert iv85 != null : "fx:id=\"iv85\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert iv26 != null : "fx:id=\"iv26\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert iv36 != null : "fx:id=\"iv36\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert iv46 != null : "fx:id=\"iv46\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert iv56 != null : "fx:id=\"iv56\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert iv66 != null : "fx:id=\"iv66\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert iv76 != null : "fx:id=\"iv76\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert iv86 != null : "fx:id=\"iv86\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert iv37 != null : "fx:id=\"iv37\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert iv47 != null : "fx:id=\"iv47\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert iv57 != null : "fx:id=\"iv57\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert iv67 != null : "fx:id=\"iv67\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert iv77 != null : "fx:id=\"iv77\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert iv48 != null : "fx:id=\"iv48\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert iv58 != null : "fx:id=\"iv58\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert iv68 != null : "fx:id=\"iv68\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";
        assert exitBtn != null : "fx:id=\"exitBtn\" was not injected: check your FXML file 'GameBoardFXML.fxml'.";

    }
    
    @FXML
    void handleExit(ActionEvent event) {
        //Platform.exit();
        gameOver();
    }
    
    //Figure out how gameOver is gonna be called. and figure out how to close the board.
    void gameOver(){
        gameOver = true;
        if(gameOver == true){
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
    
    //Need to update at each round the scores, number of pebbles
    //Need to check whose turn it is (white or black) to be able to put right color in imageview
}
