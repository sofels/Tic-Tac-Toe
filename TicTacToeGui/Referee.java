import java.io.IOException;

import static java.lang.String.valueOf;

/**
 * This class sets the xPlayer as the first player and oPlayer as the opponent.
 * It then displays the board and kicks off the game with xPlayer calling play() of Player class
 */
public class Referee {
    private Player xPlayer; //creates xPlayer
    private Player oPlayer; //creates oPlayer
    private Board board; //creates the Board

    private GameGui gameGui;


    /**
     * This is where the player of the game starts from.
     * This is the method that sets the first player and the opponent.
     * It displays the board which is empty at this point.
     * It starts the game with xPlayer
     * 
     */
    public void runTheGame(){
        xPlayer.setOpponent(oPlayer); //sets oPlayer as opponent
        board.display(); //shows empty board
        gameGui.messageBoard.append("\nPlayer X starts");
        //gameGui.userText.setText(xPlayer.getName());
        //gameGui.playerText.setText(valueOf(xPlayer.getMark()));
        //xPlayer.play(); //starts the game with xPlayer

    }

    /**
     * setter method for xPlayer
     * @param xPlayer player x
     */
    public void setxPlayer(Player xPlayer) {

        this.xPlayer = xPlayer;
        gameGui.setPlayerX(xPlayer);
    }

    /**
     * setter method for oPlayer
     * @param oPlayer player o
     */
    public void setoPlayer(Player oPlayer) {

        this.oPlayer = oPlayer;
        gameGui.setPlayerO(oPlayer);
    }

    /**
     * setter method for the Board object
     * @param board Board object
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    public void setGameGui(GameGui gameGui) {
        this.gameGui = gameGui;
    }
}
