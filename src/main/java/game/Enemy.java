package game;
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import game.enemy_test.AutiFindWay;
import game.enemy_test.Eneposition;
import game.enemy_test.punishment;



/**
 * Create the enemy inherited from the active object
 * Move enemy: apply the autofindway to find the optimized way to get close to the player
 */
public class Enemy extends activeObj{
    private List<Eneposition> wayList;

    public Enemy(Map m, int x, int y){
        this.setdX(x);
        this.setdY(y);
    }

    public void draw(Graphics g){
        g.setColor(Color.GREEN);
        g.fillOval(this.getdX() * 25 + 8, this.getdY() * 25 + 8,11,11);
    }

    public void move_enemy(Character ch){
        int distanceX = ch.getdX();
        int distanceY = ch.getdY();
        int localX = this.getdX();
        int localY = this.getdY();
        if(Math.abs(distanceX - localX)+Math.abs(distanceY-localY) <= 5){
            
            AutiFindWay afw = new AutiFindWay();
            wayList = afw.getWayLine(distanceX, distanceY, localX, localY);
            
            Eneposition fk = wayList.get(wayList.size()-2);
            //System.out.println(distanceX+"+"+distanceY+"+"+localX+"+"+localY);
			// up
			if (this.getdY() > fk.getY()) {
                this.setdY(-1);
			}

			// down
			if (this.getdY() < fk.getY()) {
				this.setdY(1);
			}

			// left
			if (this.getdX() > fk.getX()) {
				this.setdX(-1);
			}

			// right
			if (this.getdX() < fk.getX()) {
				this.setdX(1);
            }

        }

    }


}
