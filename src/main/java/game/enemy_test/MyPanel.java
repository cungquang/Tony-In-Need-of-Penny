package game.enemy_test;

import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;

public class MyPanel extends JPanel{
    /**
     *
     */
    public int x;
    public int y;
    private static final long serialVersionUID = 1L;
    public final static int size = 25;

    public MyPanel(int x, int y){
		this.setBounds(x * size, y * size, size, size);
    }
    
    public MyPanel(Eneposition fk){
      this.setBounds(fk.getX() * size, fk.getY() * size, size, size);
      x = fk.getX();
      y = fk.getY();
      Graphics g = getGraphics();
      int j = x;
      int i = y;
      if(g != null){
          paint(g);
          System.out.print("hguidhfvudisapfhueoa;pniou;ehfaefonbio;danv uioa;tjieopa;vn4");
          g.setColor(Color.lightGray);
          g.fillRect(j*25, i*25, 25, 25);
          g.setColor(Color.YELLOW);
          g.fillOval((j*25)+5, (i*25)+5, 15, 15);
      }
      
    }

}
