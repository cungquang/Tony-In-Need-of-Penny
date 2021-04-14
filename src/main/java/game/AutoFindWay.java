package game;

import java.util.ArrayList;
import java.util.List;

import java.lang.*;
/**
 * walllist : The walls in enemy's minds; so that enemy can find the way:
 * Eneposition : Enemy's way to record the message of the path and the wall
 * closedlist : The path the enemy has walked or calculated
 * Openlist : list list of queue wait to be calcualted
 */
public class AutoFindWay {
    public static EnemyBlock beginEne = null;
    public static EnemyBlock endEne = null;
    public List<EnemyBlock> wallList = new ArrayList<>();
    public List<EnemyBlock> calutaledList = new ArrayList<>();
    public List<EnemyBlock> uncalculatedList = new ArrayList<>();

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

    public AutoFindWay(){
        
        //read the information of the map;
		for (int i = 0; i < 21; i++) {
			for (int j = 0; j < 20; j++) {
				if (maze[i][j]== 1) {
					int y = i;
					int x = j;
                    EnemyBlock wall = new EnemyBlock(x, y);
					wallList.add(wall);
				} 
			}
		}
    }
    //this is the main part of find the way
    /** 
     * waitlist: the path of optimized the path to get the target
    */
    public List<EnemyBlock> getWayLine(int distX, int distY, int localX, int localY) {
        List<EnemyBlock> waitList = new ArrayList<>();
        List<EnemyBlock> tempList = null;
        beginEne = new EnemyBlock(localX,localY);
        beginEne.setG(0);
        endEne = new EnemyBlock(distX, distY);

        tempList = getAroudBlock(beginEne);
        if (tempList == null || tempList.size() == 0) {
            return waitList;
        }

        uncalculatedList.addAll(tempList);
        //calculate the F G and  H in astar in the open list
        for (int i = 0; i < uncalculatedList.size(); i++) {

            EnemyBlock temp = uncalculatedList.get(i);
            tempList = getAroudBlock(temp);
            if (tempList == null || tempList.size() == 0) {
                continue;
            }
            if (tempList.contains(endEne)) {
                for (EnemyBlock obj : tempList) {
                    if (obj.equals(endEne)) {
                        calutaledList.add(obj);
                        break;
                    }
                }
                break;

            }
            for (EnemyBlock fk : tempList) {
                if (uncalculatedList.contains(fk)) {


                    for (EnemyBlock uncalculatedEnemyBlock : uncalculatedList) {
                        if (uncalculatedEnemyBlock.equals(fk)) {
                            if (uncalculatedEnemyBlock.getG() > fk.getG()) {
                                uncalculatedEnemyBlock.setG(fk.getG());
                                uncalculatedEnemyBlock.setF(uncalculatedEnemyBlock.getG() + uncalculatedEnemyBlock.getH());
                                uncalculatedEnemyBlock.setPreviousFK(fk.getPreviousFK());
                                break;
                            }
                        }
                    }
                } else {
                    uncalculatedList.add(fk);
                }
            }
        
            uncalculatedList.remove(i);
            i--;
            

        }

        //after all the panel in the map is finided calculate , then from the calculated map, pick the the least H one by one

        for (int i = 0; i < calutaledList.size(); i++) {
            if (waitList.size() > 0) {
                if (waitList.get(waitList.size() - 1).getPreviousFK().equals(calutaledList.get(i))) {
                    waitList.add(calutaledList.get(i));
                    if (calutaledList.get(i).equals(beginEne)) {
                        break;
                    }
                    calutaledList.remove(calutaledList.get(i));
                    i = -1;

                }
                continue;
            }

            if(calutaledList.get(i).equals(endEne)){
				waitList.add(calutaledList.get(i));
				calutaledList.remove(calutaledList.get(i));
				i = -1;
				continue;
			}


        }
        return waitList;
    }

    // from one block , get the other block around
    // if the around is wall, then resist  it from the open list

    public List<EnemyBlock> getAroudBlock(EnemyBlock Enemy) {
        List<EnemyBlock> aroundList = new ArrayList<EnemyBlock>();
        if (Enemy.getY() - 1 >= 0) {

            EnemyBlock tempPoistion = new EnemyBlock(Enemy.getX(), Enemy.getY() - 1, Enemy);
            if (!wallList.contains(tempPoistion) && !calutaledList.contains(tempPoistion)) {
                aroundList.add(tempPoistion);
            }
        }

        if (Enemy.getY() + 1 <= 20) {
            EnemyBlock tempPoistion = new EnemyBlock(Enemy.getX(), Enemy.getY() + 1, Enemy);
            if (!wallList.contains(tempPoistion) && !calutaledList.contains(tempPoistion)) {
                aroundList.add(tempPoistion);
            }
        }

        if (Enemy.getX() - 1 >= 0) {
            EnemyBlock tempPoistion = new EnemyBlock(Enemy.getX()-1, Enemy.getY(), Enemy);
            if (!wallList.contains(tempPoistion) && !calutaledList.contains(tempPoistion)) {
                aroundList.add(tempPoistion);
            }
        }
        if (Enemy.getX() + 1 <= 20) {
            EnemyBlock tempPoistion = new EnemyBlock(Enemy.getX()+1, Enemy.getY(), Enemy);
            if (!wallList.contains(tempPoistion) && !calutaledList.contains(tempPoistion)) {
                aroundList.add(tempPoistion);
            }
        }
        calutaledList.add(Enemy);
        getFGH(aroundList, Enemy);
        return aroundList;
    }

    // get F G and H in astar algorithm
    public void getFGH(List<EnemyBlock> list, EnemyBlock currFk) {
        if (list != null && list.size() > 0) {
            for (EnemyBlock fk : list) {
                fk.setG(currFk.getG() + 1);
                fk.setH(toGetH(fk, endEne));
                fk.setF(fk.getG() + fk.getH());
            }
        }
    }

    public int toGetH(EnemyBlock currentEne, EnemyBlock targetEne) {
        int h = 0;
        h += Math.abs(currentEne.getX() - targetEne.getX());
        h += Math.abs(currentEne.getY() - targetEne.getY());
        return h;
    }

}
