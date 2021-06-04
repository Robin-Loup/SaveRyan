package fr.upem.magazine;

import java.util.ArrayList;
import java.util.Objects;

public class Magazine {
	private final String name;
	private int price ;
	private ArrayList<Eval> eval = new ArrayList<>();
	
	public Magazine(String name, int price) {
		this.name = Objects.requireNonNull(name);
		if(price < 0 || name.isBlank()) throw new IllegalArgumentException();
		this.price = price;
	}
	public String name() {
		return name;
	}

	public int price() {
		return price;
	}
	public void price(int price) {
		this.price = price;
	}
	
	public void addEval(Eval e) {
		Objects.requireNonNull(e);
		eval.add(e);
	}
	public double averageScore() {
		if(eval.size() <1 )return 0; 
		double sum = 0;
		for(Eval e : eval) {
			sum += e.score();
		}
		return sum / eval.size();
	}
	public String lastFiveEvals() {
		
		ArrayList<String> evals= new ArrayList<>();
		if(eval.size() < 5){
			for(int i = 0 ; i< eval.size(); i++) {
				evals.add(eval.get(i).toString());
			}
		}
		else {
			for(int i = eval.size()-5; i<eval.size(); i++) {
				evals.add(eval.get(i).toString());
			}
		}
		return evals.toString();
	}
	public String worstEval() {
		if(eval.size() < 1) return null;
		int worstScore = 50;
		String worstEval ="";
		for(Eval e : eval) {
			if(e.score() < worstScore) {
				worstScore = e.score();
				worstEval = e.toString();
			}
		}
		return worstEval;
		
	}
	
	public boolean isMoreTrendy(Magazine m) {
		if(m == null) return false;
		if(this.averageScore() > m.averageScore() ) return true;
		return false;
	}
	public boolean isMoreTrendy(Almanac m) {
		if(m == null) return false;
		if(!(this.getClass().equals(m.getClass()))) return false;
		if(this.averageScore() > m.averageScore() ) return true;
		return false;
	}
	@Override
	public String toString() {
		return name() +" magazine at " + price();
	}
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Magazine)) return false;
		Magazine m = (Magazine) obj;
		return this.name().equals(m.name())  ;
	}

	


}
