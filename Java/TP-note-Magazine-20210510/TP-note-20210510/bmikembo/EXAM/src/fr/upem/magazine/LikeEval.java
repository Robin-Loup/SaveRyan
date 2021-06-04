package fr.upem.magazine;

public class LikeEval implements Eval {
	private final boolean isLike;
	public LikeEval(boolean isLike) {
		this.isLike = isLike;
	}
	@Override
	public int score() {
		// TODO Auto-generated method stub
		return isLike ? 50 : -50;
	}
	@Override
	public String toString() {
		return isLike ? "\uD83D\uDC4D" : "\uD83D\uDC4E";
	}
	
}
