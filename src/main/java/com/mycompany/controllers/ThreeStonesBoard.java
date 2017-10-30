/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

/**
 *
 * @author 1511430
 */
public class ThreeStonesBoard {
    //represent board with 2-dimensional array
    private Button[][] board;
    
    /**
     * Default constructor for a ThreeStonesBoard object.
     */
    public ThreeStonesBoard() {
        this.board = new Button[11][11];
    }
    
    /**
     * Places a Stone on the board at the given coordinates.
     * 
     * @param stone The Stone to place on the board.
     * @param x The x-coordinate of the placement location.
     * @param y The y-coordinate of the placement location.
     */
    public void setStoneAt(Button stone, int x, int y) {
        board[x][y] = stone;
    }
    
    /**
     * Retrieves the value of a Stone on the board at the given coordinates.
     * 
     * @param x The x-coordinate of the Stone to find.
     * @param y The y-coordinate of the Stone to find.
     * @return  The Stone at the given coordinates.
     */
    public Button getStoneAt(int x, int y) {
        return board[x][y];
    }
    public String getIndexOfStone(Button item) {
        String res = "";
        for (int i = 0; i < board.length; i++) {
            
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j].equals(item)) {
                    res = i + "," + j;
                }
            }
            
        }       
        
        return res;
    }
}
