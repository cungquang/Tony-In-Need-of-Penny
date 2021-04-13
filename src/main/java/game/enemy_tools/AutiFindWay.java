package game.enemy_tools;

import java.util.ArrayList;
import java.util.List;

import java.lang.*;

import game.*;
import game.enemy_tools.Eneposition;
/**
 * zhangailist : The walls in enemy's minds; so that enemy can find the way:
 * Eneposition : Enemy's way to record the message of the path and the wall
 * closedlist : The path the enemy has walked or calculated
 * Openlist : list list of queue wait to be calcualted
 */
public class AutiFindWay {
    public static Eneposition beginEne = null;
    public static Eneposition endEne = null;
    public List<Eneposition> zhangaiList = new ArrayList<>();
    public List<Eneposition> closedList = new ArrayList<>();
    public List<Eneposition> openList = new ArrayList<>();

    private static int[][] maze = {
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,3,2,2,2,1,0,0,2,2,2,0,2,0,1,0,0,0,3,1},
        {1,2,1,1,2,0,0,1,1,0,1,1,1,0,1,0,1,1,1,1},
        {1,2,1,0,2,1,0,1,2,2,2,0,3,0,0,0,0,0,2,1},
        {1,2,1,0,1,1,0,1,0,1,1,1,0,1,1,1,0,1,0,1},
        {1,0,1,0,0,1,2,2,0,0,0,1,0,1,0,0,0,1,0,1},
        {1,0,1,1,0,0,0,1,1,1,0,1,0,0,2,1,1,1,0,1},
        {1,0,0,0,0,1,0,1,0,0,3,1,0,1,0,1,0,0,0,1},
        {1,1,1,0,1,1,0,0,0,1,0,1,0,1,2,2,0,1,0,1},
        {1,1,2,2,0,1,0,1,0,1,0,1,0,1,1,0,1,1,0,1},
        {1,2,2,1,0,0,0,1,0,1,0,1,0,0,1,0,1,0,0,1},
        {1,0,1,1,1,1,0,1,0,0,0,1,1,0,1,0,0,0,1,1},
        {1,0,1,0,0,0,0,1,0,1,0,2,2,0,0,0,1,0,0,1},
        {1,0,1,0,1,1,0,1,0,1,1,1,1,1,1,1,1,1,0,1},
        {1,2,0,0,2,2,0,1,0,1,0,0,0,0,0,0,0,0,3,1},
        {1,0,1,0,1,0,0,0,0,0,0,1,1,0,1,1,1,1,0,1},
        {1,2,1,0,1,1,1,1,0,1,1,1,1,0,1,1,0,0,0,1},
        {1,0,1,0,0,0,0,2,0,0,0,1,0,2,2,0,0,1,0,1},
        {1,2,1,1,1,0,1,1,1,1,0,0,0,1,0,1,1,1,0,1},
        {1,0,2,2,0,0,0,2,2,0,0,1,0,0,0,2,2,0,0,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}

    };

    public AutiFindWay(){
        
        //read the information of the map;
		for (int i = 0; i < 21; i++) {
			for (int j = 0; j < 20; j++) {
				if (maze[i][j]== 1) {
					int y = i;
					int x = j;
                    Eneposition wall = new Eneposition(x, y);
					zhangaiList.add(wall);
				} 
			}
		}
    }
    //this is the main part of find the way
    /** 
     * waitlist: the path of optimized the path to get the target
    */
    public List<Eneposition> getWayLine(int distX, int distY, int localX, int localY) {
        List<Eneposition> waitList = new ArrayList<>();
        List<Eneposition> tempList = null;
        beginEne = new Eneposition(localX,localY);
        beginEne.setG(0);
        endEne = new Eneposition(distX, distY);

        tempList = around(beginEne);
        if (tempList == null || tempList.size() == 0) {
            return waitList;
        }

        openList.addAll(tempList);
        //calculate the F G and  H in astar in the open list
        for (int i = 0; i < openList.size(); i++) {

            Eneposition temp = openList.get(i);
            tempList = around(temp);
            if (tempList == null || tempList.size() == 0) {
                continue;
            }
            if (tempList.contains(endEne)) {
                for (Eneposition obj : tempList) {
                    if (obj.equals(endEne)) {
                        closedList.add(obj);
                        break;
                    }
                }
                break;

            }
            for (Eneposition fk : tempList) {
                if (openList.contains(fk)) {


                    for (Eneposition openFk : openList) {
                        if (openFk.equals(fk)) {
                            if (openFk.getG() > fk.getG()) {
                                openFk.setG(fk.getG());
                                openFk.setF(openFk.getG() + openFk.getH());
                                openFk.setPreviousFK(fk.getPreviousFK());

                                System.out.println("The X is:" + openFk.getX() + "The y is" + openFk.getY()
                                        + "The F is " + openFk.getF());
                                break;
                            }
                        }
                    }
                } else {
                    openList.add(fk);
                }
            }
        
            openList.remove(i);
            i--;
            

        }

        //after all the panel in the map is finided calculate , then from the calculated map, pick the the least H one by one

        for (int i = 0; i < closedList.size(); i++) {
            if (waitList.size() > 0) {
                if (waitList.get(waitList.size() - 1).getPreviousFK().equals(closedList.get(i))) {
                    waitList.add(closedList.get(i));
                    if (closedList.get(i).equals(beginEne)) {
                        break;
                    }
                    closedList.remove(closedList.get(i));
                    i = -1;

                }
                continue;
            }

            if(closedList.get(i).equals(endEne)){
				waitList.add(closedList.get(i));
				closedList.remove(closedList.get(i));
				i = -1;
				continue;
			}


        }
        
        System.out.println("way list is " + waitList.size() );
        return waitList;
    }

    // from one block , get the other block around
    // if the around is wall, then resist  it from the open list

    public List<Eneposition> around(Eneposition Enemy) {
        List<Eneposition> aroundList = new ArrayList<Eneposition>();
        if (Enemy.getY() - 1 >= 0) {

            Eneposition tempPoistion = new Eneposition(Enemy.getX(), Enemy.getY() - 1, Enemy);
            if (!zhangaiList.contains(tempPoistion) && !closedList.contains(tempPoistion)) {
                aroundList.add(tempPoistion);
            }
        }

        if (Enemy.getY() + 1 <= 20) {
            Eneposition tempPoistion = new Eneposition(Enemy.getX(), Enemy.getY() + 1, Enemy);
            if (!zhangaiList.contains(tempPoistion) && !closedList.contains(tempPoistion)) {
                aroundList.add(tempPoistion);
            }
        }

        if (Enemy.getX() - 1 >= 0) {
            Eneposition tempPoistion = new Eneposition(Enemy.getX()-1, Enemy.getY(), Enemy);
            if (!zhangaiList.contains(tempPoistion) && !closedList.contains(tempPoistion)) {
                aroundList.add(tempPoistion);
            }
        }
        if (Enemy.getX() + 1 <= 20) {
            Eneposition tempPoistion = new Eneposition(Enemy.getX()+1, Enemy.getY(), Enemy);
            if (!zhangaiList.contains(tempPoistion) && !closedList.contains(tempPoistion)) {
                aroundList.add(tempPoistion);
            }
        }
        closedList.add(Enemy);
        getFGH(aroundList, Enemy);
        return aroundList;
    }

    // get F G and H in astar algorithm
    public void getFGH(List<Eneposition> list, Eneposition currFk) {
        if (list != null && list.size() > 0) {
            for (Eneposition fk : list) {
                fk.setG(currFk.getG() + 1);
                fk.setH(toGetH(fk, endEne));
                fk.setF(fk.getG() + fk.getH());
            }
        }
    }

    public int toGetH(Eneposition currentEne, Eneposition targetEne) {
        int h = 0;
        h += Math.abs(currentEne.getX() - targetEne.getX());
        h += Math.abs(currentEne.getY() - targetEne.getY());
        return h;
    }

}
