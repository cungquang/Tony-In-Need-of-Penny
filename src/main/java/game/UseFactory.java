package game;

import game.ObjFactory;

public class UseFactory{
	public static void main(String[] args){
		//object type to choose the type that need to create
		ObjType type1 = ObjType.reward;
		ObjType type2 = ObjType.bonus;

		//object factory to create
		ObjFactory factory = new ObjFactory();		

		//create an Reward object:
		Prize reward = factory.createPrize(type1,44, 44, 100);
		System.out.println("identity No: " + reward.getNbr());
		System.out.println("x-coordinate: " + reward.getPosition()[0]);
		System.out.println("y-coordinate: " + reward.getPosition()[1]);
		System.out.println("value of object: " + reward.getValue());

		//create a Bonus object:
		Prize bonus = factory.createPrize(type2, 4, 3, 111);
		System.out.println("identity No: " + bonus.getNbr());
		System.out.println("x-coordinate: " + bonus.getPosition()[0]);
		System.out.println("y-coordinate: " + bonus.getPosition()[1]);
		System.out.println("value of object: " + bonus.getValue());
	}
}