package fr.upem.magazine.eval;

import java.util.Objects;

public class StarEval implements Eval {
	private final int stars;
	private final String comment;
	
	public StarEval(int stars, String comment) {
		Objects.requireNonNull(stars);
		Objects.requireNonNull(comment);
		if (stars<0 || stars>5) {
			throw new IllegalArgumentException("Nombre d'étoiles incorrect.");
		}
		this.stars = stars;
		this.comment = comment;
	}
	
	@Override
	public int score() {
		return 20*this.stars-50;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i<this.stars; i++) {
			sb.append("*");
		}
		return sb.append(" ").append(this.comment).toString();
	}
}
