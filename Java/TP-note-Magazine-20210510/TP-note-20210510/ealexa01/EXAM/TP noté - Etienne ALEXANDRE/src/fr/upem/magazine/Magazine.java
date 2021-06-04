package fr.upem.magazine;

import java.util.ArrayList;
import java.util.Objects;

import fr.upem.magazine.eval.Eval;

public class Magazine {
	private final String name;
	private int price;
	private final ArrayList<Eval> evals = new ArrayList<>();
	
	public Magazine(String name, int price) {
		Objects.requireNonNull(name);
		price(price);
		this.name = name;
	}
	
	String name() {
		return this.name;
	}
	
	public int price() {
		return this.price;
	}
	
	public void price(int price) {
		Objects.requireNonNull(price);
		if (price<0) {
			throw new IllegalArgumentException("Le prix ne peut pas être négatif.");
		}
		this.price = price;
	}
	
	@Override
	public String toString() {
		return this.name + " magazine at " + this.price + "€";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Magazine)) {
			return false;
		}
		Magazine o = (Magazine) obj;
		return Objects.equals(o.name, this.name);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.name);
	}
	
	public void addEval(Eval e) {
		Objects.requireNonNull(e);
		evals.add(e);
	}
	
	public double averageScore() {
		double averageScore = 0;
		for (Eval e : evals) {
			averageScore+=e.score();
		}
		int size = evals.size();
		return size!=0 ? averageScore/size : averageScore;
	}
	
	public ArrayList<Eval> lastFiveEvals() {
		ArrayList<Eval> l = new ArrayList<>();
		int size = evals.size();
		int i = size-5;
		for (i = i<0 ? 0 : i; i<size; i++) {
			l.add(evals.get(i));
		}
		return l;
	}
	
	public Eval worstEval() {
		Eval worst = null;
		for (Eval e : evals) {
			if (worst == null || worst.score()>e.score()) {
				worst = e;
			}
		}
		return worst;
	}
	
	boolean alwaysTrendy() {
		return false;
	}
	
	public boolean isMoreTrendy(Magazine m) {
		double score = this.averageScore();
		double other = m.averageScore();
		if (Boolean.logicalXor(this.alwaysTrendy(), m.alwaysTrendy())) { // On utiliser un XOR : pour le cas où on a un Magazine et un Almanach
			return this.alwaysTrendy();
		}
		return score>=other; // Si ce sont les 2 mêmes types : on compare les scores
	}
}
