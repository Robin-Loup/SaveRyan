package fr.upem.magazine;

public class LikeEval implements Eval {
	private final boolean like;
	
	public LikeEval(boolean like) {
		this.like = like;
	}

	@Override
	public int score() {
		return like ? 50 : -50;
	}
	
	@Override
	public String toString() {
		return like ? "👍" : "👎";
	}

}
