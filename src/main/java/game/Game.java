package game;

import javax.swing.*;
import java.awt.EventQueue;

import game.Map;

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
