package org.example;
public class SmartPlayer extends BlockingPlayer {
    public SmartPlayer(String name, char mark) {
        super(name, mark);
    }

    @Override
    public void makeMove() {
        boolean done = false;
        for (int i = 0; i < 3 && !done; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getMark(i, j) == ' ') {
                    if (testForWinning(i, j, mark)) {
                        board.addMark(i, j, mark);
                        board.setMarkCount((board.getMarkCount() - 1));
                        //System.out.println("Winning is true and mark added and mark for winning is" + mark);
                        done = true;
                        break;
                    }
                }

            }
        }
        for (int i = 0; i < 3 && !done; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getMark(i, j) == ' ') {
                    if (testForBlocking(i, j, mark)) {
                        board.addMark(i, j, mark);
                        board.setMarkCount((board.getMarkCount() - 1));
                        //System.out.println("blocking is true and mark added and mark for winning is" + mark);
                        done = true;
                        break;
                    }
                }

            }
        }
        if (!done){
            //System.out.println("blocking is false and random player called");
            int r, c;
            int count = 0;
            RandomGenerator rand = new RandomGenerator();
            while (count < 1) {
                r = rand.discrete(0, 2);
                c = rand.discrete(0, 2);
                if (board.getMark(r, c) == ' ') {
                    board.addMark(r, c, mark);
                    ++count;
                }
            }
        }
    }

    public boolean testForWinning(int row, int column, char c) {
        board.addMark(row, column, c);
        if (c == 'X' && board.xWins()) {
                return true;
        }
        else if (c == 'O' && board.oWins()) {
                return true;
        }
        else {
            board.addMark(row, column, ' ');
            board.setMarkCount((board.getMarkCount() - 2));
            return false;
        }
    }

}
