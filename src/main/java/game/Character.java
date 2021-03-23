package game;

import java.awt.event.KeyEvent;



class Character extends activeObj {
    //is MC alive
    private Character MC;
    private int General_Score;
    private int Bonus_Score;
    private boolean IsAlive = true;
//    private boolean Is_Wall = false;
    private boolean Is_General_Reward = false;
    private boolean Is_Bonus = false;

    //Is Collision
    public void MovingEnemy_Collision(Eneposition e) {
        if(e.getX() == MC.getdX() && e.getY() == MC.getdY())
        {
            IsAlive = false;
        }
    }


    public void Reward_Collision(Prize p)
    {
        int x = p.getPosition()[0];
        int y = p.getPosition()[1];
        if(x == MC.getdX() && y == MC.getdY())
            Is_General_Reward = true;
        else
            Is_General_Reward = false;
    }
    public void Bonus_Collision(Bonus b)
    {
        int x = b.getPosition()[0];
        int y = b.getPosition()[1];
        if(x == MC.getdX() && y == MC.getdY())
            Is_Bonus = true;
        else
            Is_Bonus = false;
    }

    public void KeyPressed(KeyEvent e, Map m) {
        int k = e.getKeyCode();
        if (k == KeyEvent.VK_LEFT)
        {
            // Wall collision detection
            if (m.getLocation(MC.getdX()-1, MC.getdY()) == "1")
                return;
            else {
                MC.setdX(-1);
            }
        }
        else if (k == KeyEvent.VK_RIGHT) {
            if (m.getLocation(MC.getdX()+1, MC.getdY()) == "1")
                return;
            else {
                MC.setdX(1);
            }
        }
        else if (k == KeyEvent.VK_DOWN) {
            if (m.getLocation(MC.getdX(), MC.getdY()-1) == "1")
                return;
            else {
                MC.setdY(-1);
            }
        }
        else if (k == KeyEvent.VK_UP) {
            if (m.getLocation(MC.getdX(), MC.getdY()+1) == "1")
                return;
            else {
                MC.setdY(1);
            }
        }
    }
}

