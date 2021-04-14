package game;
import javax.swing.*;

import game.Map;

import java.awt.*;
import java.awt.event.*;
public class punishment extends JFrame{
    /**
     *
     */
    private static final long serialVersionUID = 1L;


    public JFrame pFrame = new JFrame("Game Over");
    private int widthMess = 600;
    private int heightMess = 200;
    private Container pcontain;

    private JPanel pPanel = new JPanel();
    private JPanel yesPanel = new JPanel();
    private JPanel noPanel = new JPanel();

    private JLabel pTitle = new JLabel("GAME OVER!!!!Do you want to play again?");

    private JButton yesButton = new JButton("YES");
    private JButton noButton = new JButton("NO");

    
    private Font miniFont = new Font("SansSerif", Font.BOLD, 18);


    public punishment(){
        pFrame.setSize(new Dimension(widthMess, heightMess));
        pFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pFrame.getContentPane().setBackground(Color.white);
        pFrame.setResizable(true);
        pFrame.setLayout(null);
        pFrame.setVisible(false);
        pFrame.setLocationRelativeTo(null);

        pcontain = pFrame.getContentPane();

        pTitle.setForeground(Color.BLACK);
        pTitle.setFont(miniFont);
        pPanel.add(pTitle);
        // the background of the punishment
        pPanel.setBounds(10, 20, 600, 40);
        pPanel.setBackground(Color.WHITE);
        //Check buttom;
        yesPanel = new JPanel();
        yesPanel.setBounds(100, 100, 60, 40);
        yesPanel.setBackground(Color.white);

        yesButton.setBackground(Color.black);
        yesButton.setForeground(Color.WHITE);
        yesButton.setFont(miniFont);
        yesButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                pFrame.dispose();
            }
        });
        yesPanel.add(yesButton);


        noPanel = new JPanel();
        noPanel.setBounds(400, 100, 60, 40);
        noPanel.setBackground(Color.white);

        //No button:
        noButton.setBackground(Color.black);
        noButton.setForeground(Color.WHITE);
        noButton.setFont(miniFont);
        noButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                System.exit(0);
            }
        });

        noPanel.add(noButton);


        pcontain.add(pPanel);
        pcontain.add(noPanel);
        pcontain.add(yesPanel);
        pFrame.setUndecorated(true);
    }
    
}
