package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import game.*;

public class CharacterTest {
    @Test
    public void testGetBonusScore() {
        Map m = new Map();
        m.reset();
        Character MC = Character.getInstance(m);
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
    public void testResetPosition() {
        Map m = new Map();
        m.reset();
        Character MC = Character.getInstance(m);
        MC.ResetPosition();
        assertEquals(1,MC.getdX());
        assertEquals(6,MC.getdY());
    }




    @Test
    @DisplayName("Player will move if it got direction order expect there is a wall")
    public void testMove() {
        Map m = new Map();
        m.reset();
        Character MC = Character.getInstance(m);
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
        //test_X will not change 
        MC.move('l');
        assertEquals(test_X,MC.getdX());

        //go right (there is a wall at right)
        //test_X will not change
        MC.move('r');
        assertEquals(test_X,MC.getdX());
    }
}




