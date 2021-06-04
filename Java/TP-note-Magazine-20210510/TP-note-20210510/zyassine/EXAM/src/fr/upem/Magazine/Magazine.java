package fr.upem.Magazine;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import fr.upem.Eval.Eval;

public class Magazine {
	private final String name;
	private int price;
	private ArrayList<Eval> evals;
	
	public Magazine(String name, int price) {
		Objects.requireNonNull(name);
		Objects.requireNonNull(price);
		if(price < 0) {
			throw new IllegalArgumentException("Price doit etre positif !");
		}
		this.name = name;
		this.price = price;
		this.evals = new ArrayList<Eval>();
	}
	
	public int price() {
		return price;
	}
	
	public void price(int price) {
		this.price = price;
	}
	
	public boolean contains(Magazine m) {
		if(name.equals(m.name)) {
			return true;
		}
		return false;
	}
	
	public String name() {
		return name;
	}
	
	public void addEval(Eval e) {
		evals.add(e);
	}
	
	public double averageScore() {
		double s = 0;
		for(Eval e : evals) {
			s += e.score();
		}
		return s/evals.size();
	}
	
	public String lastFiveEvals() {
		String s ="[";
		int i;
		if(evals.size() < 5) {
			for(i = 0; i<evals.size(); i++) {
				if(i == 0) {
					s += evals.get(i);
				}
				else {
					s += ", " + evals.get(i);					
				}
			}
		}
		else {
			for(i = evals.size()-5; i<evals.size(); i++) {
				if(i == evals.size()-5) {
					s += evals.get(i);
				}
				else {
					s += ", " + evals.get(i);
				}
			}
		}
		return s += "]";
	}
	
	public Eval worstEval() {
		Eval worst;
		
		if(evals.size() == 0) {
			return null;
		}
		worst = evals.get(0);
		for(Eval e : evals) {
			if(e.score() < worst.score()) {
				worst = e;
			}
		}
		return worst;
	}
	
	public boolean isMoreTrendy(Magazine m) {
		if(m instanceof Almanac) {
			return false;
		}
		if(averageScore() > m.averageScore()) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return name + " at " + price + "€";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Magazine)) {
			return false;
		}
		Magazine m = (Magazine) obj;
		return name.equals(m.name);
	}
	
	
	
}
