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
package prize;

import prize.Prize;

public class Bonus extends prize.Prize{

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