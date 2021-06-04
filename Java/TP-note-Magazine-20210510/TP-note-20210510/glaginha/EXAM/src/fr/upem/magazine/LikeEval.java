package fr.upem.magazine;

public class LikeEval implements Eval {
	private boolean up;
	
	public LikeEval(boolean up) {
		this.up = up;
	}

	@Override
	public int score() {
		if(up) {
			return 50;
		}
		return -50;
	}

	@Override
	public String toString() {
		if(up) {
			return "\uD83D\uDC4D";
		}
		return "\uD83D\uDC4E";
	}

	
}
