package fr.upem.magazine;

public class StarEval implements Eval {

	private int star;
	private String comment;
	
	public StarEval(int star, String comment) {
		if(star <0 || star >5) {
			throw new IllegalArgumentException("star number must be between 0 and 5");
		}
		this.star = star;
		this.comment = comment;
	}

	@Override
	public int score() {
		return (star *20)-50;
	}

	@Override
	public String toString() {
		return "*".repeat(star)+" "+comment;
	}

	
}
