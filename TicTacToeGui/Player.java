import java.io.*;
import java.util.Scanner;

import static java.lang.String.valueOf;

/**
 * This class initialises each player and assigns its mark 'x' or 'o'
 * It also allows the players to make their moves and this is passed to the Board class for display.
 */
public class Player {

    private String name; //player name
    private Board board; //board object of the game
    private Player opponent; //opponent player which is usually oPlayer
    private char mark; //mark of the player either 'x' or 'o'

    private GameGui gameGui;


    /**
     * Class contruction which initialises the name of the player and the representative mark x or o
     * @param name name of the player
     * @param mark char representation of the player, either 'o' or 'x'
     */
    public Player(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

    /**
     * Initiaited the move of each player. It checks to be sure there is no winner and that the board isnt full.
     * If any of these conditions is true, it retunrs the name of the winner or that it is a tie if the board is full with no winner.
     * it calls the makeMove method of this class to request for where the player wants to play and displays the board after.
     */
    public void play(){
        String winner = "";
        if(!(board.isFull()||board.oWins()||board.xWins())){
            gameGui.playerText.setText(valueOf(mark));
            gameGui.userText.setText(name);
            int row= gameGui.getRowIndex(), column = gameGui.getColumnIndex();
            board.addMark(row, column, mark);
            //makeMove();
            board.display();
            if (board.xWins()){
                System.out.printf("%s is the winner",name);
                gameGui.messageBoard.append("\n"+name+" is the winner");
                winner=name;
                //break;
            }
            else if(board.isFull()){
                System.out.println("The match is a tie");
                gameGui.messageBoard.append("\n"+"The game is a tie");
                //break;
            }
            else{
                //gameGui.playerText.setText(valueOf(opponent.mark));
                //gameGui.userText.setText(opponent.name);
                //opponent.makeMove();
                //board.display();
                if (board.oWins()){
                    System.out.printf("%s is the winner",name);
                    gameGui.messageBoard.append("\n"+name+ " is the winner");
                    //winner=opponent.name;
                    //break;
                }
            }

        }
    }

    /**
     * This method received the position where the player wants to play and the mark of the player.
     * It checks that the inputed values are intergers, within index of 0-2 and that the space to be played is empty
     * If any of this condition is not met, the player loses their turn
     * It uses a try-catch block to check the criteria and raises the appropriate exception
     */
    public void makeMove(){
        Scanner scan = new Scanner(System.in);
        int row= gameGui.getRowIndex(), column = gameGui.getColumnIndex();
		System.out.printf("%s, what row should your next %c be placed in? ", name, mark);
		try{
            row= Integer.parseInt(scan.nextLine());
            System.out.printf("%s, what column should your next %c be placed in? ", name, mark);
            column= Integer.parseInt(scan.nextLine());
            if(board.getMark(row, column) == ' ')
                board.addMark(row, column, mark);
            else
                System.out.println("You attempted to play in a filled space and loast your turn");
        }
        catch(NumberFormatException e){
            System.err.println("Inputted value is not an integer, you have lost your turn");
        }
        catch(IndexOutOfBoundsException ee){
            System.err.println("Inputted value is not withing the range of 0 and 2, you have lost your turn");
        }
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getMark() {
        return mark;
    }

    public void setMark(char mark) {
        this.mark = mark;
    }

    /**
     * it sets the player that will be the opponent
     * @param opponent Player object represent the opponent which is usually oPlayer
     */
    public void setOpponent(Player opponent){
        this.opponent=opponent;
    }

    /**
     * Sets the board by initializing the board object to the arg
     * @param theBoard Board object of the board of the game
     */
    public void setBoard(Board theBoard){
        this.board =theBoard;
    }

    public GameGui getGameGui() {
        return gameGui;
    }

    public void setGameGui(GameGui gameGui) {
        this.gameGui = gameGui;
    }
}
