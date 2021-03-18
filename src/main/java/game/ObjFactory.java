/**
*	Factory for creating Prize object:
*		- allows to create either Reward or Bonus (Concrete product):
*			+ 2 - to create the Reward
*			+ 3 - to create the Bonus
*		- method - createPrize:
*/

package prize;

import prize.Prize;
import prize.Reward;
import prize.Bonus;
import prize.ObjType;

public class ObjFactory{

	/*------------------------Create Prize------------------------*/
	/*
	createPrize():
	Pre-cond: requires object type to identify the product need to produce
	Post-cond: return an object match the objec type
	*/
	Prize createPrize(ObjType objtype, int dx, int dy, int value){
		switch(objtype){
			case reward:
				return new Reward(dx, dy, value);
			case bonus:
				return new Bonus(dx, dy, value);
		}

		return null;
	}

	//Add another factory below - if needed
}