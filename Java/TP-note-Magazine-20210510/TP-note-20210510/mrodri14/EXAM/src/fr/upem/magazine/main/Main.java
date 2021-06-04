package fr.upem.magazine.main;

import java.util.HashSet;
import java.util.List;

import fr.upem.magazine.Almanac;
import fr.upem.magazine.LikeEval;
import fr.upem.magazine.Magazine;
import fr.upem.magazine.StarEval;

public class Main {
	public static void main(String[] args) {
		System.out.println("QUESTION 1 \n\n");

		var magazine1 = new Magazine("rolling stone", 8);
		System.out.println(magazine1); // rolling stone magazine at 8€
		System.out.println(magazine1.price()); // 8
		magazine1.price(9);
		System.out.println(magazine1); // rolling stone magazine at 9€

		System.out.println("\n\nQUESTION 2 \n\n");

		var magazine2 = new Magazine("newsweek", 7);
		var magazine3 = new Magazine("newsOfTheWorld", 3);
		var magazineList = List.of(magazine1, magazine2, magazine3);
		System.out.println(magazineList.contains(new Magazine("newsweek", 0))); // true
		System.out.println(magazineList.contains(new Magazine("newswoke", 0))); // false

		var magazineSet = new HashSet<>(magazineList);
		System.out.println(magazineSet.contains(new Magazine("newsweek", 0))); // true
		System.out.println(magazineSet.contains(new Magazine("newswoke", 0))); // false

		System.out.println("\n\nQUESTION 3 \n\n");

		var almanac1 = new Almanac("rolling stone", 19, 2020);
		System.out.println(almanac1); // rolling stone almanac of 2020 at 19€
		System.out.println(almanac1.price()); // 19
		almanac1.price(20);
		System.out.println(almanac1); // rolling stone almanac of 2020 at 20€

		System.out.println("\n\nQUESTION 4 \n\n");

		var almanac2 = new Almanac("newsweek", 17, 2019);
		var almanac3 = new Almanac("newsOfTheWorld", 13, 2019);
		var almanacList = List.of(almanac1, almanac2, almanac3);
		System.out.println(almanacList.contains(new Almanac("newsweek", 0, 2019))); // true
		System.out.println(almanacList.contains(new Almanac("newsweek", 0, 2073))); // false

		var almanacSet = new HashSet<>(almanacList);
		System.out.println(almanacSet.contains(new Almanac("newsweek", 0, 2019))); // true
		System.out.println(almanacSet.contains(new Almanac("newsweek", 0, 2073))); // false

		System.out.println("\n\nQUESTION 5 \n\n");

		var starEval = new StarEval(3, "correct");
		System.out.println(starEval); // *** correct
		System.out.println(starEval.score()); // 10
		var likeEval = new LikeEval(true);
		System.out.println(likeEval); // 👍
		System.out.println(likeEval.score()); // 50
		var unlikeEval = new LikeEval(false);
		System.out.println(unlikeEval); // 👎
		System.out.println(unlikeEval.score()); // -50

		System.out.println("\n\nQUESTION 6 \n\n");

		magazine1.addEval(starEval);
		magazine1.addEval(likeEval);
		System.out.println(magazine1.averageScore()); // 30.0

		System.out.println("\n\nQUESTION 7 \n\n");
		/*
		 * StarEval bob = new StarEval(4, "nice!"); magazine1.addEval(new StarEval(0,
		 * "wtf")); magazine1.addEval(new StarEval(5, "wonderful"));
		 * magazine1.addEval(bob); magazine1.addEval(new LikeEval(true));
		 * magazine1.addEval(new LikeEval(true)); magazine1.addEval(new
		 * LikeEval(false)); magazine1.addEval(new StarEval(5, "wonderful"));
		 * System.out.println(magazine1.lastFiveEvals().remove(bob)); // [👍, wtf, *****
		 * wonderful, **** nice!, 👍 ]
		 */

		System.out.println(magazine1.lastFiveEvals()); // [*** correct, 👍]
		magazine1.addEval(new StarEval(0, "wtf"));
		magazine1.addEval(new StarEval(5, "wonderful"));
		magazine1.addEval(new StarEval(4, "nice!"));
		magazine1.addEval(new LikeEval(true));
		System.out.println(magazine1.lastFiveEvals());
		// [👍, wtf, ***** wonderful, **** nice!, 👍 ]

		System.out.println("\n\nQUESTION 8 \n\n");

		System.out.println(magazine1.worstEval()); // wtf
		System.out.println(magazine2.worstEval()); // null

		System.out.println("\n\nQUESTION 9 \n\n");

		System.out.println(magazine1.averageScore()); // 23.333333333333332
		magazine2.addEval(new StarEval(2, "it sucks"));
		System.out.println(magazine2.averageScore()); // -10.0
		System.out.println(magazine1.isMoreTrendy(magazine2)); // true
		almanac2.addEval(new StarEval(1, "too bad"));
		System.out.println(almanac2.averageScore()); // -30.0
		System.out.println(magazine1.isMoreTrendy(almanac2)); // false
		System.out.println(almanac2.isMoreTrendy(magazine1)); // true
		//pouet
	}

}
