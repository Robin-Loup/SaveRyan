package fr.upem.magazine;

public class StarEval implements Eval {
	private final int star;
	private final String comment;
	
	public StarEval(int star,String comment) {
		if (star > 5 || star < 0 ) {
			throw new IllegalArgumentException("stars coming from this Eval need to be between 0 & 5 !");
		}
		this.star = star;
		this.comment = comment;
	}
	
	@Override
	public int score() {
		return (20*star)-50;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < star; i++) {
			str.append("*");
		}
		str.append(" ");
		str.append(comment);
		return str.toString();
	}

}
