package game;

import javax.swing.*;
import java.awt.*;

import game.Map;

/**
 * Game Class: this is the class that contains the main function which starts the game.
 * 
 * method:
 * + main():        creates game's JFrame and starts the game.
 */
public class Game implements Runnable {
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

    public static void main(String[] arg) {
        SwingUtilities.invokeLater(new Game());
    }
}
