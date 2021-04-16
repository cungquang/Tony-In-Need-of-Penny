package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import game.Wall;
import game.PrizeFactory;
import game.Prize;

public class PrizeFactoryTest {
    private int value_Test;
    private Wall wall = new Wall(BLOCK_SIZE);

    private PrizeType type1 = PrizeType.reward;     //type of prize - reward
    private PrizeType type2 = PrizeType.bonus;      //type of prize - bonus

    private Prize bonus_Test[];                     //array of bonus
    private Prize reward_Test[];                    //array of reward

    private PrizeFactory factory_Test;              //prize factory

    private final static int BLOCK_SIZE = 25;
    private final int PRIZEVALUE = 5;

    @BeforeEach
    public void setUp(){
        testCreate();
    }


    @Test
    public void testCreate(){
        //object factory to create
        factory_Test = new PrizeFactory(wall, PRIZEVALUE);

        //Create array of reward and bonus
        bonus_Test = factory_Test.getBonusArray();
        reward_Test = factory_Test.getRewardArray();
    }

    @Test 
    public void testPosition(){
        int valueOnMaze;

        //check the reward position:
        for(int i = 0; i < factory_Test.noOfReward(); i++){  
            valueOnMaze = wall.getLocation(reward_Test[i].getPosition()[0], reward_Test[i].getPosition()[1]);
            assertEquals(valueOnMaze, 2);
        }

        //check the bonus position:
        for(int i = 0; i < factory_Test.noOfBonus(); i++){  
            valueOnMaze = wall.getLocation(bonus_Test[i].getPosition()[0], bonus_Test[i].getPosition()[1]);
            assertEquals(valueOnMaze, 3);
        }
    }   

    @Test 
    public void testValues(){
        //check the reward position:
        for(int i = 0; i < factory_Test.noOfReward(); i++){  
            assertEquals(reward_Test[i].getValue(), PRIZEVALUE);
        }

        //check the bonus position:
        for(int i = 0; i < factory_Test.noOfBonus(); i++){  
            assertEquals(bonus_Test[i].getValue(), PRIZEVALUE*2);
        }
    }   

    @Test 
    public void testStatus(){
        //check the reward position:
        for(int i = 0; i < factory_Test.noOfReward(); i++){  
            assertEquals(reward_Test[i].getStatus(), true);
        }

        //check the bonus position:
        for(int i = 0; i < factory_Test.noOfBonus(); i++){  
            assertEquals(bonus_Test[i].getStatus(), true);
        }
    }   


}