package fr.upem.magazine;

import java.util.Objects;

public class StarEval implements Eval {
	private final int star;
	private final String comment;

	public StarEval(int star, String comment) {
		if (star < 0 || star > 5) {
			throw new IllegalArgumentException("Star must be in between 0 and 5 inclusive");
		}
		this.star = star;
		this.comment = Objects.requireNonNull(comment, "A descriptions must not be null");
	}

	@Override
	public String toString() {
		return "*".repeat(star) + " " + comment;
	}

	@Override
	public double score() {
		return 20 * star - 50;
	}

}
