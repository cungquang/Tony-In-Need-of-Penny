package game;

import java.awt.*;

/**
 * Wall class: stores the location of the walls on the map
 * 
 * - int[][] maze: contains the map data.
 * 
 * methods:
 * + Wall():        instantiates basic properties of the map
 * + draw():        method for drawing the map and walls
 * + reset():       resets the map variables
 * + getMaze():     returns the int[][] array containing the map data
 * + getLocation(): returns the item at the given location
 */
public class Wall {
    private static int blockDimension;
    private static int numBlocks;
    private static final int SIZE = blockDimension * numBlocks;

    private int px; 
    private int py;
    private int width;
    private int height;

    private static int[][] maze = {
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,3,2,2,2,1,0,0,2,2,2,0,2,0,1,0,0,0,3,1},
        {1,2,1,1,2,0,0,1,1,0,1,1,1,0,1,0,1,1,1,1},
        {1,2,1,0,2,1,0,1,2,2,2,0,3,0,0,0,0,0,2,1},
        {1,2,1,0,1,1,0,1,0,1,1,1,0,1,1,1,0,1,0,1},
        {1,0,1,0,0,1,2,2,0,0,0,1,0,1,0,0,0,1,0,1},
        {1,0,1,1,0,0,0,1,1,1,0,1,0,0,2,1,1,1,0,1},
        {1,0,0,0,0,1,0,1,0,0,3,1,0,1,0,1,0,0,0,1},
        {1,1,1,0,1,1,0,0,0,1,0,1,0,1,2,2,0,1,0,1},
        {1,1,2,2,0,1,0,1,0,1,0,1,0,1,1,0,1,1,0,1},
        {1,2,2,1,0,0,0,1,0,1,0,1,0,0,1,0,1,0,0,1},
        {1,0,1,1,1,1,0,1,0,0,0,1,1,0,1,0,0,0,1,1},
        {1,0,1,0,0,0,0,1,0,1,0,2,2,0,0,0,1,0,0,1},
        {1,0,1,0,1,1,0,1,0,1,1,1,1,1,1,1,1,1,0,1},
        {1,2,0,0,2,2,0,1,0,1,0,0,0,0,0,0,0,0,3,1},
        {1,0,1,0,1,0,0,0,0,0,0,1,1,0,1,1,1,1,0,1},
        {1,2,1,0,1,1,1,1,0,1,1,1,1,0,1,1,0,0,0,1},
        {1,0,1,0,0,0,0,2,0,0,0,1,0,2,2,0,0,1,0,1},
        {1,2,1,1,1,0,1,1,1,1,0,0,0,1,0,1,1,1,0,1},
        {1,0,2,2,0,0,0,2,2,0,0,1,0,0,0,2,2,0,0,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}

    };

    /*-----------------------------------Reward & Bonus Object-----------------------------------*/


    public Wall(int mapWidth, int mapHeight, int blockSize, int numBlocks) {
        px = 0;
        py = 0;
        width = mapWidth;
        height = mapHeight;
        blockDimension = blockSize;
        numBlocks = numBlocks;
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

    public void reset(int door_X, int door_Y) {
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