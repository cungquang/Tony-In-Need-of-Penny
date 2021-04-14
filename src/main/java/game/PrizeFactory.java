/**
*	Factory for creating Prize object:
*		- allows to create either Reward or Bonus (Concrete product):
*			+ 2 - to create the Reward
*			+ 3 - to create the Bonus
*		- method - createPrize:
*/

package game;

public class PrizeFactory{
    private PrizeType bonustype;                         //Enum type [Bonus]
    private PrizeType rewardtype;                        //Enum type [Reward]              
    private int PRIZE_VALUE;                             //Base value of prize object
    private int Num_Bonus;                               //Count number of [Bonus] object
    private int Num_Reward;                              //Count number of [Reward] object
 	private int[][] maze;

	/*-----------------------------------Constructor Prize-----------------------------------*/
	/*
	PrizeFactory()
	Pre-cond: none
	Post-cond: return the object type PrizeFactory
	*/
	public PrizeFactory(Wall m, int prizevalue){
		this.maze = m.getMaze();
		this.bonustype = PrizeType.bonus;
		this.rewardtype = PrizeType.reward;
		this.PRIZE_VALUE = prizevalue;
		this.countPrize();
	}

	/*
	createPrize():
	Pre-cond: requires object type to identify the product need to produce
	Post-cond: return an object match the objec type
	*/
	Prize createPrize(PrizeType prizetype, int dx, int dy, int value){
		switch(prizetype){
			case reward:
				return new Reward(dx, dy, value);
			case bonus:
				return new Bonus(dx, dy, value);
		}

		return null;
	}



    /*-----------------------------------Reward & Bonus Object-----------------------------------*/
    /*
    countPrize()
    pre-cond: none
    post-cond: count number of [Bonus] and [Reward] on the maze
    */
    private void countPrize(){

        for(int i = 0; i < maze.length; i++) {
            for(int j = 0; j < maze[0].length; j++) {
                //Count Number of Bonus
                if(maze[i][j] == 3){
                    Num_Bonus++;
                }

                //Count Number of Reward
                if(maze[i][j] == 2){
                    Num_Reward++;
                }
            }
        }
    }

    /*
    noOfBonus():
    Pre-cond: none
    Post-cond: return number of [Bonus] object
    */
    public int noOfBonus(){
        return this.Num_Bonus;
    }

    /*
    noOfBonus():
    Pre-cond: none
    Post-cond: return number of [Bonus] object
    */
    public int noOfReward(){
        return this.Num_Reward;
    }


	/*
    getBonusArray()
    Pre-cond: none
    Post-cond: return an array of Bonus object
    */
    public Prize[] getBonusArray(){
        Prize[] bonusArr = new Prize[this.Num_Bonus];
        int BIndex = 0;

        for(int i = 0; i < maze[0].length; i++) {
            for(int j = 0; j < maze.length; j++) {
                if(maze[j][i] == 3) {
                    bonusArr[BIndex] = createPrize(bonustype, i, j, PRIZE_VALUE);
                    BIndex++;
                }
            }
        }

        return bonusArr;
    }


    /*
    getRewardArray()
    Pre-cond: none
    Post-cond: return an array of Reward object
    */
    public Prize[] getRewardArray(){
        Prize[] rewardArr = new Prize[this.Num_Reward];
        int RIndex = 0;

        for(int i = 0; i < maze[0].length; i++) {
            for(int j = 0; j < maze.length; j++) {
                if(maze[j][i] == 2) {
                    rewardArr[RIndex] = createPrize(rewardtype, i, j, PRIZE_VALUE);
                    RIndex++;
                }
            }
        }

        return rewardArr;
    }

}