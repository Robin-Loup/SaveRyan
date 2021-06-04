package fr.umlv.fight;

public class Arena {
	public static String fight(Robot rob1, Robot rob2) {
		
		while (!rob1.isDead() && !rob2.isDead()) {
			rob1.fire(rob2);
			System.out.println(rob2 + " a été touché par le " + rob1 +" !");
			if (!rob2.isDead()) {
				rob2.fire(rob1);
				System.out.println(rob1 + " a été touché par le " + rob2 +" !");
			}
		}
		if (rob1.isDead()) {
			System.out.println(rob1 + " a été tué, le " + rob2 + " a gagné !");
			return rob2.toString();
			
		}
		else {
			System.out.println(rob2 + " a été tué, le " + rob1 + " a gagné !");
			return rob1.toString();
		}
	}
	
	public static void main(String[] args) {
		var bob = new Robot("D2R2");
		var rob = new Fighter("Robin", 20);
		System.out.println(Arena.fight(rob, bob)+"\n");
		
		
		var john = new Fighter("John", 2);
	    var jane = new Fighter("Jane", 1);
	    System.out.println(Arena.fight(john, jane) + " wins");
	}
}
