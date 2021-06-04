package fr.umlv.fight;

import java.util.Random;

public class Fighter extends Robot {
	private final Random rand;
	
	public Fighter(String str, int seed) {
		super(str);
		rand = new  Random(seed);
	}

	/*@Override
	public String toString() {
		return type() + name + " : " + pv;
	}*/
	
	@Override
	boolean rollDice() {
		return rand.nextBoolean();
	}
	
	/*@Override
	public Robot fire(Robot rob) {
		if(rand.nextBoolean()) {
			rob.pv -= 2;
		}
		if (rob.pv < 0)
			rob.pv = 0;
		return rob;
	}*/
	
	@Override
	String type() {
		return "Fighter";
	}
}
