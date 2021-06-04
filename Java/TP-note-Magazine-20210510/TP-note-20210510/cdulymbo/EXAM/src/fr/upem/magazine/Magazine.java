package fr.upem.magazine;

import java.util.ArrayList;
import java.util.Objects;

public class Magazine{

	private final String name;
	private int price;
	private ArrayList<Eval> evals;


	public Magazine (String name, int price) {
		if(name.equals("") || price < 0)
			throw new IllegalArgumentException();

		this.name = Objects.requireNonNull(name);
		this.price = Objects.requireNonNull(price);

		this.evals = new ArrayList<Eval>();
	}

	public final int price() {
		return this.price;
	}

	public final void price(int price) {
		if(price < 0)
			throw new IllegalArgumentException();

		this.price = Objects.requireNonNull(price);
	}

	protected String getType() {
		return "magazine";
	}

	@Override
	public String toString() {
		return this.name+" "+this.getType()+" at "+this.price+"€";
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Magazine))
			return false;

		Magazine mag = (Magazine) obj;

		// TODO Comprendre pourquoi ca ne marche pas dans le HashSet
		return this.name.equals(mag.name);
	}
	
	public final void addEval(Eval e) {
		this.evals.add(e);
	}

	public final double averageScore() {
		if (this.evals.isEmpty())
			return 0.0;

		int sum = 0;

		for(var e : this.evals) {
			sum+=e.score();
		}

		return (double)sum/this.evals.size();

	}

	public final String lastFiveEvals() {
		int i = 0;
		int size = this.evals.size();
		var sb = new StringBuilder();

		sb.append('[');
		for(var e : this.evals) {
			if (i > size - 5) {				
				sb.append(e.toString());
				if (i == size - 1)
					sb.append(' ');
				else
					sb.append(", ");
			}
			i++;
		}
		sb.append(']');

		return sb.toString();
	}

	public final Eval worstEval() {
		Eval worst = null;

		for(var e : this.evals) {
			if (worst == null || worst.score() > e.score()) {
				worst = e;
			}
		}

		return worst;
	}

	public final boolean isMoreTrendy(Magazine m) {
		double avgThis = this.averageScore();
		double avgM = m.averageScore();

		boolean res;

		if(this.getType().equals("almanac") && m.getType().contentEquals("magazine")) {
			res =  true;
		} else if (this.getType().equals("magazine") && m.getType().contentEquals("almanac")) {
			res =  false;
		} else {
			res =  avgThis > avgM;
		}
		return res;
	}
}
