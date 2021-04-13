package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {
    private Map m;
    private Character MC;

    @BeforeEach
    public void setUp() throws Exception
    {
        Map m = new Map();
        MC = Character.getInstance(m);
    }

    @Test
    @DisplayName("Player should get Reward Score when he meets a reward")
    void Test_getReward_Score() {
        MC.ResetPosition();
        MC.move('u');
        MC.move('u');
        MC.IsPrize();
        assertEquals(5,MC.getReward_Score());
    }

    @Test
    @DisplayName("Player should get Bonus Score when he meets a bonus")
    void Test_getBonus_Score() {
        MC.ResetPosition();
        for(int i=0;i<5;i++)
        {
            MC.move('u');
            MC.IsPrize();
        }
        System.out.println(MC.getdY());
        assertEquals(10,MC.getBonus_Score());
    }

    @Test
    void Test_resetPosition() {
        MC.ResetPosition();
        assertEquals(1,MC.getdX());
        assertEquals(6,MC.getdY());
    }


    @Test
    void Test_isPrize() {
        MC.ResetPosition();
        for(int i=0;i<5;i++)
        {
            MC.move('u');
            MC.IsPrize();
        }
        //should get 3 rewards, each is 5 points;
        assertEquals(15,MC.getReward_Score());
        //should get 1 bonus, each is 10 points;
        assertEquals(10,MC.getBonus_Score());
    }

    @Test
    @DisplayName("Player will move if it got direction order expect there is a wall")
    void Test_move() {
        MC.ResetPosition();
        int test_X =1, test_Y=6;
        //No wall collision
        //go up:
        MC.move('u');
        test_Y -= 1;
        assertEquals(test_Y,MC.getdY());
        //go down
        MC.move('d');
        test_Y += 1;
        assertEquals(test_Y,MC.getdY());

        //wall collision
        //go left (there is a wall at left)
        MC.move('l');
        assertEquals(test_X,MC.getdX());

        //go right (there is a wall at right)
        MC.move('d');
        assertEquals(test_X,MC.getdX());
    }
}




