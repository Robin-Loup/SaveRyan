package fr.upem.magazine;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author erober03
 *
 */
public class Magazine {
	private final String name;
	private int price;
	private final ArrayList<Eval> eval;

	public Magazine(String name, int price) {
		this.name = Objects.requireNonNull(name);
		if (price < 0) {
			throw new IllegalArgumentException("The price can't be lower then 0");
		}
		this.price = price;
		eval = new ArrayList<>();
	}

	public int price() {
		return price;
	}

	public void price(int price) {
		if (price < 0) {
			throw new IllegalArgumentException("The price can't be lower then 0");
		}
		this.price = price;
	}

	@Override
	public String toString() {
		return name + completeToString() + price + "€";
	}

	String completeToString() {
		return " magazine at ";
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Magazine)) {
			return false;
		} else {
			Magazine m = (Magazine) obj;
			return m.name.equals(name);
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	public boolean addEval(Eval e) {
		return eval.add(e);
	}

	public double averageScore() {
		if (eval.isEmpty()) {
			return 0;
		}
		double compteur = 0;
		// Evite d'appeller la méthode size 2 fois
		int size = eval.size();
		for (int i = 0; i < size; i++) {
			compteur += eval.get(i).score();
		}
		return compteur / size;

	}

	public List lastFiveEvals() {
		int compteur = 0;
		int size = eval.size();
		ArrayList<Eval> fiveLast = new ArrayList<>();
		for (int i = size - 5; i < size; i++) {
			if (compteur == 5) {
				return fiveLast;
			}
			if (i < 0) {
				continue;
			}
			fiveLast.add(eval.get(i));
		}
		return fiveLast;
	}

	public Eval worstEval() {

		Eval worst = null;
		for (int i = 0; i < eval.size(); i++) {
			if (worst == null || worst.score() > eval.get(i).score()) {
				worst = eval.get(i);
			}
		}
		return worst;
	}
	
	public boolean isMoreTrendy(Magazine m) {
		if (m.isTrendy() && !isTrendy()) {
			return false;
		}
		
		return averageScore() >= m.averageScore() ? true : false;
	}
	
	boolean isTrendy() {
		return false;
	}
}
