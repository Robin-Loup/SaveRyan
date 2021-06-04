package fr.upem.magazine;

public class LikeEval implements Eval {
	private final boolean like;

	public LikeEval(boolean like) {
		super();
		this.like =like;
	}
	
	public int score() {
		if (like)
			return 50;
		return -50;
	}
	
	public String toString() {
		if (like)
			return "\uD83D\uDC4D";
		else
			return "\uD83D\uDC4E";
	}
 	
}
