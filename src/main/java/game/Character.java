package game;

import java.awt.event.KeyEvent;

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

class Character extends activeObj {
    private static Character MC = null;
    private int General_Score;
    private int Bonus_Score;
//    is MC alive
    private boolean IsAlive = true;
    private boolean Is_General_Reward = false;
    private boolean Is_Bonus = false;

    private Character ()
    {
        this.setdX(0);
        this.setdY(0);
        this.General_Score = 0;
        this.Bonus_Score = 0;
        this.IsAlive = true;
        this.Is_General_Reward = false;
        this.Is_Bonus = false;
    }
    public static Character getInstance()
    {
        if (MC ==  null) {
            MC == new Character();
        }
        return MC;

    }

    //Is Collision
    public void MovingEnemy_Collision(Eneposition e) {
        if(e.getX() == this.getdX() && e.getY() == this.getdY())
        {
            IsAlive = false;
        }
    }


    public void Reward_Collision(Prize p)
    {
        int x = p.getPosition()[0];
        int y = p.getPosition()[1];
        //Reward collision detection
        if(x == this.getdX() && y == this.getdY())
            Is_General_Reward = true;
        else
            Is_General_Reward = false;
    }
    public void Bonus_Collision(Bonus b)
    {
        int x = b.getPosition()[0];
        int y = b.getPosition()[1];
        // Bonus collision detection
        if(x == this.getdX() && y == this.getdY())
            Is_Bonus = true;
        else
            Is_Bonus = false;
    }

    public void KeyPressed(KeyEvent e, Map m) {
        int k = e.getKeyCode();
        if (k == KeyEvent.VK_LEFT)
        {
            // Wall collision detection
            if (m.getLocation(this.getdX()-1, this.getdY()) == 1)
                return;
            else {
                this.setdX(-1);
            }
        }
        else if (k == KeyEvent.VK_RIGHT) {
            if (m.getLocation(this.getdX()+1, this.getdY()) == 1)
                return;
            else {
                this.setdX(1);
            }
        }
        else if (k == KeyEvent.VK_DOWN) {
            if (m.getLocation(this.getdX(), this.getdY()-1) == 1)
                return;
            else {
                this.setdY(-1);
            }
        }
        else if (k == KeyEvent.VK_UP) {
            if (m.getLocation(this.getdX(), this.getdY()+1) == 1)
                return;
            else {
                this.setdY(1);
            }
        }
    }
}

