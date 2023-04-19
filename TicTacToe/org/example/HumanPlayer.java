package org.example;
import java.util.Scanner;

public class HumanPlayer extends Player {
    public HumanPlayer(String name, char mark) {
        super(name, mark);
    }

    /**
     * This method received the position where the player wants to play and the mark of the player.
     * It checks that the inputed values are intergers, within index of 0-2 and that the space to be played is empty
     * If any of this condition is not met, the player loses their turn
     * It uses a try-catch block to check the criteria and raises the appropriate exception
     */
    public void makeMove(){
        Scanner scan = new Scanner(System.in);
        int row, column;
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

}
