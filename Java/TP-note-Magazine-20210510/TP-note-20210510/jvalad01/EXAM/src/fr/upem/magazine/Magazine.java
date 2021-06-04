package fr.upem.magazine;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Magazine {
	private final String name;
	private int price;
	private List<Eval> evals;

	public Magazine(String name, int price) {
		super();
		if (Objects.requireNonNull(name).length() < 1)
			throw new IllegalArgumentException("name mustn't be empty");
		this.name = name;
		if (price < 0)
			throw new IllegalArgumentException("A price mustn't be negative or zero");
		this.price = price;
		evals = new ArrayList<>();
	}

	public int price() {
		return price;
	}
	
	public void price(int price) {
		this.price = price;
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;  
		if (getClass() != obj.getClass())
			return false;
		Magazine other = (Magazine) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	String linkBetweenNameAndPrice() {
		return " magazine at ";
	}

	public void addEval(Eval eval) {
		evals.add(eval); 
	}

	public double averageScore() {
		if (evals.size() == 0)
			return 0;
		double average = 0.0;
		for (Eval e : evals)
			average += e.score();
		return average / evals.size();
	}

	public List<Eval> lastFiveEvals() {
		List<Eval> eval = new ArrayList<>();
		int debut = 0;
		if ((evals.size() - 5) > 0)
			debut = evals.size() - 5;

		for (int i = debut; i < evals.size(); i++) {
			eval.add(evals.get(i));
		}

		return eval;
	}

	public Eval worstEval() {
		if (evals.size() == 0)
			return null;

		Eval eval = evals.get(0);
		for (int i = 1; i < evals.size(); i++) {
			if (eval.score() > evals.get(i).score())
				eval = evals.get(i);
		}
		return eval;
	}

	public boolean isMoreTrendy(Magazine obj) {
		if (getClass() == obj.getClass()) {
			if (averageScore() >= obj.averageScore())
				return true;
			return false;
		}

		if (getClass() == Almanac.class)
			return true;
		return false;
	}	
	
	@Override
	public String toString() {
		return name + linkBetweenNameAndPrice() + price + "€";
	}
}
