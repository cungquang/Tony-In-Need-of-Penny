
/**
*	Abstract class: 
*	- PrizeNbr (integer): 		identity number for each Prize 
*		+ normPrize - start with 10_
*		+ Bonus - start with 11_
*	- xCoordinate (integer): 	the coordination of a Prize on x-axis
*	- yCoordinate (integer): 	the coordination of a Prize on y-axis
*	- PrizeValue (int):	 		value of the Prize
*	- PrizeShape (char): 		the shape of Prize in form of character - will be displayed on screen
*	- status (boolean): 		use to check status of the Prize - 1 is still exist, 0 otherwise
*	
*	method:
*	- getNbr():			return identity of the Prize object
*	- getPosition():	return the current position of the Prize object
* 	- getValue():		return the value of the Prize object
*	- getStatus():		return the current status of the Prize object
*	
*	- setNbr():			set the identity number fo the Prize object
*	- setPosition: 		set the position for the Prize object
*	- setValue():		set the value for the Prize object
*	- setStatus(): 		set the current status for the Prize object
*
*	- display(hidden):	show all attributes of the Prize object on screen
*/

package src.main.java.game;

public abstract class Prize{
	private int PrizeNbr;
	private int xCoordinate;
	private int yCoordinate;
	private int PrizeValue;
	private boolean Prizestatus;

	/*-------------------------Getter function-------------------------*/
	/*
	getNbr:
	Pre-cond: none
	Post-cond: return the identity number of Prize object
	*/
	protected int getNbr(){
		return this.PrizeNbr;
	}

	/*
	getPosition:
	Pre-cond: none
	Post-cond: return current position of Prize object
	*/
	protected int[] getPosition(){
		int[] position = new int[2];
		position[0] = xCoordinate;
		position[1] = yCoordinate;
		return position;
	}

	/*
	getValue:
	Pre-cond: none
	Post-cond: return the value of the Prize object
	*/
	protected int getValue(){
		return this.PrizeValue;
	}

	/*
	getStatus:
	Pre-cond: none
	Post-cond: return the current status of Prize object
	*/
	protected boolean getStatus(){
		return this.Prizestatus;
	}
	
	/*-------------------------Setter function-------------------------*/
	/*
	setNbr:
	Pre-cond: requires the identity number for Prize object
	Post-cond: update the identity number of the Prize object 
		return true if success, false otherwise
	*/
	protected boolean setNbr(int pNbr){
		this.PrizeNbr = pNbr;
		if(this.PrizeNbr != pNbr){
			return false;
		}
		return true;
	}

	/*
	setPosition:
	Pre-cond: requires a pair of cooridnate x and y
	Post-cond: update the coordinate of the Prize object
		return true if success false otherwise
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
		this.Prizestatus = updateStatus;
		if(this.Prizestatus != updateStatus){
			return false;
		}
		return true;
	}

	// /*
	// Display function:
	// Pre-cond: none
	// Post-cond: print the information of Prize object into stdout
	// */
	// public void display(){
	// 	String temp = "Nbr: " + this.PrizeNbr + "\n";
	// 	temp += "x-" + this.xCoordinate + "\n";
	// 	temp += "y-" + this.yCoordinate + "\n";
	// 	temp += "prize-" + this.PrizeValue + "\n";
	// 	temp += "shape-" + this.PrizeShape + "\n";
	// 	temp += "status-" + this.status + "\n";
	// 	System.out.println(temp);
	// }
}


