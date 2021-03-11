
/**
*	Reward class: this is the concrete product of Prize class
*	- Inheritted attribute from Prize:
*		+ int xCoordinate;
*		+ int yCoordinate;
*		+ int PrizeValue;
*		+ boolean Prizestatus;
*
*	- Inheritted methods from Prize:
*		+ getPosition():	return the current position of the Prize object
* 		+ getValue():		return the value of the Prize object
*		+ getStatus():		return the current status of the Prize object
*
*		+ setPosition: 		set the position for the Prize object
*		+ setValue():		set the value for the Prize object
*		+ setStatus(): 		set the current status for the Prize object
*	
*	- Reward's attribute: 	
*		+ int rNbr
*
*	- Reward's method:
*		+ Reward():				constructor which create the instance of Reward
*		+ rewardNbr():			interface that return the identity of the Reward object
*		+ rewardXCoordinate():	interface that return X coordinate of the Reward object
*		+ rewardYCoordinate(): 	interface that return Y coordinate of the Reward object
*		+ rewardValue():		interface that return the value of the Reward object
*		+ rewardStatus(): 		interface that return the current status of the Reward object
* 		+ rewardSetState():		interface that return the new status of the Reward object
*/
package prize;

import prize.Prize;

public class Reward extends Prize{
	private int rNbr = 2;

	/*-------------------------Constructor-------------------------*/
	/*
	Reward():
	Pre-cond: requires nbr(identity number - integer), dx(coordinate x-axis - integer),
		dy(coordinate y-axis - integer), value(value of reward - integer), state(current state - boolean)
	Post-cond: return an instance of class Reward
	*/

	Reward(int dx, int dy, int value){
		this.setPosition(dx, dy);
		this.setValue(value);
		this.setStatus(1);
	}

	/*-------------------------Getter function-------------------------*/
	/*
	rewardNbr():
	Pre-cond: none
	Post-cond: return the identity of the Reward object
	*/
	public int rewardNbr(){
		return this.rNbr;
	}

	/*
	rewardXCoordinate():
	Pre-cond: none
	Post-cond: return the current X coordinate of the Reward object
	*/
	public int rewardXCoordinate(){
		return this.getPosition()[0];
	}

	/*
	rewardYCoordinate():
	Pre-cond: none
	Post-cond: return the current Y coordinate of the Reward object
	*/
	public int rewardYCoordinate(){
		return this.getPosition()[1];
	}

	/*
	rewardValue():
	Pre-cond: none
	Post-cond: return the value of the Reward object
	*/
	public int rewardValue(){
		return this.getValue();
	}

	/*
	rewardStatus():
	Pre-cond: none
	Post-cond: return the current status of the Reward object
	*/
	public boolean rewardStatus(){
		return this.getStatus();
	}

	/*-------------------------Setter function-------------------------*/
	/*
	rewardSetState();
	Pre-cond: requires the new state of the Reward object
	Post-cond: return the current status of the Reward object
	*/
	public boolean rewardSetState(boolean state){
		this.setStatus(state);
		return this.getStatus();
	}

}	