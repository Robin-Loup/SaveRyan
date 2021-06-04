package fr.upem.magazine;

import java.util.Objects;

public class StarEval implements Eval {
	private int stars;
	private String comment;
	
	public StarEval(int stars, String comment) {
		if (stars < 0 || stars > 5) {
			throw new IllegalArgumentException("Invalid score");
		}
		Objects.requireNonNull(comment);
		if (comment.length() < 1) {
			throw new IllegalArgumentException("Invalid comment");
		}
		this.stars = stars;
		this.comment = comment;
	}

	@Override
	public int score() {
		return this.stars * 20 - 50;
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		for (int i = 0; i < this.stars; i++) {
			string.append("*");
		}
		string.append(" " + this.comment);
		return string.toString();
	}

}
