package com.mycompany.clientside.connection;

import java.io.IOException;
import java.io.*;
import java.net.*;
import javafx.scene.control.Alert;

/**
 * This class handles the connection between the client and 
 * the server, 
 * @author Werner Castanaza
 */
public class Connection {
    
    private int port;
    private static int BUFSIZE;
    private Socket sk;
    private byte[] res;
    
    /**
     * Sets the port number to its default as well as the BUFSIZE.
     */
    public Connection() {
        port = 50000;
        BUFSIZE = 6;  
        res = new byte[BUFSIZE];
    }
    /**
     * Sends the a given message to the serve.
     * @param userMsg 
     */
    public boolean connectToServer(int[] userMsg) {
        boolean valid = true;
        int msgSize;
        byte[] res = new byte[BUFSIZE];
        res[0] = 0;
        byte[] serverMsg = new byte[BUFSIZE];
        try {        
            OutputStream out = sk.getOutputStream();
            byte[] msg = new byte[BUFSIZE];
            for (int i = 0; i < userMsg.length; i++) {
                msg[i] = (byte)userMsg[i];
            }
            out.write(msg);                
        } catch (IOException ex) {
            valid = false;
            errorAlert(ex.getMessage());
        } 
        return valid;
    }    
    /**
     * Gets the InputStream being received from the server.
     * @return 
     */
    public boolean serverRead() {
        boolean valid = true;
        int msgSize;
        this.res = new byte[BUFSIZE];
        res[0] = 0;
        byte[] serverMsg = new byte[BUFSIZE];
        try {
            InputStream in =  sk.getInputStream();
            int i = 0;
            while((msgSize = in.read(serverMsg)) != -1) {
                this.res = serverMsg; 
                break;
            }                
        } catch (IOException ex) {
            valid =  false;
            errorAlert(ex.getMessage());            
        }
        
        return valid;
    } 
    public byte[] getRes() {
        return this.res;
    }
    /**
     * Creates the Socket for any connection to be made, in order for 
     * this bean to do what it can do this method must be called
     * before the rest.
     * @param ip
     * @throws IOException 
     */
      public void setIP(String ip) throws IOException {
          this.sk = new Socket(ip, port);
      }
      /**
       * close the socket.
       * @throws IOException 
       */
      public void closeSocket() throws IOException {
          this.sk.close();
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
