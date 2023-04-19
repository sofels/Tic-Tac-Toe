
import javax.swing.*;
import java.io.*;

//STUDENTS SHOULD ADD CLASS COMMENTS, METHOD COMMENTS, FIELD COMMENTS 
/**
 * This is the starting point of the Game and it implements the constant interface
 */

public class Game implements Constants {

	private Board theBoard; //Board object for playing the ga,e
	private Referee theRef; //Referee object that starts the game

	private static GameGui theGameGui;
	/**
	 * This is the class constructor and initializes Board object
	 */
	
    public Game( ) {
        theBoard  = new Board();
		theGameGui = new GameGui();
	}

	/**
	 * This method takes a referee object and calls the runTheGame function in the referee calls
	 * This call to runTheGame starts the game
	 * @param r This referee object to stat the game
	 * @throws IOException
	 */
    
    public void appointReferee(Referee r) throws IOException {
        theRef = r;
    	theRef.runTheGame();
    }
	
	/**
	 * This is the main method the the TicTacToe application. 
	 * It initialises objects of Refereee and Game classes.
	 * It initialises two players: xPlayer for x and oPlayer for o
	 * It requests the names of the players from the user and creates them using Player class
	 * The objects of the Players and Referee classes are then used to set the board of the game using the setboard method and
	 * the board variable of the game class is passed to it
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Referee theRef;
		Player xPlayer, oPlayer; //creating players
		BufferedReader stdin;
		Game theGame = new Game(); //creating game object
		String xPlayerName = JOptionPane.showInputDialog("Please, enter name of X Player");
//		stdin = new BufferedReader(new InputStreamReader(System.in));
//		System.out.print("\nPlease enter the name of the \'X\' player: ");
//		String name= stdin.readLine(); //reading xPlayer name
//		while (name == null) {
//			System.out.print("Please try again: ");
//			name = stdin.readLine();
//		}

		xPlayer = new Player(xPlayerName, LETTER_X); //setting xPlayer name
		xPlayer.setBoard(theGame.theBoard);
		xPlayer.setGameGui(theGame.theGameGui);
		theGameGui.messageBoard.append("\nPlayer X is:  "+ xPlayerName);
		
		//Reading and setting oPlayer name
		String oPlayerName = JOptionPane.showInputDialog("Please, enter name of O Player");
//		System.out.print("\nPlease enter the name of the \'O\' player: ");
//		name = stdin.readLine();
//		while (name == null) {
//			System.out.print("Please try again: ");
//			name = stdin.readLine();
//		}
		
		oPlayer = new Player(oPlayerName, LETTER_O);
		oPlayer.setBoard(theGame.theBoard);
		oPlayer.setGameGui(theGame.theGameGui);
		theGameGui.messageBoard.append("\nPlayer O is:  "+ oPlayerName);
		
		//initialising referee and assigning players and board objects to the referee object
		theRef = new Referee();
		theRef.setBoard(theGame.theBoard);
		theRef.setGameGui(theGame.theGameGui);
		theRef.setoPlayer(oPlayer);
		theRef.setxPlayer(xPlayer);
        
        theGame.appointReferee(theRef); //this appoints the referee to the game and starts the game
	}

	public GameGui getTheGameGui() {
		return theGameGui;
	}

	public void setTheGameGui(GameGui theGameGui) {
		this.theGameGui = theGameGui;
	}
}
