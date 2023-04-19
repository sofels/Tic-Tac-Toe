package org.example;

//STUDENTS SHOULD ADD CLASS COMMENTS, METHOD COMMENTS, FIELD COMMENTS 


public class Board implements Constants {
	private char theBoard[][];
	private int markCount;

	/**
	 * Class contrustor that initialises the board with empty playing positions
	 */
	public Board() {
		markCount = 0;
		theBoard = new char[3][];
		for (int i = 0; i < 3; i++) {
			theBoard[i] = new char[3];
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		}
	}
	/**
	 * This method receives the row and column index and returns the character played in tha position on the board
	 * @param row integer index of row
	 * @param col integer index of column
	 * @return char in the postion of row,column
	 */
	public char getMark(int row, int col) {
		return theBoard[row][col];
	}
	/**
	 * Checks if all the spaces on the board have being played (9 spaces) and returns True or False
	 * the markCount counter is used to check if the board is full
	 * @return return status of the board if all 9 spaces are filled or not.
	 */

	public boolean isFull() {
		return markCount >= 9;
	}

	/**
	 * Checks if the xPlayer has a win by calling the checkWinner function. Return True or False
	 * @return boolean if xPlayer wins or not
	 */
	public boolean xWins() {
		if (checkWinner(LETTER_X) == 1)
			return true;
		else
			return false;
	}

	/**
	 * Checks if the oPlayer has a win by calling the checkWinner function. Return True or False
	 * @return boolean if oPlayer wins or not
	 */
	public boolean oWins() {
		if (checkWinner(LETTER_O) == 1)
			return true;
		else
			return false;
	}
	/**
	 * displays the current state of the board. This function is called after eah player plays
	 */
	public void display() {
		displayColumnHeaders();
		addHyphens();
		for (int row = 0; row < 3; row++) {
			addSpaces();
			System.out.print("    row " + row + ' ');
			for (int col = 0; col < 3; col++)
				System.out.print("|  " + getMark(row, col) + "  ");
			System.out.println("|");
			addSpaces();
			addHyphens();
		}
	}

	/**
	 * This function adds the char x or o played by the player to a position on the board specified by row and col.
	 * it also increases the markCount which is used to determine if the board is full
	 * @param row row position on the board
	 * @param col column position on the board to be played
	 * @param mark char x or o depending on which player played
	 */
	public void addMark(int row, int col, char mark) {
		
		theBoard[row][col] = mark;
		markCount++;
	}

	/**
	 * This function resets the board.
	 */
	public void clear() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		markCount = 0;
	}

	/**
	 * This function uses the rule of the game to check is there is a winner after each play
	 * @param mark used the char x or o to check if xPlayer or oPlayer has won
	 * @return returns an interger 1 indicating a win
	 */
	int checkWinner(char mark) {
		int row, col;
		int result = 0;

		for (row = 0; result == 0 && row < 3; row++) {
			int row_result = 1;
			for (col = 0; row_result == 1 && col < 3; col++)
				if (theBoard[row][col] != mark)
					row_result = 0;
			if (row_result != 0)
				result = 1;
		}

		
		for (col = 0; result == 0 && col < 3; col++) {
			int col_result = 1;
			for (row = 0; col_result != 0 && row < 3; row++)
				if (theBoard[row][col] != mark)
					col_result = 0;
			if (col_result != 0)
				result = 1;
		}

		if (result == 0) {
			int diag1Result = 1;
			for (row = 0; diag1Result != 0 && row < 3; row++)
				if (theBoard[row][row] != mark)
					diag1Result = 0;
			if (diag1Result != 0)
				result = 1;
		}
		if (result == 0) {
			int diag2Result = 1;
			for (row = 0; diag2Result != 0 && row < 3; row++)
				if (theBoard[row][3 - 1 - row] != mark)
					diag2Result = 0;
			if (diag2Result != 0)
				result = 1;
		}
		return result;
	}

	/**
	 * This function uses a for loop to create columns headers
	 */
	void displayColumnHeaders() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|col " + j);
		System.out.println();
	}

	/**
	 * This function used a for loop to draw horizontal lines to design the board
	 */
	void addHyphens() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("+-----");
		System.out.println("+");
	}
	
	/**
	 * This uses a for loop for vertical lines to desgign the board
	 */
	void addSpaces() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|     ");
		System.out.println("|");
	}

	/**
	 * Returns the current number of spaces that has been played
	 * @return returns an integer which represents all the spaces played so far by both players
	 */
	public int getMarkCount() {
		return markCount;
	}

	public void setMarkCount(int markCount){
		this.markCount=markCount;
	}

	
}
