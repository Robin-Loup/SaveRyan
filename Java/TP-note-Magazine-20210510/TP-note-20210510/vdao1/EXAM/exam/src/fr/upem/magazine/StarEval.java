package fr.upem.magazine;

import java.util.Objects;

public class StarEval implements Eval{
	private int score;
	private String comment;
	public int score() {
		return this.score*20-50;
	}
	
	@Override
	public String toString() {
		StringBuilder sb= new StringBuilder();
		for(int i=0;i< this.score; i++) sb.append("*");
		return sb.toString()+ " "+ this.comment;
	}

	public StarEval(int score,String comment) {
		// TODO Auto-generated constructor stub
		Objects.requireNonNull(comment);
		if(score < 0 || score > 5) throw new IllegalArgumentException("Invalid score");
		this.score=score;
		this.comment=comment;
	}
}
