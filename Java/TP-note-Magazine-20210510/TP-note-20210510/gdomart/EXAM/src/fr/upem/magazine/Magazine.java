package fr.upem.magazine;

import java.util.ArrayList;
import java.util.Objects;

public class Magazine {
	private final String name;
	private int price;
	private ArrayList<Eval> evaluation = new ArrayList<Eval>();
	
	
	public Magazine(String name, int price) {
		
		Objects.requireNonNull(name);
		if(price < 0)
			throw new IllegalArgumentException("Le prix ne peut pas être négatif !");
		
		this.name = name;
		this.price = price;
	}


	public int price() {
		return price;
	}


	public void price(int price) {
		this.price = price;
	}
	
	public String name() {
		return name;
	}


	@Override
	public String toString() {
		return name + " magazine at " + price + "€";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (!(obj instanceof Magazine)) {
			return false;
		}
		
		Magazine object = (Magazine) obj;
		
		if(name == object.name) {
			return true;
		}
		return false;
	}
	
	public void addEval(Eval eval) {
		evaluation.add(eval);
	}
	
	public double averageScore() {
		double number = 0;
		double score = 0;
		
		for (Eval eval : evaluation) {
			number += 1;
			score += eval.score();
		}
		return score / number ;
	}
	
	public ArrayList<Eval> lastFiveEvals(){
		ArrayList<Eval> lastfive = new ArrayList<Eval>();
		int min = 0;
		if(evaluation.size() < 5) {
			min = evaluation.size();
		}
		
		if(min == 0)
			min = 5;
		
		for(int i = 0; i < min; i++) {
		lastfive.add(evaluation.get(evaluation.size() - min + i));
		}
		
		return lastfive;
			
	}
	
	public Eval worstEval() {
		
		if(evaluation.size() == 0)
			return null;
			
		Eval worst = evaluation.get(0);
		
		for (Eval eval : evaluation) {
			if(worst.score() > eval.score())
				worst = eval;
		}
		return worst;
	}
	
	public boolean isMoreTrendy(Magazine other) {
		
		if(getClass() != other.getClass()) {
			if(other.getClass() == super.getClass())
				return true;
			return false;
		}
			
		if(averageScore() >= other.averageScore())
			return true;
		return false;		
	}
	
}
