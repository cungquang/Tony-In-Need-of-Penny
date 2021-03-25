package game;

import javax.swing.*;
import java.awt.EventQueue;

import game.Map;

/**
 * Game Class: this is the class that contains the main function which starts the game.enemy_test
 * 
 * method:
 * + main():        create map and start game.
 */
public class Game extends JFrame {
    public Game() {

    }

    public static void main(String[] arg) {
        JFrame j = new JFrame("test");
        j.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Map gameMap = new Map();
        j.add(gameMap);
        j.setExtendedState(JFrame.MAXIMIZED_BOTH);
        j.setVisible(true);
    }
}
