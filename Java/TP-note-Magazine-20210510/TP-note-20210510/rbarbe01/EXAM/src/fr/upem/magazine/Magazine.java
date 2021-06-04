package fr.upem.magazine;

import java.util.ArrayList;
import java.util.Objects;

public class Magazine {
	private final String name;
	private int price;
	private ArrayList<Eval> evals;
	
	public Magazine(String name, int price) {
		Objects.requireNonNull(name);
		if (name.length() < 1) {
			throw new IllegalArgumentException("Invalid name");
		}
		if (price < 0) {
			throw new IllegalArgumentException("Invalid price");
		}
		this.name = name;
		this.price = price;
		this.evals = new ArrayList<Eval>();
	}
	
	public int price() {
		return this.price;
	}
	
	public void price(int price) {
		if (price < 0) {
			throw new IllegalArgumentException("Invalid price");
		}
		this.price = price;
	}

	@Override
	public String toString() {
		return this.name + " magazine at " + this.price + " €";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Magazine) {
			Magazine magazine = (Magazine) obj;
			return this.name.equals(magazine.name);
		}
		return false;
	}
	
	protected String name() {
		return this.name;
	}
	
	public void addEval(Eval eval) {
		evals.add(eval);
	}
	
	public double averageScore() {
		double totalEval = 0;
		if (evals.isEmpty()) {
			return totalEval;
		}
		for (Eval eval : evals) {
			totalEval += eval.score();
		}
		return totalEval / evals.size();
	}
	
	public String lastFiveEvals() {
		StringBuilder string = new StringBuilder();
		string.append("[");
		int i = 4;
		if (evals.size() < 4) {
			i = evals.size() - 1;
		}
		for (; i >= 0; i--) {
			string.append(evals.get(evals.size() - 1 - i));
			if (i != 0) {
				string.append(", ");
			}
		}
		string.append("]");
		return string.toString();
	}
	
	public String worstEval() {
		if (evals.size() > 0) {
			Eval worstEval = evals.get(0);
			for (Eval eval : evals) {
				if (eval.score() < worstEval.score()) {
					worstEval = eval;
				}
			}
			return worstEval.toString();
		}
		return "null";
	}
	
	public boolean isMoreTrendy(Magazine magazine) {
		if (magazine instanceof Almanac) {
			return false;
		}
		if (this.averageScore() >= magazine.averageScore()) {
			return true;
		}
		return false;
	}
}
