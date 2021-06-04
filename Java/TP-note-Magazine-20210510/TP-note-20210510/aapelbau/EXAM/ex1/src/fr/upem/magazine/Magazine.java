package fr.upem.magazine;

import java.util.ArrayList;
import java.util.Objects;

public class Magazine {
	private final String name;
	private int price;
	private ArrayList<Eval> reviews;
	
	public Magazine(String name, int price) {
		Objects.requireNonNull(name);
		
		this.name = name;
		price(price);
		reviews = new ArrayList<>();
	}

	public int price() {
		return price;
	}

	public void price(int price) {
		this.price =  Math.max(0, price);;
	}
	
	@Override
	public String toString() {
		return this.name() + " magazine at " + this.price + "€";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//Price must not be used for equality
		result = prime * result + ((name() == null) ? 0 : name().hashCode());
		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || !(obj instanceof Magazine))
			return false;
		Magazine other = (Magazine) obj;
		//Price must not be used for equality
		if (name() == null) {
			if (other.name() != null)
				return false;
		} else if (!name().equals(other.name()))
			return false;
		
		return true;
	}

	String name() {
		return name;
	}

	public int averageScore() {
		int average = 0;
		for (Eval eval : reviews) {
			average += eval.score();
		}
		average /= reviews.size();
		return average;
	}

	public void addEval(Eval review) {
		Objects.requireNonNull(review);
		this.reviews.add(review);
	}
	
	public ArrayList<Eval> lastFiveEvals(){
		int buff = Math.min(5, this.reviews.size());
		ArrayList<Eval> lastReviews =  new ArrayList<>();
		for(int i = this.reviews.size() - buff; i < this.reviews.size(); i++) {
			lastReviews.add(this.reviews.get(i));
		}
		return lastReviews;
	}
	
	public Eval worstEval() {
		if(this.reviews.size() == 0)
			return null;
		
		Eval worstEval =  this.reviews.get(0);
		int worstScore = this.reviews.get(0).score();
		
		for (int i = 0; i<this.reviews.size(); i++) {
			int score = this.reviews.get(i).score();
			if(score < worstScore) {
				worstScore = score;
				worstEval = this.reviews.get(i);
			}
		}
		
		return worstEval;
	}
	
	public boolean isMoreTrendy(Magazine magazine) {
		if(this.averageScore() > magazine.averageScore())
			return true;
		else if(this.averageScore() < magazine.averageScore())
			return false;
		else{
			if(this instanceof Almanac && magazine instanceof Magazine)
				return true;
			else if(this instanceof Magazine && magazine instanceof Almanac)
				return false;
		}
		return true;
	}
	

}
