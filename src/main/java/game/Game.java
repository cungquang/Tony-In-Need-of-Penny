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
    //Frame - Lowest level of display
    JFrame window;                                              
    final int Width = 600;
    final int Height = 600;

    //Container - contain the element need to display
    Container contain;                                
    JPanel introPanel, startButtonPanel;
    JButton startButton;
    JLabel titleGame;

    //Customize Font
    Font titelfont = new Font("SansSerif", Font.BOLD, 30);
    Font buttonfont = new Font("SansSerif", Font.BOLD, 15);

    TitleScreenHandler startHandler = new TitleScreenHandler();


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

        //Create a "Start" button for the game:
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(250,400,100,50);
        startButtonPanel.setBackground(Color.BLACK);

        //Set up for the start button:
        startButton = new JButton("START");
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);         //color of the text
        startButton.setFont(buttonfont);
        startButton.addActionListener(startHandler);


        //Add all panels to container
        introPanel.add(titleGame);
        startButtonPanel.add(startButton);

        contain.add(introPanel);
        contain.add(startButtonPanel);
    }

    /*
    * Class for running the game - implements of Runnable
    *   + run(): generates a new game amp and resets the map.
    */
    public class RunGame implements Runnable{
        private final JFrame game = new JFrame("Pac-Man");
        private final int Width = 600;
        private final int Height = 600;


        public void run() {
            Map map = new Map();
            game.add(map, BorderLayout.CENTER);

            game.setPreferredSize(new Dimension(Width, Height));
            game.pack();
            game.setResizable(true);
            game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            game.setVisible(true);
            game.setLocationRelativeTo(null);

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
}
