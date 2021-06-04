package fr.upem.magazine;

import java.util.Objects;

public class StarEval implements Eval {
	private final int starNumber;
	private final String comment;
	public StarEval(int starNumber, String comment) {
		Objects.requireNonNull(comment);
		if(starNumber < 0 || starNumber > 5) {
			throw new IllegalArgumentException("Number of star must be between 0 and 5");
		}
		this.starNumber = starNumber;
		this.comment = comment;
	}
	@Override
	public int score() {
		// TODO Auto-generated method stub
		return (20 * this.starNumber) - 50;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder();
		for(int i = 0; i < this.starNumber; i++) {
			str.append("*");
		}
		return str.toString() + " " + this.comment;
	}
}
