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
 * methods:
 * + Map():             starts the game timer and listens for key inputs
 * + reset():           resets the level
 * + gameTick():        repaints level at each game tick
 * + getLocation():     returns the item at the requested location on the map
 * + paintComponent():  method needed to draw all the components on the JPanel
 * - drawScore():       draws the score on the JPanel
 */
public class Map extends JPanel {
    private Character player;
    private Wall wall;
    
    private PrizeFactory prizefactory;
    private final int BASESCORE = 70;
    private final int PRIZEVALUE = 5;
    private final int DOOR_X = 19;
    private final int DOOR_Y = 19;
    public Prize bonus[];
    public Prize reward[];
    private Door door;

    private boolean playing = true;
    private JLabel EndMessage;
    public static final int INTERVAL = 35;


    public final static int BLOCK_SIZE = 25;
    public final static int NUM_BLOCKS = 20;
    public static final int MAP_WIDTH = BLOCK_SIZE * NUM_BLOCKS;
    public static final int MAP_HEIGHT = MAP_WIDTH + 50;

    private Enemy enemy1 = new Enemy(this, 10, 11);
    private Enemy enemy2 = new Enemy(this, 1, 19);
    private Enemy enemy3 = new Enemy(this, 18,18);
    private Enemy enemy4 = new Enemy(this, 18, 3);
    private Enemy enemy5 = new Enemy(this, 6, 6);
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
                int i = 1;
                if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                    i = player.move('l');
                } else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    i = player.move('r');
                } else if(e.getKeyCode() == KeyEvent.VK_UP) {
                    i = player.move('u');
                } else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                    i = player.move('d');
                }
                if(i == 0){enemy1.move_enemy(player);
                           enemy2.move_enemy(player);
                           //enemy3.move_enemy(player);
                           //enemy4.move_enemy(player);
                           //enemy5.move_enemy(player);
                        }

                       
            }
        });
    }

    public void reset() {
        wall = new Wall(MAP_WIDTH, MAP_HEIGHT, BLOCK_SIZE, NUM_BLOCKS);
        wall.reset();
        player = Character.getInstance(this);
        door = new Door(wall,DOOR_X,DOOR_Y);

        prizefactory = new PrizeFactory(wall,PRIZEVALUE);
        bonus = prizefactory.GetBonusArray();
        reward = prizefactory.GetRewardArray();

        requestFocusInWindow();
        playing = false;
        repaint();
    }

    void gameTick() {

        //game runing:
        if(playing) {
            repaint();
        }

        //game wining mode:
        if(player.getdX() == door.getX() & player.getdY() == door.getY()){
            playing = false;
        }
    }

    public int getLocation(int x, int y) {
        return wall.getLocation(x, y);
    }

    //Draw Scores
    private void drawScore(Graphics g) {
        Font smallFont = new Font("SansSerif", Font.BOLD, 18);
        g.setFont(smallFont);
        g.setColor(new Color(5, 180, 80));
        String Gs = "Reward_Score: " + player.getReward_Score();
        String Bs = "Bonus_Score: "+ player.getBonus_Score();
        g.drawString(Gs, 20, 530+ 16);
        g.drawString(Bs, 250, 530 + 16);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        wall.draw(g);
        drawScore(g);

        //Draw Bonus Object:
        for(int i = 0; i < prizefactory.NoOfBonus(); i++){
            if(bonus[i].getStatus()){
                player.IsPrize();
                bonus[i].draw(g,BLOCK_SIZE);
            }
        }

        //Draw Reward Object:
        for(int i = 0; i < prizefactory.NoOfReward(); i++){
            if(reward[i].getStatus()){
                player.IsPrize();
                reward[i].draw(g,BLOCK_SIZE);
            }
        }

        if(player.getReward_Score() >= BASESCORE){
            door.draw(g, BLOCK_SIZE, wall);
        }

        player.draw(g);
        
        enemy1.draw(g);
        enemy2.draw(g);
        //enemy3.draw(g);
        //enemy4.draw(g);
        //enemy5.draw(g);
        
    }
}