package fr.upem.magazine;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Magazine
 * 
 * A class that represent a Magazine. It's name cannot be null It's price must
 * be superior to 0
 *
 *
 */
public class Magazine {
	private final String name;
	private int price;
	private ArrayList<Eval> evals = new ArrayList<>();

	/**
	 * Constructor of Magazine
	 * 
	 * @param name  Name of the Magazine
	 * @param price Price of the Magazine
	 * @throws NullPointerException     if the name is null
	 * @throws IllegalArgumentException if the price is inferior to 0
	 */
	public Magazine(String name, int price) {
		this.name = Objects.requireNonNull(name, "A name must be not null");

		checkPrice(price);

		this.price = price;
	}

	/**
	 * This function throws an IllegalArgumentException if the argument is inferior
	 * than 0
	 * 
	 * @param price given price
	 */
	private void checkPrice(int price) {
		if (price < 0) {
			throw new IllegalArgumentException("A price must be positive or 0");
		}
	}

	/**
	 * Add an evalution to the Magazine
	 * 
	 * @param eval The evaluation to be added
	 * @return true (as specified by Collection.add)
	 */
	public boolean addEval(Eval eval) {
		return evals.add(eval);
	}

	/**
	 * Price getter
	 * 
	 * @return The price of the Magazine
	 */
	public int price() {
		return price;
	}

	/**
	 * Price setter
	 * 
	 * @throws IllegalArgumentException if the price is inferior to 0
	 * @param price New price
	 */
	public void price(int price) {
		checkPrice(price);
		this.price = price;
	}

	/**
	 * Return the average score of the evaluations from the Magazine
	 * 
	 * @return The average score of the Magazine
	 */
	public double averageScore() {
		if (evals.isEmpty()) {
			return 0;
		}

		double score = 0;

		for (Eval eval : evals) {
			score += eval.score();
		}

		return score / evals.size();
	}

	/**
	 * Return a new List of Eval wich stand for the last five evaluation of the
	 * Magazine The List may be empty
	 * 
	 * @return A new List of Eval
	 * 
	 */
	public List<Eval> lastFiveEvals() {
		int size = evals.size();
		List<Eval> lastEval = new ArrayList<>();
		if (size <= 5) {
			return evals;
		}

		/*
		 * Plutôt que de renvoyer directement la subList, j'en fait une copie Sinon, on
		 * peut la récupérer puis la modifier et ça modifie notre liste dans magazine.
		 */
		List<Eval> subEvals = evals.subList(size - 5, size);
		for (Eval eval : subEvals) {
			lastEval.add(eval);
		}

		return lastEval;
	}

	/**
	 * Return the worst evaluation of the Magazine based of the score or null if
	 * there is any
	 * 
	 * @return The worst Eval or null
	 */
	public Eval worstEval() {
		if (evals.isEmpty())
			return null;

		Eval worstEval = evals.get(0);
		double min = worstEval.score();

		for (Eval eval : evals) {
			if (eval.score() < min) {
				worstEval = eval;
				min = worstEval.score();
			}
		}
	

		return worstEval;
	}

	/**
	 * Return true if the current magazine has a better or equal average score than
	 * the given magazine
	 * 
	 * Note, the way it's implemented is due to the fact that an almanac is *always*
	 * trendier than a magazine
	 * 
	 * @param mag given magazine
	 * @return True if the current magazine is trendier, false otherwise
	 */
	public boolean isMoreTrendy(Magazine mag) {
		boolean res = averageScore() >= mag.averageScore();
		if (res) {
			return !mag.isMoreTrendy(this);
		}

		return res;
	}

	/**
	 * Display the type of the object to print it
	 * 
	 * @return The type of the object
	 */
	protected String displayType() {
		return " magazine";
	}

	@Override
	public String toString() {
		return name + displayType() + " at " + price + "€";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Magazine))
			return false;
		Magazine other = (Magazine) obj;
		return name.equals(other.name);
	}

}
