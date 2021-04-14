package game;

import java.awt.*;

import javax.swing.ImageIcon;

import game.Map;
import game.Wall;

/**
 * Character Class: create the Main Character
 *  -Inheritted attribute from activeObj
 *
 *
 *     -private static Character MC = null; Singleton pattern   :
 *     -private int General_Score;                              :show the General Score
 *     -private int Bonus_Score;                                :show the bonus Socre
 *     -private boolean Is_General_Reward = false;              :judge the Collision of the General Reward
 *     -private boolean Is_Bonus = false;                       :judge the Collision of the Bonus Reward
 *     -private boolean IsAlive = true;                         :Is Main Character alive
 *
 *      method:
 *      -public static Character getInstance()                  :make sure there is only one instance of Main Character
 *      -public void MovingEnemy_Collision(Eneposition e)       :detect the Collision of the enemy
 *      -public void Reward_Collision(Prize p)                  :detect the Collision of the General Reward
 *      -public void Bonus_Collision(Bonus b)                   :detect the Collision of the Bonus Reward
 *      public void KeyPressed(KeyEvent e, Map m)               :Control Main Character with keyboard
 *
 *
 */

public class Character extends activeObj {
    private static Character MC = null;
    private int Reward_Score;
    private int Bonus_Score;
    //is MC alive
    private boolean IsAlive = true;

    private Map m = null;

    private Character (Map m)
    {
        this.setdX(1);
        this.setdY(6);
        this.Reward_Score = 0;
        this.Bonus_Score = 0;
        this.IsAlive = true;

        this.m = m;
    }

    public static Character getInstance(Map m)
    {
        if (MC ==  null) {
            MC = new Character(m);
        }

        return MC;
    }

    public int getReward_Score(){
        return this.Reward_Score;
    }

    public int getBonus_Score(){
        return this.Bonus_Score;
    }

    public void ResetPosition()
    {
        MC.resetX(1);
        MC.resetY(6);
        MC.Reward_Score = 0;
        MC.Bonus_Score = 0;
        MC.IsAlive = true;
    }

    public void draw(Graphics g) {
        //g.setColor(Color.red);
        //g.fillOval(this.getdX() * 25 + 8, this.getdY() * 25 + 8,11,11);
        Image imageIcon = new ImageIcon("src/main/java/game/Character.gif").getImage();
        g.drawImage(imageIcon, this.getdX()*25, this.getdY()*25, 25, 25, null);
    }

    //Bonus and Prize Checking method
    public void IsPrize()
    {
        for(int i = 0; i < m.reward.length; i++) {
            if (m.reward[i].getPosition()[0]  == MC.getdX() && m.reward[i].getPosition()[1] == MC.getdY() &&m.reward[i].getStatus())
            {
                Reward_Score += m.reward[i].getValue();
                m.reward[i].setStatus(false);
            }
        }
        for (int i = 0; i < m.bonus.length; i++)
        {
            if (m.bonus[i].getPosition()[0]  == MC.getdX() && m.bonus[i].getPosition()[1] == MC.getdY() &&m.bonus[i].getStatus())
            {
                Bonus_Score += m.bonus[i].getValue();
                m.bonus[i].setStatus(false);
            }
        }
    }

    public int move(char dir) {
        if(dir == 'l') {
            if (m.getLocation(this.getdX()-1, this.getdY()) == 1)
                return 1;
            else {
                this.setdX(-1);
            }
        } else if(dir == 'r') {
            if (m.getLocation(this.getdX()+1, this.getdY()) == 1)
                return 1;
            else {
                this.setdX(1);
            }
        } else if(dir == 'u') {
            if (m.getLocation(this.getdX(), this.getdY()-1) == 1)
                return 1;
            else {
                this.setdY(-1);
            }
        } else if(dir == 'd') {
            if (m.getLocation(this.getdX(), this.getdY()+1) == 1)
                return 1;
            else {
                this.setdY(1);
            }
        }
        return 0;
    }
}

