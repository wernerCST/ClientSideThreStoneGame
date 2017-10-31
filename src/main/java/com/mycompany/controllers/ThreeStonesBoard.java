
package com.mycompany.controllers;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

/**
 * A ThreeStonesBoard class defines a two dimensional Button array
 * of the board being displayed on the view.
 * 
 * @author Hannah Ly
 * @author Peter Bellefleur MacCaul
 * @author Werner Castanaza
 */
public class ThreeStonesBoard {
    //represent board with 2-dimensional array
    private Button[][] board;
    
    /**
     * Default constructor for a ThreeStonesBoard object.
     */
    public ThreeStonesBoard() {
        this.board = new Button[11][11];
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                board[i][j] = new Button();
            }
        }
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
     * Retrieves the value of a Stone on the board at the given coordinates,
     * it returns a x and y index in string format coma separated.
     * 
     * @param x The x-coordinate of the Stone to find.
     * @param y The y-coordinate of the Stone to find.
     * @return  The Stone at the given coordinates.
     */
    public Button getStoneAt(int x, int y) {
        return board[x][y];
    }
    /**
     * 
     * @param item
     * @return 
     */
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
