package fr.upem.magazine;

import java.util.Objects;

public class StarEval implements Eval {
	private final int starsnumber;
	private String comment;
	/**
	 * @param starsnumber
	 * @param comment
	 */
	public StarEval(int starsnumber, String comment) {
		this.starsnumber = starsnumber;
		if(starsnumber<0 || starsnumber>5) {
			throw new IllegalArgumentException("number of stars is not between 0 and 5");
		}
		this.comment = Objects.requireNonNull(comment);
	}
	@Override
	public String toString() {
		var eval = new StringBuilder();
		for(int i =0;i<starsnumber;i++) {
			eval.append("*");
		}
		eval.append(" ").append(comment);
		return eval.toString();
	}
	public int score() {
		return 20*starsnumber - 50;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
