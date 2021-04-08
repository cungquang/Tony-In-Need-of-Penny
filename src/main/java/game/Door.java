package game;

import java.awt.*;

public class Door{
	int[][]  maze;
	int xCoord;
	int yCoord;
	int DoorVal;

	public Door(Wall wall, int x, int y){
		this.xCoord = x;
		this.yCoord = y;
		this.DoorVal = 9;
	}

	public int getX(){
		return xCoord;
	}

	public int getY(){
		return yCoord;
	}

	public void draw(Graphics g, int blockdimension, Wall wall){
		wall.setLocation(this.xCoord, this.yCoord, this.DoorVal);
        g.setColor(Color.CYAN);
        g.fillRect(xCoord * blockdimension, yCoord*blockdimension, blockdimension, blockdimension);
	}
}
