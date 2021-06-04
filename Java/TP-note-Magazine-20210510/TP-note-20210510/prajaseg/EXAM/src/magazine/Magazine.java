package magazine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Magazine {
	final String nom;
	private int price;
	
	ArrayList <Eval> eval;
	
	public Magazine(String nom, int price) {
		this.nom=Objects.requireNonNull(nom);
		if(price<0)
			throw new IllegalArgumentException("Le prix doit être positif ou null");
		this.price=price; /*TODO*/
		this.eval=new ArrayList<Eval>();
	}
	
	int price() {
		return this.price;
	}

	void price(int price) {
		this.price=price;
	}
	
	public String nomClass() {
		return "magazine";
	}
	
	public String toString() {
		return this.nom+" "+nomClass()+" at "+this.price()+" €";
	}
	

	public boolean contains(Magazine magazine) {
		
		//	Objects.equals(magazine, e);
		

		if(magazine.nom.equals(this.nom))
			return true;
		return false;
	}
	
	
	
	
	public static void main(String[] args) {
		var magazine1 = new Magazine("rolling stone", 8);
		System.out.println(magazine1); // rolling stone magazine at 8€
		System.out.println(magazine1.price()); // 8
		magazine1.price(9);
		System.out.println(magazine1); // rolling stone magazine at 9€
		
		/*TODO*/
		var magazine2 = new Magazine("newsweek", 7);
	    var magazine3 = new Magazine("newsOfTheWorld", 3);
	    var magazineList = List.of(magazine1, magazine2, magazine3);
	    System.out.println(magazineList);
	    System.out.println(magazineList.contains(new Magazine("newsweek", 0)));  // true
	    System.out.println(magazineList.contains(new Magazine("newswoke", 0)));  // false
			
	    var magazineSet = new HashSet<>(magazineList);
	    System.out.println(magazineSet.contains(new Magazine("newsweek", 0)));  // true
	    System.out.println(magazineSet.contains(new Magazine("newswoke", 0)));  // false
	    
	    
	    
	    var almanac1 = new Almanac("rolling stone", 19, 2020);
	    System.out.println(almanac1);  // rolling stone almanac of 2020 at 19€
	    System.out.println(almanac1.price()); // 19
	    almanac1.price(20);
	    System.out.println(almanac1);  // rolling stone almanac of 2020 at 20€
	    
	    
	    /*TODO*/
	    var almanac2 = new Almanac("newsweek", 17, 2019);
	    var almanac3 = new Almanac("newsOfTheWorld", 13, 2019);
	    var almanacList = List.of(almanac1, almanac2, almanac3);
	    System.out.println(almanacList.contains(new Almanac("newsweek", 0, 2019)));  // true
	    System.out.println(almanacList.contains(new Almanac("newsweek", 0, 2073)));  // false

	    var almanacSet = new HashSet<>(almanacList);
	    System.out.println(almanacSet.contains(new Almanac("newsweek", 0, 2019)));  // true
	    System.out.println(almanacSet.contains(new Almanac("newsweek", 0, 2073)));  // false
	    
	    
	    
	    var starEval = new StarEval(3,"correct");
	    System.out.println(starEval);  // *** correct
	    System.out.println(starEval.score());  // 10
	    var likeEval = new LikeEval(true);
	    System.out.println(likeEval);  // 👍
	    System.out.println(likeEval.score());  // 50
	    var unlikeEval = new LikeEval(false);
	    System.out.println(unlikeEval);  // 👎
	    System.out.println(unlikeEval.score());  // -50
	
	    magazine1.addEval(starEval);
	    magazine1.addEval(likeEval);
	    //System.out.println(magazine1.eval);
	    System.out.println(magazine1.averageScore());  // 30.0
	    
	    
	    System.out.println(magazine1.lastFiveEvals());  // [*** correct, 👍]
	    magazine1.addEval(new StarEval(0, "wtf"));
	    magazine1.addEval(new StarEval(5, "wonderful"));
	    magazine1.addEval(new StarEval(4, "nice!"));
	    magazine1.addEval(new LikeEval(true));
	    System.out.println(magazine1.lastFiveEvals());  
	                // [👍,  wtf, ***** wonderful, **** nice!, 👍 ]
	    
	    System.out.println(magazine1.worstEval());  //  wtf
	    System.out.println(magazine2.worstEval());  // null
	    
	    System.out.println(magazine1.averageScore());          // 23.333333333333332
	    magazine2.addEval(new StarEval(2, "it sucks"));
	    System.out.println(magazine2.averageScore());          // -10.0
	    System.out.println(magazine1.isMoreTrendy(magazine2)); // true
	    almanac2.addEval(new StarEval(1, "too bad"));
	    System.out.println(almanac2.averageScore());           // -30.0
	    System.out.println(magazine1.isMoreTrendy(almanac2));  // false
	
	}

	private boolean isMoreTrendy(Magazine m) {
		if(this.nomClass().equals("almanac")&&m.nomClass().equals("almanac"))
			return true;
		else if(this.nomClass().equals("magazine")&&m.nomClass().equals("almanac"))
			return false;
		else if(this.nomClass().equals("magazine")&&m.nomClass().equals("magazine")) {
			if(this.averageScore()>=m.averageScore())
				return true;
			else return false;
		}
		return false;
	}

	private String lastFiveEvals() {
		int size=this.eval.size();
		if(size<5)
			return this.eval.toString();
		else
			return this.eval.subList(size-5, size).toString();
	}

	private String worstEval() {
		String w = null;
		int score=50;
		for (Eval e : this.eval) {
			if(e.score()<score) {
				score=e.score();
				w=e.toString();
			}
		}
		return w;
	}

	protected double averageScore() {
		int score=0;
		for (Eval e : this.eval) {
			score+=e.score();
		}
		return (double)score/this.eval.size();
	}

	public void addEval(Eval e) {
		eval.add(e);
	}

}
