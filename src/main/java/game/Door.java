/**
*	Class Door: 
*	- int xCoord:		the coordination of the Door on x-axis	
*	- int yCoord: 		the coordination of the Door on y-axis
*	- int DoorVal:		value represents the Door on maze - 9
*	
*	method:
*	+ Door():			Constructor for Door class 		
*	+ getX:				return the x coordinate of the Door
* 	+ getY():			return the y coordinate of the Door
*	+ draw():			draw the Door on the map
*
*/

package game;

import java.awt.*;

public class Door{
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

	public void resetDoor(Wall map){
		map.setLocation(xCoord, yCoord, 0);
	}
}
