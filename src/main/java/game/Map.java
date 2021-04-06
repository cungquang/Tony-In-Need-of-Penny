package game;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;

import game.Wall;
import game.Character;

/**
 * Map class: creates and draws the map
 * 
 * - int[][] level: contains the map data.
 * 
 * methods:
 * + getLocation():     returns the object at the given location
 * + setLocation():     sets the object at the given location
 * + paintComponent():  swing method for drawing the components to the JPanel
 * - drawWals():        draws the walls of the map and the rewards
 */
public class Map extends JPanel {
    private Character player;
    private Wall wall;

    private Prize bonus[];
    private Prize reward[];

    private boolean playing = false;
    public static final int INTERVAL = 35;

    public final static int BLOCK_SIZE = 25;
    public final static int NUM_BLOCKS = 20;
    public static final int MAP_WIDTH = BLOCK_SIZE * NUM_BLOCKS;
    public static final int MAP_HEIGHT = MAP_WIDTH + 50;

    public Map() {
        setBackground(Color.GRAY);
        Timer timer = new Timer(INTERVAL, new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                gameTick();
            }
        });
        timer.start();

        setFocusable(true);

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                playing = true;
                if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                    player.move('l');
                            System.out.println("Bonus: " + wall.NoOfPrize()[0]);
        System.out.println("Reward: " + wall.NoOfPrize()[1]);
                } else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    player.move('r');
                } else if(e.getKeyCode() == KeyEvent.VK_UP) {
                    player.move('u');
                } else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                    player.move('d');
                }
            } 
        });
    }

    public void reset() {
        wall = new Wall(MAP_WIDTH, MAP_HEIGHT, BLOCK_SIZE, NUM_BLOCKS);
        wall.reset();
        player = Character.getInstance(this);



        requestFocusInWindow();
        playing = false;
        repaint();
    }

    void gameTick() {
        if(playing) {
            repaint();
        }
    }

    public int getLocation(int x, int y) {
        return wall.getLocation(x, y);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        wall.draw(g);
        player.draw(g);
    }
}