package fr.upem.magazine;

public class LikeEval implements Eval {
	private final boolean like;

	public LikeEval(boolean like) {
		this.like = like;
	}

	@Override
	public String toString() {
		if (like) {
			return "\uD83D\uDC4D";
		} else {
			return "\uD83D\uDC4E";
		}
	}

	@Override
	public double score() {
		if (like) {
			return 50;
		} else {
			return -50;
		}
	}

}
