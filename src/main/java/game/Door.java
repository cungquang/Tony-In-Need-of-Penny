package game;

import java.awt.*;

public class Door{
	int[][]  maze;
	int xCoord;
	int yCoord;

	public Door(Wall wall){
		this.maze = wall.getMaze();
		this.getPosition();
	}

	public void getPosition(){
		for(int i = 0; i < maze[0].length; i++) {
            for(int j = 0; j < maze.length; j++) {
                if(maze[j][i] == 9) {
                	xCoord = i;
                	yCoord = j;
                }
            }
        }
	}

	public void draw(Graphics g, int blockdimension){
        g.setColor(Color.CYAN);
        g.fillRect(xCoord * blockdimension, yCoord*blockdimension, blockdimension, blockdimension);
	}
}
