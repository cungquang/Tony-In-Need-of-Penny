package game.enemy_test;

import java.util.ArrayList;
import java.util.List;

import java.lang.*;
import game.enemy_test.MyPanel;
import game.enemy_test.Eneposition;

public class AutiFindWay {
    public static Eneposition beginEne = null;
    public static Eneposition endEne = null;

    public static void main(String[] args) {
        AutiFindWay afw = new AutiFindWay();
        MyPanel cat = new MyPanel(4, 6);
        MyPanel fish = new MyPanel(10, 10);
        List<Eneposition> way = afw.getWayLine(cat, fish);
        System.out.println(
                "-------------------------------------------------------------++++++++++++++++++++++" + way.size());

    }

    public List<Eneposition> getWayLine(MyPanel cat, MyPanel fish) {
        List<Eneposition> waitList = new ArrayList<>();
        List<Eneposition> tempList = null;
        beginEne = new Eneposition(cat);
        beginEne.setG(0);
        endEne = new Eneposition(fish);

        tempList = around(beginEne);
        if (tempList == null || tempList.size() == 0) {
            return waitList;
        }

        Enemy_test_main.openList.addAll(tempList);
        for (int i = 0; i < Enemy_test_main.openList.size(); i++) {

            Eneposition temp = Enemy_test_main.openList.get(i);
            tempList = around(temp);
            if (tempList == null || tempList.size() == 0) {
                continue;
            }
            if (tempList.contains(endEne)) {
                for (Eneposition obj : tempList) {
                    if (obj.equals(endEne)) {
                        Enemy_test_main.closedList.add(obj);
                        break;
                    }
                }
                break;

            }
            for (Eneposition fk : tempList) {
                if (Enemy_test_main.openList.contains(fk)) {


                    for (Eneposition openFk : Enemy_test_main.openList) {
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
                    Enemy_test_main.openList.add(fk);
                }
            }
            // System.out.println("all
            // fail--------------------------------------------------------------------------------------------"+i);

            Enemy_test_main.openList.remove(i);
            i--;

        }

        for (int i = 0; i < Enemy_test_main.closedList.size(); i++) {
            if (waitList.size() > 0) {
                if (waitList.get(waitList.size() - 1).getPreviousFK().equals(Enemy_test_main.closedList.get(i))) {
                    waitList.add(Enemy_test_main.closedList.get(i));
                    if (Enemy_test_main.closedList.get(i).equals(beginEne)) {
                        break;
                    }
                    Enemy_test_main.closedList.remove(Enemy_test_main.closedList.get(i));
                    i = -1;

                }
                continue;
            }

            if(Enemy_test_main.closedList.get(i).equals(endEne)){
				waitList.add(Enemy_test_main.closedList.get(i));
				Enemy_test_main.closedList.remove(Enemy_test_main.closedList.get(i));
				i = -1;
				continue;
			}


        }

        System.out.println("This is the wait list number:" + waitList.size());
        return waitList;
    }

    public List<Eneposition> around(Eneposition Enemy) {
        List<Eneposition> aroundList = new ArrayList<Eneposition>();
        if (Enemy.getY() - 1 >= 0) {

            Eneposition tempPoistion = new Eneposition(Enemy.getX(), Enemy.getY() - 1, Enemy);
            if (!Enemy_test_main.zhangaiList.contains(tempPoistion) && !Enemy_test_main.closedList.contains(tempPoistion)) {
                aroundList.add(tempPoistion);
            }
        }

        if (Enemy.getY() + 1 <= Enemy_test_main.heightLength) {
            Eneposition tempPoistion = new Eneposition(Enemy.getX(), Enemy.getY() + 1, Enemy);
            if (!Enemy_test_main.zhangaiList.contains(tempPoistion) && !Enemy_test_main.closedList.contains(tempPoistion)) {
                aroundList.add(tempPoistion);
            }
        }

        if (Enemy.getX() - 1 >= 0) {
            Eneposition tempPoistion = new Eneposition(Enemy.getX()-1, Enemy.getY(), Enemy);
            if (!Enemy_test_main.zhangaiList.contains(tempPoistion) && !Enemy_test_main.closedList.contains(tempPoistion)) {
                aroundList.add(tempPoistion);
            }
        }
        if (Enemy.getX() + 1 <= Enemy_test_main.heightLength) {
            Eneposition tempPoistion = new Eneposition(Enemy.getX()+1, Enemy.getY(), Enemy);
            if (!Enemy_test_main.zhangaiList.contains(tempPoistion) && !Enemy_test_main.closedList.contains(tempPoistion)) {
                aroundList.add(tempPoistion);
            }
        }
        Enemy_test_main.closedList.add(Enemy);
        getFGH(aroundList, Enemy);
        return aroundList;
    }

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
