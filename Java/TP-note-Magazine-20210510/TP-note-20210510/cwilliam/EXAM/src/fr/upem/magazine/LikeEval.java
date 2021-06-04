package fr.upem.magazine;

import java.util.Objects;

public class LikeEval implements Eval {
	private boolean like;
	
	public LikeEval(boolean like) {
		Objects.requireNonNull(like);
		this.like = like;
	}
	
	@Override
	public String toString() {
		if(like) {
			return "\uD83D\uDC4D";
		}
		return "\uD83D\uDC4E";
	}
	public int score() {
		if(like) {
			return 50;
		}
		return -50;
	}
}
