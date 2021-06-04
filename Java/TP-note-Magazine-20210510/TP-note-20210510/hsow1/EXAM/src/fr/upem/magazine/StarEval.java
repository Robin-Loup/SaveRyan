package fr.upem.magazine;

import java.util.Objects;

public class StarEval implements Eval {
	private final int score;
	private final String comment;
	public StarEval(int score,String comment) {
		if(score <0 || score >5) throw new IllegalArgumentException();
		this.score = score;
		this.comment = Objects.requireNonNull(comment);
	}

	public int score() {
		return score*20 -50;
	}
	@Override
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i< score; i++) {
			sb.append("*");
		}
		return sb.toString() + " " + comment();
		
	}

	public String comment() {
		return comment;
	}
	
	
}
