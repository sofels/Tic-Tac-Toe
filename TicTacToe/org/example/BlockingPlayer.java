package org.example;
public class BlockingPlayer extends RandomPlayer {
    public BlockingPlayer(String name, char mark) {
        super(name,mark);
    }

    /**
     * This method checks if there is a possiblity for the opponent to win by calling the testForBlocking() method
     *If there is method retunrs true, it plays in that position otherwise plays in a random space
     * A nested for loop is used to scan through the board and nested if statement to check for condition
     * A boolean variable, done, is used to break of both for loops
     */
    @Override
    public void makeMove() {
        boolean done = false;
        for (int i = 0; i < 3 && !done; i++) {

            for (int j = 0; j < 3; j++) {
                if (board.getMark(i, j) == ' ') {
                    if (testForBlocking(i, j, mark)) {
                        board.addMark(i, j, mark);
                        board.setMarkCount((board.getMarkCount()-1));
                        //System.out.println("blocking is true and mark added and mark for blockes is" + mark);
                        done = true;
                        //return 1;
                        break;
                    }
                }

            }
        }
        //is there is no blocking move, this is executed
        if (!done){
            //System.out.println("blocking is false and random player called");
            int r, c;
            int count =0;
            RandomGenerator rand = new RandomGenerator();
            while(count<1) {
                r = rand.discrete(0, 2);
                c = rand.discrete(0, 2);
                if (board.getMark(r, c) == ' ') {
                    board.addMark(r, c, mark);
                    ++count;
                }
            }
    }
    }


    /**
     * This method checks a space with the character of the opponent to see if the opponent can win
     * @param row row on the board
     * @param column column on the board
     * @param c char of the opponent of blocking player
     * @return returns true if the opponent can win otherwise returns falsse
     */
    public boolean testForBlocking(int row, int column, char c) {
        char ch;
        if (c=='O') {
            ch = 'X';
            board.addMark(row, column, ch);
            if (board.xWins()) {
                return true;
            }
        }
        else if(c=='X'){
            ch = 'O';
            board.addMark(row, column, ch);
            if (board.oWins()) {

                return true;
            }
        }
        board.addMark(row, column, ' ');
        board.setMarkCount((board.getMarkCount()-2));
        return false;
    }
}
