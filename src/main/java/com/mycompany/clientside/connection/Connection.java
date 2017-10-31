/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clientside.connection;

import java.io.IOException;
import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class handles the connection between the client and 
 * the server, 
 * @author Werner Castanaza
 */
public class Connection {
    
    private int port;
    private String server;
    private static int BUFSIZE;
    private Socket sk;
    private byte[] res;
    
    /**
     * Sets the port number to its default as well as the BUFSIZE.
     */
    public Connection() {
        port = 7;
        BUFSIZE = 6;  
        res = new byte[BUFSIZE];
    }
    /**
     * Sends the a given message to the serve.
     * @param userMsg 
     */
    public boolean connectToServer(int[] userMsg) {
        System.out.println("1.2");
        int msgSize;
        byte[] res = new byte[BUFSIZE];
        res[0] = 0;
        byte[] serverMsg = new byte[BUFSIZE];
        try {
            System.out.println("1.3");            
            OutputStream out = sk.getOutputStream();
            System.out.println("1.4");
            byte[] msg = new byte[BUFSIZE];
            for (int i = 0; i < userMsg.length; i++) {
                msg[i] = (byte)userMsg[i];
                System.out.println(i + ": " +  msg[i]);
            }
            out.write(msg);                
        } catch (IOException ex) {
            System.out.println("something went bad " + ex.getMessage());
        } 
        return true;
    }    
    /**
     * Gets the InputStream being received from the server.
     * @return 
     */
    public boolean serverRead() {
        System.out.println("1.2");
        int msgSize;
        this.res = new byte[BUFSIZE];
        res[0] = 0;
        byte[] serverMsg = new byte[BUFSIZE];
        try {
            InputStream in =  sk.getInputStream();
            int i = 0;
            while((msgSize = in.read(serverMsg)) != -1) {
                System.out.println("server said --->  " + Arrays.toString(serverMsg));
                this.res = serverMsg; 
                System.out.println("res --->  " + Arrays.toString(res));
                break;
            }
            System.out.println("no close()");                 
        } catch (IOException ex) {
            System.out.println("something went bad " + ex.getMessage());
        }
        
        return true;
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
}
