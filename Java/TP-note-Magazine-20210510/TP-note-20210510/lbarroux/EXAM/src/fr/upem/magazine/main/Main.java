package fr.upem.magazine.main;

import fr.upem.magazine.*;

import java.util.HashSet;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		var magazine1 = new Magazine("Rolling Stone", 8);
	    System.out.println(magazine1);  // Rolling Stone magazine at 8€
	    System.out.println(magazine1.price()); // 8
	    magazine1.price(9);	
	    System.out.println(magazine1);  // Rolling Stone magazine at 9€
	    
	    var magazine2 = new Magazine("newsweek", 7);
	    var magazine3 = new Magazine("newsOfTheWorld", 3);
	    var magazineList = List.of(magazine1, magazine2, magazine3);
	    System.out.println(magazineList.contains(new Magazine("newsweek", 0)));  // true
	    System.out.println(magazineList.contains(new Magazine("newswoke", 0)));  // false
			
	    var magazineSet = new HashSet<>(magazineList);
	    System.out.println(magazineSet.contains(new Magazine("newsweek", 0)));  // true
	    System.out.println(magazineSet.contains(new Magazine("newswoke", 0)));  // false	
 
	    var almanac1 = new Almanac("Rolling Stone", 19, 2020);
	    System.out.println(almanac1);  // rolling stone almanac of 2020 at 19€
	    System.out.println(almanac1.price()); // 19
	    almanac1.price(20);
	    System.out.println(almanac1);  // rolling stone almanac of 2020 at 20€
	    
	    var almanac2 = new Almanac("newsweek", 17, 2019);
	    var almanac3 = new Almanac("newsOfTheWorld", 13, 2019);
	    var almanacList = List.of(almanac1, almanac2, almanac3);
	    System.out.println(almanacList.contains(new Almanac("newsweek", 0, 2019)));  // true
	    System.out.println(almanacList.contains(new Almanac("newsweek", 0, 2073)));  // false

	    var almanacSet = new HashSet<>(almanacList);
	    System.out.println(almanacSet.contains(new Almanac("newsweek", 0, 2019)));  // true
	    System.out.println(almanacSet.contains(new Almanac("newsweek", 0, 2073)));  // false
	    
		var starEval = new Eval.StarEval(3,"correct");
	    System.out.println(starEval);  // *** correct
	    System.out.println(starEval.score());  // 10
	    var likeEval = new Eval.LikeEval(true);
	    System.out.println(likeEval);  // 👍
	    System.out.println(likeEval.score());  // 50
	    var unlikeEval = new Eval.LikeEval(false);
	    System.out.println(unlikeEval);  // 👎
	    System.out.println(unlikeEval.score());  // -50
	    
	    magazine1.addEval(starEval);
	    magazine1.addEval(likeEval);
//	    System.out.println(magazine1.averageScore());  // 30.0
	    
	    System.out.println(magazine1.lastFiveEvals());  // [*** correct, 👍]
	    magazine1.addEval(new Eval.StarEval(0, "wtf"));
	    magazine1.addEval(new Eval.StarEval(5, "wonderful"));
	    magazine1.addEval(new Eval.StarEval(4, "nice!"));
	    magazine1.addEval(new Eval.LikeEval(true));
	    System.out.println(magazine1.lastFiveEvals());  
	}
}
