package org.example;
import java.util.Scanner;

public class RandomPlayer extends Player {

    public RandomGenerator rand;
    public RandomPlayer(String name, char mark) {
        super(name,mark);
    }

    /**
     * This method plays in random empty spaces on the board
     * It uses an object of the RandomGenerator class to generate a random position to play
     * A while loop is used to scan for an empty space to play
     */
    public void makeMove(){
        System.out.println("Random Player playing");
        int row, column;
        int i =0;
        rand = new RandomGenerator();
        while(i<1) {
            row = rand.discrete(0, 2);
            column = rand.discrete(0, 2);
            if (board.getMark(row, column) == ' ') {
                board.addMark(row, column, mark);
                ++i;
            }
        }
    }
}
