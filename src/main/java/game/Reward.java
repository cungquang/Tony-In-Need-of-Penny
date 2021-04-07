/**
*	Reward class: this is the concrete product of Prize class
*	- Inheritted attribute from Prize:
*		- int Nbr;
*		- int xCoordinate;
*		- int yCoordinate;
*		- int PrizeValue;
*		- boolean Prizestatus;
*
*	- Inheritted methods from Prize:
*		+ getNbr(): 		return the identity number of Prize object
*		+ getPosition():	return the current position of the Prize object
* 		+ getValue():		return the value of the Prize object
*		+ getStatus():		return the current status of the Prize object
*
*		- setNbr():			set the identity number of the Prize object
*		- setPosition: 		set the position for the Prize object
*		- setValue():		set the value for the Prize object
*		- setStatus(): 		set the current status for the Prize object
*/
package game;

import java.awt.*;

public class Reward extends game.Prize{

	/*-------------------------Constructor-------------------------*/
	/*
	Reward():
	Pre-cond: requires nbr(identity number - integer), dx(coordinate x-axis - integer),
		dy(coordinate y-axis - integer), value(value of reward - integer), state(current state - boolean)
	Post-cond: return an instance of class Reward
	*/
	Reward(int dx, int dy, int value){
		this.setNbr(2);
		this.setPosition(dx, dy);
		this.setValue(value);
		this.setStatus(true);
	}


	/*
	draw():
	Pre-cond: graphic
	Post-cond: return the prize on the map
	*/
    public void draw(Graphics g, int blockdimension) {
    	if (this.getStatus()) {
			g.setColor(Color.BLUE);
			g.fillOval(this.getPosition()[0] * blockdimension + 12, this.getPosition()[1] * blockdimension + 12, 5, 5);
		}
    }

	/*-------------------------Setter function-------------------------*/
	/*
	rewardState();
	Pre-cond: requires the new state of the Reward object
	Post-cond: return the current status of the Reward object
	*/
	public boolean rewardState(boolean state){
		this.setStatus(state);
		return this.getStatus();
	}

}	