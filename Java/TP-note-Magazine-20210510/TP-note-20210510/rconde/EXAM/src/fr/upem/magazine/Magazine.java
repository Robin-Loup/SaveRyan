package fr.upem.magazine;

import java.util.ArrayList;
import java.util.Objects;

public class Magazine {
	private final String name;
	private int price;
	private ArrayList<Eval> evals;
	public Magazine(String name, int price) {
		
		this.name = Objects.requireNonNull(name);
		if(price>=0) {
			this.price = price;
		}
		else {
			throw new IllegalArgumentException("Price is lower than 0");
		}	
		
		this.evals = new ArrayList<Eval>();
	}
	
	public String name() {
		return this.name;
	}
	
	public int price() {
		return this.price;
	}
	
	public void price(int price) {
		this.price = price;
	}
	
	String nameClass() {
		return "magazine";
	}

	@Override
	public String toString() {
		return this.name + " " + nameClass() + " at " + this.price() + "€";
	}
	
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Magazine)) {
			return false;
		}
		Magazine magazine = (Magazine) o;
		
		return this.name.equals(magazine.name);
		
	}
	
	public void addEval(Eval eval) {
		this.evals.add(eval);
	}
	
	public int averageScore() {
		int total = 0;
		int count = 0;
		for(var value : evals) {
			count++;
			total += value.score();
		}
		return total/count;
	}
	
	/*public Eval[] five(){
		int i = 0;
		Eval[] five;
		
		for(i=0; i<5; i++) {
			five[i] = 
		}
	}*/
}
