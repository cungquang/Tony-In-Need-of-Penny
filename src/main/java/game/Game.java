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
    public void run() {
        JFrame game = new JFrame("Pac-Man");
        game.setExtendedState(JFrame.MAXIMIZED_BOTH);

        Map map = new Map();
        game.add(map, BorderLayout.CENTER);

        game.pack();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setVisible(true);

        map.reset();
    }

    public static void main(String[] arg) {
        SwingUtilities.invokeLater(new Game());
    }
}
