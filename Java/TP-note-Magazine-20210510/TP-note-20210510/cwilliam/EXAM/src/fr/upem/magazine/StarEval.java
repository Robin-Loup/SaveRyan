package fr.upem.magazine;

import java.util.Objects;

public class StarEval implements Eval {
	private int stars;
	private String comments;

	public StarEval(int stars, String comments) {
		Objects.requireNonNull(stars);
		Objects.requireNonNull(comments);
		this.stars = stars;
		this.comments = comments;
	}


	
	public int score() {
		
		return (stars*20)-50;
	}
	
	@Override
	public String toString() {
		var sb = new StringBuilder();
		int i;
		for(i = 0; i < stars; i++) {
			sb.append("*");
		}
		sb.append(" ").append(comments);
		return sb.toString();
	}
}
