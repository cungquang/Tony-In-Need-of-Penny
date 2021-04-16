package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import game.PrizeFactory;
import game.Prize;

class PrizeFactoryTest {
    private int value_Test;
    private Wall wall_Test;

    private PrizeType type1 = PrizeType.reward;
    private PrizeType type2 = PrizeType.bonus;

    private Prize bonus_Test[];
    private Prize reward_Test[];

    private PrizeFactory factory_Test;


    @BeforeEach
    public void setUp(Wall wall, int value){
        factory_Test = new PrizeFactory(wall,value);
    }

    @Test
    void runTest(){
        //object factory to create
        factory_Test = new PrizeFactory(this.wall_Test, this.value_Test);

        //Create array of reward and bonus
        reward_Test = factory_Test.getBonusArray();
        bonus_Test = factory_Test.getRewardArray();

        //Reward array:
        System.out.println("-----------------------------------------------------");
        System.out.println("List of Reward:");
        for(int i = 0; i < factory_Test.noOfBonus(); i++){
            System.out.println("Identity No: " + reward_Test.getNbr());
            System.out.println("x-coordinate: " + reward_Test.getPosition()[0]);
            System.out.println("y-coordinate: " + reward_Test.getPosition()[1]);
            System.out.println("Value of Reward: " + reward_Test.getValue());
            System.out.println("Status of Reward: " + reward_Test.getStatus());
            System.out.println("-----------------------------------------------------");
        }

        //Bonus array:
        System.out.println("-----------------------------------------------------");
        System.out.println("List of Bonus:");
        for(int i = 0; i < factory_Test.noOfReward(); i++){
            System.out.println("Identity No: " + reward_Test.getNbr());
            System.out.println("x-coordinate: " + reward_Test.getPosition()[0]);
            System.out.println("y-coordinate: " + reward_Test.getPosition()[1]);
            System.out.println("Value of Reward: " + reward_Test.getValue());
            System.out.println("Status of Reward: " + reward_Test.getStatus());
            System.out.println("-----------------------------------------------------");
        }
    }


}