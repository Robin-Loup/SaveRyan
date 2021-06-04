package fr.upem.magazine;

public class LikeEval implements Eval {
	private boolean like;

	public LikeEval(boolean like) {
		this.like = like;
	}

	@Override
	public int score() {
		if (this.like) {
			return 50;
		}
		return -50;
	}

	@Override
	public String toString() {
		if (this.like) {
			return "\uD83D\uDC4D";
		}
		return "\uD83D\uDC4E";
	}
}
