package game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.List;
import java.awt.*;
import javax.swing.ImageIcon;


/**
 * Create the enemy inherited from the active object
 * Move enemy: apply the autofindway to find the optimized way to get close to the player
 */
public class Enemy extends activeObj{
    private List<EnemyBlock> wayList;

    public Enemy(Map m, int x, int y){
        this.setdX(x);
        this.setdY(y);
    }

    public void draw(Graphics g){
        //g.setColor(Color.GREEN);
        //g.fillOval(this.getdX() * 25 + 8, this.getdY() * 25 + 8,11,11);
        Image imageIcon = new ImageIcon("src/main/java/game/virous.gif").getImage();
        g.drawImage(imageIcon, this.getdX()*25, this.getdY()*25, 25, 25, null);
    }

    public void moveEnemy(Character ch){
        int distanceX = ch.getdX();
        int distanceY = ch.getdY();
        int localX = this.getdX();
        int localY = this.getdY();
        if(Math.abs(distanceX - localX)+Math.abs(distanceY-localY) == 0){
            return;
        }

        if(Math.abs(distanceX - localX)+Math.abs(distanceY-localY) <= 5){
            
            AutoFindWay afw = new AutoFindWay();
            wayList = afw.getWayLine(distanceX, distanceY, localX, localY);
            
            EnemyBlock fk = wayList.get(wayList.size()-2);
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
