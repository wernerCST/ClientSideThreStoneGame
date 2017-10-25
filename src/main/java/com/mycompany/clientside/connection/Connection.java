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
 *
 * @author 1511430
 */
public class Connection {
    
    private int port;
    private String server;
    private static int BUFSIZE;
    private Socket sk;
    
    public Connection() {
        port = 7;
        BUFSIZE = 32;    
    }
    public void connectToServer(int[] userMsg) {
        System.out.println("1.2");
        int msgSize;
        byte[] res = new byte[32];
        res[0] = 0;
        byte[] serverMsg = new byte[BUFSIZE];
        try {
            System.out.println("1.3");            
            OutputStream out = sk.getOutputStream();
            System.out.println("1.4");
            byte[] msg = new byte[32];
            for (int i = 0; i < userMsg.length; i++) {
                msg[i] = (byte)userMsg[i];
                System.out.println(i + ": " +  msg[i]);
            }
            out.write(msg);
            System.out.println("no close()");                 
        } catch (Exception ex) {
            System.out.println("something went bad " + ex.getMessage());
        }       
    }    
      public byte[] serverRead() {
        System.out.println("1.2");
        int msgSize;
        byte[] res = new byte[32];
        res[0] = 0;
        byte[] serverMsg = new byte[BUFSIZE];
        try {
            InputStream in =  sk.getInputStream();
            int i = 0;
            while((msgSize = in.read(serverMsg)) != -1) {
                System.out.println("server said --->  " + Arrays.toString(serverMsg));
                res = serverMsg; 
                System.out.println("res --->  " + Arrays.toString(res));
                break;
            }
            System.out.println("no close()");                 
        } catch (Exception ex) {
            System.out.println("something went bad " + ex.getMessage());
        }
        return res;        
    } 
      public void setIP(String ip) throws IOException {
          this.sk = new Socket(ip, port);
      }
}
