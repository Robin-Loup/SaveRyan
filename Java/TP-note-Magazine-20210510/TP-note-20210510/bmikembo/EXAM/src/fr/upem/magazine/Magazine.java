package fr.upem.magazine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Magazine {
	private final String name;
	private int price;
	private final List<Eval> evalList;

	public Magazine(String name, int price) {
		Objects.requireNonNull(name);
		if (price < 0) {
			throw new IllegalArgumentException("Price cannot be negative");
		}
		this.name = name;
		this.price = price;
		this.evalList = new ArrayList<>();
	}

	public int price() {
		return this.price;
	}

	public void price(int price) {
		if (price < 0) {
			throw new IllegalArgumentException("Price cannot be negative");
		}
		this.price = price;
	}

	public void addEval(Eval eval) {
		Objects.requireNonNull(eval);
		this.evalList.add(eval);
	}

	public double averageScore() {
		if (this.evalList.isEmpty()) {
			return 0;
		}
		double total = 0;
		for (Eval eval : this.evalList) {
			total += eval.score();
		}
		return total /= this.evalList.stream().count();
	}

	public List<Eval> lastFiveEvals() {
		if(this.evalList.size() <= 5) {
			return this.evalList;
		}
		List<Eval> result = new ArrayList<>();
		for(int index = this.evalList.size() - 5; index < this.evalList.size(); index++) {
			result.add(this.evalList.get(index));
		}
		return result;
	}

	public Eval worstEval() {
		if (this.evalList.isEmpty()) {
			return null;
		}
		Eval worstEval = this.evalList.get(0);
		for (Eval eval : this.evalList) {
			if (eval.score() < worstEval.score()) {
				worstEval = eval;
			}
		}
		return worstEval;
	}

	public boolean isMoreTrendy(Magazine magazine) {
		if (this instanceof Almanac && !(magazine instanceof Almanac)) {
			return true;
		} else if (!(this instanceof Almanac) && magazine instanceof Almanac) {
			return false;
		} else {
			return this.averageScore() > magazine.averageScore();
		}
	}
	String getNameClass() {
		return "magazine";
	}
	@Override
	public String toString() {
		return this.name + " " + getNameClass() + " at " + this.price + "€";
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (!(obj instanceof Magazine)) {
			return false;
		}
		Magazine mag = (Magazine) obj;
		return this.name.equals(mag.name);
	}
}
