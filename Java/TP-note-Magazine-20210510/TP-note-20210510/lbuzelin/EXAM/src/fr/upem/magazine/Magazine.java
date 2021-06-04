package fr.upem.magazine;

import java.util.ArrayList;

/**
 * Magazine class
 * 
 * @author lbuzelin
 */
public class Magazine {
	
	private final String name;
	private int price;
	private ArrayList<Eval> evals;
	
	/**
	 * Constructor of a Magazine
	 * 
	 * @param name
	 * @param price
	 */
	public Magazine(String name, int price) {
		assert(name!=null);
		assert(price>=0);
		
		this.name = name;
		this.price = price;
		this.evals = new ArrayList<>();
	}
	
	/**
	 * Return an {@link Integer}, the price of the book
	 * 
	 * @return
	 * 		The price of the book
	 */
	public int price() {
		return this.price;
	}
	
	/**
	 * Change the price of the book
	 * 
	 * @param price
	 */
	public void price(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return this.name + almanacInfo() + " magazine at " + this.price + "€";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(this.getClass() != obj.getClass()) {
			return false;
		}
		
		Magazine magazine = (Magazine) obj;
		return this.name.equals(magazine.name);
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode() + 26;
	}
	
	String almanacInfo() {
		return "";
	}
	
	/**
	 * Add an evaluation to the book
	 * 
	 * @param eval
	 */
	public void addEval(Eval eval) {
		this.evals.add(eval);
	}
	
	/**
	 * Return average score<br>
	 * OR 0 if empty
	 * 
	 * @return
	 * 		Average score of the evaluation of the book
	 */
	public double averageScore() {
		if(this.evals.isEmpty()) {
			return 0;
		}
		
		double score=0;
		for(Eval eval : this.evals) {
			score+=eval.score();
		}
		return score/this.evals.size();
	}

	/**
	 * Return the 5 last evaluation<br>
	 * If there's less than 5, only return the number of evaluation that exist
	 * 
	 * @return
	 * 		{@link ArrayList} with the last comments
	 */
	public ArrayList<Eval> lastFiveEvals() {
		ArrayList<Eval> lastFive = new ArrayList<>();
		int numberOfComment = 5;
		
		if(this.evals.size() < 5) {
			numberOfComment = this.evals.size();
		}
		for(int i=numberOfComment; i > 0; i--) {
			lastFive.add(this.evals.get(this.evals.size() - i));
		}
		
		return lastFive;
	}
	
	/**
	 * Return the worst Eval<br>
	 * OR if the list is empty, return null
	 * 
	 * @return
	 * 		The worst {@link Eval}
	 */
	public Eval worstEval() {
		if(this.evals.isEmpty()) {
			return null;
		}
		Eval worstEval = this.evals.get(0);
		for(int i=1; i<this.evals.size(); i++) {
			if(worstEval.score() > this.evals.get(i).score()) {
				worstEval = this.evals.get(i);
			}
		}
		return worstEval;
	}

	/**
	 * Return true if the average score of the object who called the method is higher or equal to
	 * the score of the second magazine, false otherwise<br>
	 * If one the magazine is an almanac, he will always be more trend<br>
	 * And if both are almanacs, do the normal case with average score
	 * 
	 * @param magazine2
	 * @return
	 * 		{@link Boolean}
	 */
	public boolean isMoreTrendy(Magazine magazine2) {
		if(this.getClass() == magazine2.getClass()) {
			if(this.averageScore() >= magazine2.averageScore()) {
				return true;
			} else {
				return false;
			}
		}
		
		if(this.getClass() == Almanac.class) {
			return true;
		} else { /* magazine2.getClass() == Almanac.class
		 		  * Because they are not the same due to the first if, one of them is an Almanac, and the other
		 		  * a Magazine
		 		  */
			return false;
		}
	}
}
