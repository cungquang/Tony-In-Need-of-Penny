package main.java.game.enemy_test;

import java.util.ArrayList;
import java.util.List;

import java.lang.*;
import main.java.game.enemy_test.MyPanel;
import main.java.game.enemy_test.Eneposition;

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

        BasePanel.openList.addAll(tempList);
        for (int i = 0; i < BasePanel.openList.size(); i++) {

            Eneposition temp = BasePanel.openList.get(i);
            tempList = around(temp);
            if (tempList == null || tempList.size() == 0) {
                continue;
            }
            if (tempList.contains(endEne)) {
                for (Eneposition obj : tempList) {
                    if (obj.equals(endEne)) {
                        BasePanel.closedList.add(obj);
                        break;
                    }
                }
                break;

            }
            for (Eneposition fk : tempList) {
                if (BasePanel.openList.contains(fk)) {


                    for (Eneposition openFk : BasePanel.openList) {
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
                    BasePanel.openList.add(fk);
                }
            }
            // System.out.println("all
            // fail--------------------------------------------------------------------------------------------"+i);

            BasePanel.openList.remove(i);
            i--;

        }

        for (int i = 0; i < BasePanel.closedList.size(); i++) {
            if (waitList.size() > 0) {
                if (waitList.get(waitList.size() - 1).getPreviousFK().equals(BasePanel.closedList.get(i))) {
                    waitList.add(BasePanel.closedList.get(i));
                    if (BasePanel.closedList.get(i).equals(beginEne)) {
                        break;
                    }
                    BasePanel.closedList.remove(BasePanel.closedList.get(i));
                    i = -1;

                }
                continue;
            }

            if(BasePanel.closedList.get(i).equals(endEne)){
				waitList.add(BasePanel.closedList.get(i));
				BasePanel.closedList.remove(BasePanel.closedList.get(i));
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
            if (!BasePanel.zhangaiList.contains(tempPoistion) && !BasePanel.closedList.contains(tempPoistion)) {
                aroundList.add(tempPoistion);
            }
        }

        if (Enemy.getY() + 1 <= BasePanel.heightLength) {
            Eneposition tempPoistion = new Eneposition(Enemy.getX(), Enemy.getY() + 1, Enemy);
            if (!BasePanel.zhangaiList.contains(tempPoistion) && !BasePanel.closedList.contains(tempPoistion)) {
                aroundList.add(tempPoistion);
            }
        }

        if (Enemy.getX() - 1 >= 0) {
            Eneposition tempPoistion = new Eneposition(Enemy.getX()-1, Enemy.getY(), Enemy);
            if (!BasePanel.zhangaiList.contains(tempPoistion) && !BasePanel.closedList.contains(tempPoistion)) {
                aroundList.add(tempPoistion);
            }
        }
        if (Enemy.getX() + 1 <= BasePanel.heightLength) {
            Eneposition tempPoistion = new Eneposition(Enemy.getX()+1, Enemy.getY(), Enemy);
            if (!BasePanel.zhangaiList.contains(tempPoistion) && !BasePanel.closedList.contains(tempPoistion)) {
                aroundList.add(tempPoistion);
            }
        }
        BasePanel.closedList.add(Enemy);
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
