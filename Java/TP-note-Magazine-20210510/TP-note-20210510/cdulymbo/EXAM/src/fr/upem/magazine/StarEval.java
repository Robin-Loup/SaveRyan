package fr.upem.magazine;

import java.util.Objects;

public class StarEval implements Eval {
	
	private final int star;
	private final String comment;
	
	public StarEval(int star, String comment) {
		if (star < 0 || star > 5 || comment.equals(""))
			throw new IllegalArgumentException();
		
		this.star = Objects.requireNonNull(star);
		this.comment = Objects.requireNonNull(comment);
	}

	@Override
	public String toString() {
		int i;
		var sb = new StringBuilder();
		
		
		for (i = 0; i < this.star; i++) {
			sb.append('*');
		}
		
		sb.append(' ');
		sb.append(this.comment);
		
		return sb.toString();
	}
	
	@Override
	public int score() {
		return 20*this.star - 50;
	}

}
