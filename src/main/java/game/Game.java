package game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import game.Map;

/**
 * Game Class: this is the class that contains the main function which starts the game.
 * 
 * method:
 * + main(): creates game's JFrame and starts the game.
 * + Game(): constructor for the Game object
 */


public class Game{
    //Map of the game:
     Map map = new Map();
    
    //Frame - Lowest level of display
    JFrame window;                                              
    final int Width = 600;
    final int Height = 600;

    //Container - contain the element need to display
    Container contain;                                
    JPanel introPanel, startButtonPanel, exitButtonPanel;
    JButton startButton, exitButton;
    JLabel titleGame;

    //Customize Font
    Font titelfont = new Font("SansSerif", Font.BOLD, 30);
    Font buttonfont = new Font("SansSerif", Font.BOLD, 15);

    //handle the "START" button
    TitleScreenHandler startHandler = new TitleScreenHandler();
    ResetHandler resetHandler = new ResetHandler();

    public static void main(String[] arg) {
        new Game();
        //SwingUtilities.invokeLater(new Game());
    }

    //Frame for starting panel
    public Game(){
        //Set up the frame:
        window = new JFrame();
        window.setSize(new Dimension(Width, Height));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        window.setResizable(true);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        contain = window.getContentPane();

        //Create title for the game:
        introPanel = new JPanel();
        introPanel.setBounds(50, 100, 500, 100);
        introPanel.setBackground(Color.BLACK);
        titleGame = new JLabel("Tony In need of Pennies - TIP");
        titleGame.setForeground(Color.WHITE);
        titleGame.setFont(titelfont);

        //Create a "Start" button panel:
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(250,350,100,50);
        startButtonPanel.setBackground(Color.BLACK);

        //Setting for the start button:
        startButton = new JButton("START");
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);         //color of the text
        startButton.setFont(buttonfont);
        startButton.addActionListener(startHandler);

        //Create a "Exit" button panel:
        exitButtonPanel = new JPanel();
        exitButtonPanel.setBounds(250, 400, 100, 50);
        exitButtonPanel.setBackground(Color.BLACK);

        //Setting for the exit button:
        exitButton = new JButton("EXIT");
        exitButton.setBackground(Color.BLACK);
        exitButton.setForeground(Color.WHITE);         //color of the text
        exitButton.setFont(buttonfont);
        exitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                System.exit(0);
            }
        });

        //Add all panels to container
        introPanel.add(titleGame);
        startButtonPanel.add(startButton);
        exitButtonPanel.add(exitButton);

        contain.add(introPanel);
        contain.add(startButtonPanel);
        contain.add(exitButtonPanel);
    }

    /*
    * Class for running the game - implements of Runnable
    *   + run(): generates a new game amp and resets the map.
    */
    public class RunGame implements Runnable{
        private final JFrame game = new JFrame("TIP");
        private final int Width = 600;
        private final int Height = 600;

        JPanel resetPanel;
        JButton resetButton;

        public void run() {
            
            game.setPreferredSize(new Dimension(Width, Height));
            game.pack();
            game.setResizable(true);
            game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            game.setVisible(true);
            game.setLocationRelativeTo(null);

            //Add resetButton into panel:
            resetPanel = new JPanel();
            resetPanel.setBounds(0,400,500,100);
            resetPanel.setBackground(Color.WHITE);  
            
            resetButton = new JButton("RESET");
            resetButton.setBackground(Color.WHITE);
            resetButton.setForeground(Color.BLACK);
            resetButton.setFont(buttonfont);
            resetButton.addActionListener(resetHandler);
            resetPanel.add(resetButton);

            //Add all componenets into the frame game:
            game.add(resetPanel, BorderLayout.NORTH);
            game.add(map, BorderLayout.CENTER);

            map.reset();
        }

    }

    /*
    * Class for "START" button - implements ActionListener
    *   + actionPerformed: activate the Rungame object to run the game
    */
    public class TitleScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            window.setVisible(false);
            RunGame newgame = new RunGame();
            Thread t = new Thread(newgame);
            t.start();  
        }
    }

    /*
    * Class for "RESET" button - implements ActionListener
    * 
    */
    public class ResetHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            map.reset();
        }
    }

}
