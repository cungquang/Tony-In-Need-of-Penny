package game;

/**
 * WinMessage class: creates the Message for Winning
 * 
 * methods:
 * + WinMessage(): the constructor for the class WinMessage
 * 		+ yesButton(): close the entire game
 *		+ noButton(): go back to the game
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WinMessage{
    public JFrame winMess = new JFrame("Winner");
    private int widthMess = 600;
    private int heightMess = 200;
    private Container wincontain;

    private JPanel winPanel = new JPanel();
    private JPanel yesPanel = new JPanel();
    private JPanel noPanel = new JPanel();
    private JPanel scorePanel = new JPanel();
    private JLabel wintitle = new JLabel("Congratulation! Do you want to try again?");
    private JLabel scoretitle = new JLabel();
    private JButton yesButton = new JButton("YES");
    private JButton noButton = new JButton("NO");

    private Font miniFont = new Font("SansSerif", Font.BOLD, 18);


    public WinMessage(){
        winMess.setSize(new Dimension(widthMess, heightMess));
        winMess.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        winMess.getContentPane().setBackground(Color.BLACK);
        winMess.setResizable(true);
        winMess.setLayout(null);
        winMess.setVisible(false);
        winMess.setLocationRelativeTo(null);
        wincontain = winMess.getContentPane();

        //Add winPanel
        winPanel.setBounds(10, 20, 600, 40);
        winPanel.setBackground(Color.BLACK);

        //Congrat message
        wintitle.setForeground(Color.WHITE);
        wintitle.setFont(miniFont);
        winPanel.add(wintitle);

        //YesPanel:
        yesPanel.setBounds(160, 100, 60, 40);
        yesPanel.setBackground(Color.BLACK);

        //Yes button:
        yesButton.setBackground(Color.BLACK);
        yesButton.setForeground(Color.WHITE);
        yesButton.setFont(miniFont);
        yesButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                winMess.dispose();
            }
        });

        yesPanel.add(yesButton);

        //NoPanel:
        noPanel.setBounds(400, 100, 60, 40);
        noPanel.setBackground(Color.BLACK);

        //No button:
        noButton.setBackground(Color.BLACK);
        noButton.setForeground(Color.WHITE);
        noButton.setFont(miniFont);
        noButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                System.exit(0);
            }
        });
        noPanel.add(noButton);

        //Add all panels to wincontain
        wincontain.add(winPanel);
        wincontain.add(yesPanel);
        wincontain.add(noPanel);
    }

    public void setScore(int score){
        String temp = "Score: " + score;

        //ScorePanel:
        scorePanel.setBounds(10, 60, 600, 40);
        scorePanel.setBackground(Color.BLACK);

        //Score message:
        scoretitle.setText(temp);
        scoretitle.setForeground(Color.WHITE);
        scoretitle.setFont(miniFont);
        scorePanel.add(scoretitle);

        wincontain.add(scorePanel);
    }
}