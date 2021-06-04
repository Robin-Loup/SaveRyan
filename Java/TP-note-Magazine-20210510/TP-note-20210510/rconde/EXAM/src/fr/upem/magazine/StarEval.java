package fr.upem.magazine;

import java.util.Objects;

public class StarEval implements Eval {
	private final int stars;
	private final String comment;
	public StarEval(int stars, String comment) {
		if(stars>=0 && stars <=5) {
			this.stars = stars;
		}
		else {
			throw new IllegalArgumentException("stars not between or equal to 0 and 5");
		}
		
		this.comment = Objects.requireNonNull(comment);
	}
	
	public int score() {
		return (this.stars * 20) - 50;
	}

	@Override
	public String toString() {
		StringBuilder rating = new StringBuilder();
		int i = 0;
		for(i=0; i<this.stars;i++) {
			rating.append("*");
		}
		rating.append(" ").append(this.comment);
		return rating.toString();
	}
	
	
	
	
}
