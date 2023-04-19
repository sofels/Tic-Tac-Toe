import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.String.valueOf;

public class GameGui extends JFrame implements ActionListener, Constants {

    private Player playerO;
    private Player playerX;
    JPanel gamePanel = new JPanel();
    JPanel messagePanel = new JPanel();
    JPanel displayPlayer  = new JPanel();

    JLabel playerLabel = new JLabel("Player  :");
    JLabel userLabel = new JLabel("User name: ");
    JLabel messageLabel = new JLabel("Message Window:  ");


    JTextField playerText = new JTextField(30);
    JTextField userText = new JTextField(30);

    JTextArea messageBoard = new JTextArea(30,30);

    JButton [][] buttons  = new JButton[3][3];
    //Container con;
    private int rowIndex, columnIndex;

    public GameGui() {
        super("Welcome to Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //con = getContentPane();

        messageBoard.setEditable(false);

        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
        messagePanel.add(messageLabel);
        messagePanel.add(messageBoard);

        gamePanel.setLayout(new GridLayout(3,3));

        displayPlayer.setLayout(new GridLayout(2,2));
        displayPlayer.add(playerLabel);
        displayPlayer.add(playerText);
        displayPlayer.add(userLabel);
        displayPlayer.add(userText);
        final int[] playCount = {0};

        for (int i=0; i<3;i++){
            for(int j = 0; j<3;j++){
                buttons[i][j] = new JButton();
                gamePanel.add(buttons[i][j]);
                int finalI = i;
                int finalJ = j;
                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        rowIndex= finalI;
                        columnIndex= finalJ;
                        if (playCount[0] % 2==0){
                            buttons[finalI][finalJ].setText(valueOf(playerX.getMark()));
                            playerX.play();
                            playCount[0]++;
                        }
                        else{
                            buttons[finalI][finalJ].setText(valueOf(playerO.getMark()));
                            playerO.play();
                            playCount[0]++;
                        }
//                            buttons[finalI][finalJ].setText(valueOf(LETTER_X));
//                        if(playerG.getMark()==LETTER_O)
//                            buttons[finalI][finalJ].setText(valueOf(LETTER_O));
                        buttons[finalI][finalJ].setEnabled(false);

                    }
                });
            }
        }
        setLayout(new GridLayout(2,2));
        add(gamePanel);
        add(messagePanel);
        add(displayPlayer);
        pack();
        setSize(400,400);
        setVisible(true);


        //String xPlayerName = JOptionPane.showInputDialog("Please, enter name of X Player");
        //String oPlayerName = JOptionPane.showInputDialog("Please, enter name of O Player");

        //messageBoard.append("\nPlayer X is:  "+ xPlayerName);
        //messageBoard.append("\nPlayer O is:  "+ oPlayerName);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public Player getPlayerO() {
        return playerO;
    }

    public void setPlayerO(Player playerO) {
        this.playerO = playerO;
    }

    public void setPlayerX(Player playerX) {
        this.playerX = playerX;
    }

    public Player getPlayerX() {
        return playerX;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }

//    public static void main(String[] args) {
//        new GameGui();
//    }
}
