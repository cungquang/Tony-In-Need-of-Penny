package game;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class Map extends JPanel {
    String[][] level = {{"*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*"},
                        {"*","","","","","","","","","","","","","*","","","","","","s"},
                        {"*","","","","","","","","","","","","","*","","*","*","*","*","*"},
                        {"*","","","","","","","","","","","","","*","","*","","","","*"},
                        {"*","","","","","","","","","","","","","","","*","*","*","","*"},
                        {"*","","","","","","","","","","","","","","","","","","","*"},
                        {"*","","","","","","","","","","","","","","*","*","*","*","","*"},
                        {"*","","","","","","","","","","","","","","","","","*","","*"},
                        {"s","","","","","","","","","","","","","","","","","","","*"},
                        {"*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*"}};


    public Map() {

    }

    public String getLocation(int x, int y) {
        return level[y][x];
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.setBackground(Color.WHITE);

        g.setColor(Color.BLUE);
        g.fillRect(0, 0, 500, 500);
        drawWalls(g);
    }

    private void drawWalls(Graphics g) {

        for(int i = 0; i< level.length; i++) {
            for(int j = 0; j<level[i].length; j++) {
                if(level[i][j] == "*"){
                    g.setColor(Color.BLACK);
                    g.fillRect(j*25, i*25, 25, 25);
                }
                if(level[i][j] == "s"){
                    g.setColor(Color.RED);
                    g.fillRect(j*25, i*25, +25, +25);
                }
            }
        }
    }
}