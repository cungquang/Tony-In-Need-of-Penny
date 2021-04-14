package game;

import java.awt.*;

/**
 * Wall class: stores the location of the walls on the map
 * 
 * - int blockDimension:    # of pixels for each block
 * - int[][] maze:          contains the map data.
 * 
 * methods:
 * + Wall():        instantiates basic properties of the map
 * + draw():        method for drawing the map and walls
 * + reset():       resets the map variables
 * + getMaze():     returns the int[][] array containing the map data
 * + getLocation(): returns the item at the given location
 */
public class Wall {
    private int blockDimension;

    private static int[][] maze = {
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,3,2,2,2,1,0,0,2,2,2,0,2,0,1,0,0,0,3,1},
        {1,2,1,1,2,0,0,1,1,0,1,1,1,0,1,0,1,1,1,1},
        {1,2,1,0,2,1,0,1,2,2,2,0,3,0,0,0,0,0,2,1},
        {1,2,1,0,1,1,0,1,0,1,1,1,0,1,1,1,0,1,0,1},
        {1,0,1,2,2,1,2,2,0,0,0,1,0,1,0,0,0,1,0,1},
        {1,0,1,1,2,0,0,1,1,1,0,1,0,0,2,1,1,1,0,1},
        {1,0,2,2,2,1,0,1,0,0,3,1,0,1,0,1,0,0,0,1},
        {1,1,1,2,1,1,0,0,0,1,0,1,0,1,2,2,0,1,0,1},
        {1,1,2,2,2,1,0,1,0,1,0,1,0,1,1,0,1,1,0,1},
        {1,2,2,1,2,2,0,1,0,1,0,1,0,0,1,0,1,0,0,1},
        {1,0,1,1,1,1,0,1,0,0,0,1,1,0,1,0,0,0,1,1},
        {1,0,1,0,0,0,0,1,0,1,0,2,2,0,0,0,1,0,0,1},
        {1,0,1,0,1,1,0,1,0,1,1,1,1,1,1,1,1,1,0,1},
        {1,2,0,0,2,2,0,1,0,1,0,0,0,0,0,0,0,0,3,1},
        {1,0,1,0,1,0,0,0,0,0,0,1,1,0,1,1,1,1,0,1},
        {1,2,1,0,1,1,1,1,0,1,1,1,1,0,1,1,0,0,0,1},
        {1,0,1,0,0,0,0,0,0,0,0,1,0,2,2,0,0,1,0,1},
        {1,2,1,1,1,0,1,1,1,1,0,0,0,1,0,1,1,1,0,1},
        {1,0,2,2,0,0,0,2,2,0,0,1,0,0,0,2,2,0,0,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}

    };

    /*-----------------------------------Reward & Bonus Object-----------------------------------*/


    public Wall(int blockSize) {
        this.blockDimension = blockSize;
    }

    public void draw(Graphics g) {
        for(int i = 0; i < maze[0].length; i++) {
            for(int j = 0; j < maze.length; j++) {
                if(maze[j][i] == 1) {
                    g.setColor(Color.BLACK);
                    g.fillRect(i * blockDimension,j * blockDimension,blockDimension,blockDimension);
                } else if(maze[j][i] == 0) {
                    g.setColor(Color.GRAY);
                    g.fillRect(i * blockDimension,j * blockDimension,blockDimension,blockDimension);
                } 
            }
        }
    }

    public void reset() {
        for (int i = 0; i < maze[0].length; i++) {
            for (int j = 0; j < maze.length; j++) {
                if (maze[j][i] == 5) {
                    maze[j][i] = 2;
                } else if (maze[j][i] == 6) {
                    maze[j][i] = 5;
                } else if(maze[j][i] == 7) {
                    maze[j][i] = 4;
                }
            }
        }
    }

    public static int[][] getMaze() {
        return maze;
    }

    public int getLocation(int x, int y) {
        return maze[y][x];
    }

    public void setLocation(int x, int y, int value){
        maze[y][x] = value;
    }
    
}