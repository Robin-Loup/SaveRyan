package fr.upem.magazine;

import java.util.Objects;

public class StarEval implements Eval {
	
	private final int star;
	private final String comm;
	
	public StarEval(int star,String comm) {
		Objects.requireNonNull(star);
		if(star<0 || star>5) {
			throw new IllegalArgumentException("star is only between 0 and 5");
		}
		this.star = star;
		this.comm=Objects.requireNonNull(comm);
	}
	
	@Override
	public String toString() {
	
		return "*".repeat(star)+" "+comm;
	}
	
	
	@Override
	public int score() {
		return star*20-50;
	}
	
	
}
