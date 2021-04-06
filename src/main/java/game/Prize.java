
/**
*	Abstract class: 
*	- int Nbr
*	- int xCoordinate: 		the coordination of a Prize on x-axis
*	- int yCoordinate: 		the coordination of a Prize on y-axis
*	- int PrizeValue:	 	value of the Prize
*	- boolean status: 		the current status the Prize - True is still exist, Flase otherwise
*	
*	method:
*	+ getNbr(): 		return the identity number of Prize object
*	+ getPosition():	return the current position of the Prize object
* 	+ getValue():		return the value of the Prize object
*	+ getStatus():		return the current status of the Prize object
*	
*	- setNbr():			set the identity number of the Prize object
*	- setPosition: 		set the position for the Prize object
*	- setValue():		set the value for the Prize object
*	- setStatus(): 		set the current status for the Prize object
*
*/

package game;

import java.awt.*;

public abstract class Prize{
	private int Nbr;
	private int xCoordinate;
	private int yCoordinate;
	private int PrizeValue;
	private boolean PrizeStatus;

	/*-------------------------Getter function-------------------------*/
	/*
	draw():
	Pre-cond: graphic
	Post-cond: return the prize on the map
	*/
    public void draw(Graphics g, int blockdimension){}

	/*
	getNbr():
	Pre-cond: none
	Post-cond: return the identity of the Prize object
	*/
	public int getNbr(){
		return this.Nbr;
	}

	/*
	getPosition():
	Pre-cond: none
	Post-cond: return the current X coordinate of the Prize object
	*/
	public int[] getPosition(){
		int[] position = new int[2];
		position[0] = this.xCoordinate;
		position[1] = this.yCoordinate;
		return position;
	}

	/*
	getValue():
	Pre-cond: none
	Post-cond: return the value of the Prize object
	*/
	public int getValue(){
		return this.PrizeValue;
	}

	/*
	getStatus():
	Pre-cond: none
	Post-cond: return the current status of the Prize object
	*/
	public boolean getStatus(){
		return this.PrizeStatus;
	}
	
	/*-------------------------Setter function-------------------------*/
	/*
	setNbr():
	Pre-cond: require idenity Nbr
	Post-cond: return the true if success, false otherwise
	*/
	protected boolean setNbr(int nBr){
		this.Nbr = nBr;
		if(this.Nbr != nBr){
			return false;
		}
		return true;
	}

	/*
	setPosition:
	Pre-cond: requires a pair of cooridnate x and y
	Post-cond: update the coordinate of the Prize object
		return true if success, false otherwise
	*/
	protected boolean setPosition(int x, int y){
		this.xCoordinate = x;
		this.yCoordinate = y;
		if(this.xCoordinate != x || this.yCoordinate != y){
			return false;
		}
		return true;
	}

	/*
	setValue
	Pre-cond: requires the value
	Post-cond: update the value of the Prize
		return true if success, false otherwise
	*/
	protected boolean setValue(int value){
		this.PrizeValue = value;
		if(this.PrizeValue != value){
			return false;
		}
		return true;
	}

	/*
	setStatus:
	Pre-cond: requires the updated status
	Post-cond: update the current status of the Prize object
		return true if success, false otherwise
	*/
	protected boolean setStatus(boolean updateStatus){
		this.PrizeStatus = updateStatus;
		if(this.PrizeStatus != updateStatus){
			return false;
		}
		return true;
	}

}


