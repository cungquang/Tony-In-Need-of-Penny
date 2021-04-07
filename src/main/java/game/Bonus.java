/**
*	Bonus class: this is the concrete product of Prize class
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

public class Bonus extends game.Prize{

	/*-------------------------Constructor-------------------------*/
	/*
	Bonus():
	Pre-cond: requires nbr(identity number - integer), dx(coordinate x-axis - integer),
		dy(coordinate y-axis - integer), value(value of Bonus - integer), state(current state - boolean)
	Post-cond: return an instance of class Bonus
	*/
	Bonus(int dx, int dy, int value){
		this.setNbr(3);
		this.setPosition(dx, dy);
		this.setValue(value*2);
		this.setStatus(true);
	}

	/*
	draw():
	Pre-cond: graphic
	Post-cond: return the prize on the map
	*/
    public void draw(Graphics g, int blockdimension) {
		if (this.getStatus()) {
			g.setColor(Color.YELLOW);
			g.fillOval(this.getPosition()[0] * blockdimension + 8, this.getPosition()[1] * blockdimension + 8, 11, 11);
		}
    }


	/*-------------------------Setter function-------------------------*/
	/*
	bonusState();
	Pre-cond: requires the new state of the Bonus object
	Post-cond: return the current status of the Bonus object
	*/
	public boolean bonusState(boolean state){
		this.setStatus(state);
		return this.getStatus();
	}

}	