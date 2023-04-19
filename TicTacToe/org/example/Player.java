package org.example;
import java.io.*;
import java.util.Scanner;

public abstract class Player {

    protected String name; //player name
    protected Board board; //board object of the game
    protected Player opponent; //opponent player which is usually oPlayer
    protected char mark; //mark of the player either 'x' or 'o'


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
        while(!(board.isFull()||board.oWins()||board.xWins())){
            makeMove();
            //System.out.println(board.getMarkCount());
            board.display();
            if (board.xWins()){
                System.out.printf("%s is the winner",name);
                winner=name;
                break;
            }
            else if(board.isFull()){
                System.out.println("The match is a tie");
                break;
            }
            else{
                opponent.makeMove();
                board.display();
                if (board.oWins()){
                    System.out.printf("%s is the winner",opponent.name);
                    winner=opponent.name;
                    break;
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
    public abstract void makeMove(); //abstract method to be implemented in all subclasses
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
}
