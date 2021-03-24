package game.enemy_test;

import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;


/**
 * Mycoins
 */
public class Mycoins extends JPanel{
    public int i;
    public int j;
    public void paint(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.lightGray);
        g.fillRect(j*25, i*25, 25, 25);
        g.setColor(Color.YELLOW);
        g.fillOval((j*25)+5, (i*25)+5, 15, 15);
    }
    
}
