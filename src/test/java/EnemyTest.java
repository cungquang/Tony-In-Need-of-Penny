import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;

import game.*;
import game.Character;

import java.lang.Math;

public class EnemyTest {
    @Test
    @DisplayName("Enemy should autofind the path,accroding to the map ,the length of the path from the left-up corner to the right-bottom corner should be the manhhaten distance be thess points")
    public void AutofindwayTest(){
        int right_distance = (Math.abs(18-1)+Math.abs(19-1));
        assertEquals(right_distance, applyAutofindway(18, 19, 1, 1));
    } 
    private int applyAutofindway(int distX, int distY, int localX, int localY) {
        AutoFindWay AFW = new AutoFindWay();
        List<EnemyBlock> path = new ArrayList<>();

        path = AFW.getWayLine(distX, distY, localX, localY);
        return (path.size() - 1);//the distance include the one more end point because of the algorithm's checking;
        
    }
    

    @Test
    @DisplayName("Test if enemy can follow the path move correctly")
    public void testEnemyCatching(){
        Map m = new Map();
        Character ch = Character.getInstance(m);
        ch.ReSetX(1);
        ch.ReSetY(6);
        Enemy ene = new Enemy(m, 1, 1);
        System.out.println(" distance form the enemy can charater is 5, it need 5 steps to got to the character");
        for(int i = 0;i<5;i++){
            ene.move_Enemy(ch);
            System.out.println(ch.getdX()+"+"+ch.getdY()+"+"+ene.getdX()+"+"+ene.getdY());
        }
        assertEquals(ch.getdX(), ene.getdX());
        assertEquals(ch.getdY(), ene.getdY());
    
    }
}
