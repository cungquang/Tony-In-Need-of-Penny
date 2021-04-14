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
import javax.swing.plaf.TextUI;

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
    private Font miniFont = new Font("SansSerif", Font.BOLD, 15);
    private punishment Punishment = new punishment();
    private Wall wall = new Wall(BLOCK_SIZE);
    private Character player = Character.getInstance(this);
    private WinMessage winning = new WinMessage();
    
    private PrizeFactory prizefactory;
    private final int BASESCORE = 70;
    private final int PRIZEVALUE = 5;
    private final int DOOR_X = 18;
    private final int DOOR_Y = 19;
    public Prize bonus[];
    public Prize reward[];
    private final Door door = new Door(wall,DOOR_X,DOOR_Y);

    private boolean playing = true;
    private JLabel EndMessage;
    public static final int INTERVAL = 35;


    public final static int BLOCK_SIZE = 25;

    private Enemy enemy1 = new Enemy(this, 10, 11);
    private Enemy enemy2 = new Enemy(this, 1, 19);
    //private Enemy enemy3 = new Enemy(this, 18,18);
    //private Enemy enemy4 = new Enemy(this, 18, 3);
    //private Enemy enemy5 = new Enemy(this, 6, 6);


    public Map() {
        setBackground(Color.GRAY);

        //add Prizes
        prizefactory = new PrizeFactory(wall,PRIZEVALUE);
        bonus = prizefactory.getBonusArray();
        reward = prizefactory.getRewardArray();
        
        Timer timer = new Timer(INTERVAL, new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                gameTick();
            }
        });
        timer.start();

        setFocusable(true);

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
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
                if(i == 0){enemy1.moveEnemy(player);
                           enemy2.moveEnemy(player);
                           //enemy3.moveEnemy(player);
                           //enemy4.moveEnemy(player);
                           //enemy5.moveEnemy(player);
                        }  
            }
        });
    }

    public void reset() {
        door.resetDoor(wall);
        wall.reset();
        prizefactory = new PrizeFactory(wall,PRIZEVALUE);
        player.ResetPosition();
        bonus = prizefactory.getBonusArray();
        reward = prizefactory.getRewardArray();
        enemy1 = null;
        enemy2 = null;
        enemy1 = new Enemy(this, 10, 11);
        enemy2 = new Enemy(this, 1, 19);
        requestFocusInWindow();
        repaint();
    }

    void gameTick() {

        //game runing:
        if(playing) {
            repaint();
        }

        //game wining mode:
        if(wall.getLocation(DOOR_X, DOOR_Y) == 9 & player.getdX() == door.getX() & player.getdY() == door.getY()){
            playing = false;
            winning.setScore(player.getReward_Score()+player.getBonus_Score());
            winning.winMess.setVisible(true);
            this.reset();
            playing = true;
        }

        //game falling mode:
        if((player.getdX() == enemy1.getdX() && player.getdY() == enemy1.getdY())
           ||(player.getdX() == enemy2.getdX() && player.getdY() == enemy2.getdY()) ){

            playing = false;
            Punishment.pFrame.setVisible(true);
            this.reset();
            playing = true;
        }
    }

    public int getLocation(int x, int y) {
        return wall.getLocation(x, y);
    }

    //Draw Scores
    private void drawScore(Graphics g) {
        g.setFont(miniFont);
        g.setColor(Color.WHITE);

        String rewardstr = "Reward:"; 
        String rewardscore = "" + player.getReward_Score();
        String bonusstr = "Bonus:";
        String bonusscore = "" + player.getBonus_Score();

        g.drawString(rewardstr, 510, 50 + 16);
        g.drawString(rewardscore, 510, 100 + 16);
        g.drawString(bonusstr, 510, 150 + 16);
        g.drawString(bonusscore, 510, 200 + 16);
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        wall.draw(g);
        drawScore(g);
        player.IsPrize();

        //Draw Bonus Object:
        for(int i = 0; i < prizefactory.noOfBonus(); i++){
            if(bonus[i].getStatus()){
                bonus[i].draw(g,BLOCK_SIZE);
            }
        }

        //Draw Reward Object:
        for(int i = 0; i < prizefactory.noOfReward(); i++){
            if(reward[i].getStatus()){
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