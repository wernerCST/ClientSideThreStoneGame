/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clientside.connection;

import java.io.IOException;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1511430
 */
public class Connection {
    
    private final int port = 7;
    private final String server = "10.172.14.194";
    private static final int BUFSIZE = 32; 
    
    public Connection() {
        
    }
    public void connectToServer() {
        int msgSize;
        byte[] serverMsg = new byte[BUFSIZE];
        try {
            Socket sk = new Socket(server, port);
            InputStream in = sk.getInputStream();
            OutputStream out = sk.getOutputStream();
            byte[] msg = getUserInput();
            out.write(msg);
            while((msgSize = in.read(serverMsg)) != -1) {
                System.out.println("server said --->  " + new String(serverMsg));
            }
        } catch (IOException ex) {
            System.out.println("something went bad " + ex.getMessage());
        }
        
    }

    private byte[] getUserInput() {        
        Scanner in = new Scanner(System.in);
        byte[] bts = in.next().getBytes();
        in.close();
        return bts;
    }
    
}
