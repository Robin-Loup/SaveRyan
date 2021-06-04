package fr.upem.Eval;

import java.util.Objects;

public class StarEval implements Eval{
	private int star;
	private String com;
	
	public StarEval(int star, String com) {
		Objects.requireNonNull(star);
		Objects.requireNonNull(com);
		if(star < 0 || star > 5) {
			throw new IllegalArgumentException("Star doit etre comprit entre 0  et 5");
		}
		if(com.length() < 1) {
			throw new IllegalArgumentException("Com doit contenir au moins 1 caractère");
		}
		this.star = star;
		this.com = com;
	}
	
	public int score() {
		return (star*20)-50;
	}
	
	@Override
	public String toString() {
		var sb = new StringBuilder();
		for(int i=0; i<star; i++) {
			sb.append("*");
		}
		return sb.toString() + " " + com;
	}
}
