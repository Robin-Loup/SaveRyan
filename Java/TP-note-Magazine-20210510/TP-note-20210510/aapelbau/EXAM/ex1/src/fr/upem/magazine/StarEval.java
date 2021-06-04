package fr.upem.magazine;

import java.util.Objects;

public class StarEval implements Eval{
	private int stars;
	private String comment;

	public StarEval(int stars, String comment) {
		super();
		this.stars = stars;
		this.comment(comment);
	}

	@Override
	public int score() {
		return 20*this.stars - 50;
	}

	public int stars() {
		return stars;
	}

	public void stars(int stars) {
		stars  = Math.max(0, stars);
		stars = Math.min(5, stars);
		this.stars = stars;
	}

	public String comment() {
		return comment;
	}

	public void comment(String comment) {
		Objects.requireNonNull(comment);
		this.comment = comment;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0;i < stars; i++) {
			sb.append('*');
		}
		return sb.toString() + " " + comment();
	}

}
