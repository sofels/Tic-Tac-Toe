package org.example;
import java.io.IOException;

public class Referee {
    private Player xPlayer; //creates xPlayer
    private Player oPlayer; //creates oPlayer
    private Board board; //creates the Board


    /**
     * This is where the player of the game starts from.
     * This is the method that sets the first player and the opponent.
     * It displays the board which is empty at this point.
     * It starts the game with xPlayer
     * 
     */
    public void runTheGame(){
        xPlayer.setOpponent(oPlayer);
        board.display();
        xPlayer.play();

    }

    /**
     * setter method for xPlayer
     * @param xPlayer player x
     */
    public void setxPlayer(Player xPlayer) {
        this.xPlayer = xPlayer;
    }

    /**
     * setter method for oPlayer
     * @param oPlayer player o
     */
    public void setoPlayer(Player oPlayer) {
        this.oPlayer = oPlayer;
    }

    /**
     * setter method for the Board object
     * @param board Board object
     */
    public void setBoard(Board board) {
        this.board = board;
    }    
}
