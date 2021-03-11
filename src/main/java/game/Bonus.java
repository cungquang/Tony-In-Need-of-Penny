
/**
*	Bonus class: this is the concrete product of Prize class
*	- Inheritted attribute from Prize:
*		+ int PrizeNbr;
*		+ int xCoordinate;
*		+ int yCoordinate;
*		+ int PrizeValue;
*		+ boolean Prizestatus;
*
*	- Inheritted methods from Prize:
*		+ getNbr():			return identity of the Prize object
*		+ getPosition():	return the current position of the Prize object
* 		+ getValue():		return the value of the Prize object
*		+ getStatus():		return the current status of the Prize object
*
*		+ setNbr():			set the identity number fo the Prize object
*		+ setPosition: 		set the position for the Prize object
*		+ setValue():		set the value for the Prize object
*		+ setStatus(): 		set the current status for the Prize object
*
*	- Bonus's attribute: 	
*		+ int bNbr 
*
*	- Bonus's method:
*		+ Bonus():				constructor which create the instance of Bonus
*		+ BonusNbr():			interface that return the identity of the Bonus object
*		+ BonusXCoordinate():	interface that return X coordinate of the Bonus object
*		+ BonusYCoordinate(): 	interface that return Y coordinate of the Bonus object
*		+ BonusValue():		interface that return the value of the Bonus object
*		+ BonusStatus(): 		interface that return the current status of the Bonus object
* 		+ BonusSetState():		interface that return the new status of the Bonus object
*/
package game;

import game.Prize;

public class Bonus extends Prize{
	private int bNbr = 3;

	/*
	Bonus():
	Pre-cond: requires nbr(identity number - integer), dx(coordinate x-axis - integer),
		dy(coordinate y-axis - integer), value(value of Bonus - integer), state(current state - boolean)
	Post-cond: return an instance of class Bonus
	*/

	Bonus(int dx, int dy, int value){
		this.setPosition(dx, dy);
		this.setValue(value);
		this.setStatus(1);
	}

	/*
	BonusNbr():
	Pre-cond: none
	Post-cond: return the identity of the Bonus object
	*/
	public int BonusNbr(){
		return this.bNbr;
	}

	/*
	BonusXCoordinate():
	Pre-cond: none
	Post-cond: return the current X coordinate of the Bonus object
	*/
	public int BonusXCoordinate(){
		return this.getPosition()[0];
	}

	/*
	BonusYCoordinate():
	Pre-cond: none
	Post-cond: return the current Y coordinate of the Bonus object
	*/
	public int BonusYCoordinate(){
		return this.getPosition()[1];
	}

	/*
	BonusValue():
	Pre-cond: none
	Post-cond: return the value of the Bonus object
	*/
	public int BonusValue(){
		return this.getValue();
	}

	/*
	BonusStatus():
	Pre-cond: none
	Post-cond: return the current status of the Bonus object
	*/
	public boolean BonusStatus(){
		return this.getStatus();
	}

	/*
	BonusSetState();
	Pre-cond: requires the new state of the Bonus object
	Post-cond: return the current status of the Bonus object
	*/
	public boolean BonusSetState(boolean state){
		this.setStatus(state);
		return this.getStatus();
	}

}	