package game;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

/**
 * Map class: creates and draws the map
 * 
 * - int[][] level: contains the map data.
 * 
 * methods:
 * + getLocation():     returns the object at the given location
 * + setLocation():     sets the object at the given location
 * + paintComponent():  swing method for drawing the components to the JPanel
 * - drawWals():        draws the walls of the map and the rewards
 */
public class Map extends JPanel {
    private int[][] level = {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                             {1,2,2,2,2,1,2,2,2,2,2,2,2,2,1,2,2,2,2,1},
                             {1,2,1,1,2,2,2,1,1,2,1,1,1,2,1,2,1,1,1,1},
                             {1,3,1,2,2,1,2,1,2,2,2,2,2,2,2,2,2,2,2,1},
                             {1,2,1,2,1,1,2,1,2,1,1,1,2,1,1,1,2,1,2,1},
                             {1,2,1,2,2,1,2,2,2,2,2,1,2,1,2,2,2,1,2,1},
                             {1,2,1,1,2,2,2,1,1,1,2,1,2,2,2,1,1,1,2,1},
                             {1,2,2,2,2,1,2,1,2,2,2,1,2,1,2,1,2,2,2,1},
                             {1,1,1,2,1,1,2,2,2,1,2,1,2,1,2,2,2,1,2,1},
                             {1,1,2,2,2,1,3,1,2,1,2,1,2,1,1,2,1,1,2,1},
                             {1,2,2,1,2,2,2,1,2,1,2,1,2,2,1,2,1,2,2,1},
                             {1,2,1,1,1,1,2,1,2,2,2,1,1,2,1,2,2,2,1,1},
                             {1,2,1,2,2,2,2,1,2,1,2,2,3,2,2,2,1,2,2,1},
                             {1,2,1,2,1,1,2,1,2,1,1,1,1,1,1,1,1,1,2,1},
                             {1,2,2,2,2,2,2,1,2,1,2,2,2,2,2,2,2,2,2,1},
                             {1,2,1,2,1,2,2,2,2,2,2,1,1,2,1,1,1,1,2,1},
                             {1,2,1,2,1,1,1,1,2,1,1,1,1,2,1,1,2,3,2,1},
                             {1,2,1,2,2,2,2,2,2,2,2,1,2,2,2,2,2,1,2,1},
                             {1,2,1,1,1,2,1,1,1,1,2,2,2,1,2,1,1,1,2,1},
                             {1,2,2,2,2,2,2,2,2,2,2,1,2,2,2,2,2,2,2,1},
                             {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};


    public Map() {

    }

    public int getLocation(int x, int y) {
        return level[y][x];
    }

    public void setLocation(int x, int y, int value) {
        level[y][x] = value;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.setBackground(Color.WHITE);

        drawWalls(g);
    }

    private void drawWalls(Graphics g) {

        for(int i = 0; i< level.length; i++) {
            for(int j = 0; j<level[i].length; j++) {
                if(level[i][j] == 1){
                    g.setColor(Color.BLACK);
                    g.fillRect(j*25, i*25, 25, 25);
                }
                if(level[i][j] == 0){
                    g.setColor(Color.lightGray);
                    g.fillRect(j*25, i*25, 25, 25);
                }
                if(level[i][j] == 2) {
                    g.setColor(Color.lightGray);
                    g.fillRect(j*25, i*25, 25, 25);
                    g.setColor(Color.YELLOW);
                    g.fillOval((j*25)+5, (i*25)+5, 15, 15);
                }
                if(level[i][j] == 3) {
                    g.setColor(Color.lightGray);
                    g.fillRect(j*25, i*25, 25, 25);
                    g.setColor(Color.DARK_GRAY);
                    g.fillPolygon(new int[] {((j*25)), ((j*25)+4), ((j*25)+8)}, new int[] {((i*25)+25), ((i*25)+15), ((i*25)+25)}, 3);
                    g.fillPolygon(new int[] {((j*25)+8), ((j*25)+12), ((j*25)+16)}, new int[] {((i*25)+25), ((i*25)+15), ((i*25)+25)}, 3);
                    g.fillPolygon(new int[] {((j*25)+16), ((j*25)+20), ((j*25)+24)}, new int[] {((i*25)+25), ((i*25)+15), ((i*25)+25)}, 3);
                }
            }
        }
    }
}