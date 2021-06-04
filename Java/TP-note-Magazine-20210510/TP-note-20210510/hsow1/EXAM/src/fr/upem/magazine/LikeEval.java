package fr.upem.magazine;

public class LikeEval implements Eval{
	private final boolean like;

	public LikeEval(boolean like) {
		this.like = like;
	}
	
	public int score() {
		if(like) return 50;
		return -50;
		
	}
	@Override
	public String toString() {
		if(like) return "\uD83D\uDC4D";
		return "\uD83D\uDC4E";
		
	}
	
}
