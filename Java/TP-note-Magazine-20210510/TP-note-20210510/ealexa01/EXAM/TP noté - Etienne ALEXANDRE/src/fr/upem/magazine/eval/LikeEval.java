package fr.upem.magazine.eval;

import java.util.Objects;

public class LikeEval implements Eval {
	private final boolean like;
	
	public LikeEval(boolean like) {
		Objects.requireNonNull(like);
		this.like = like;
	}
	
	@Override
	public int score() {
		return like ? 50 : -50;
	}
	
	@Override
	public String toString() {
		return like ? "\uD83D\uDC4D" : "\uD83D\uDC4E";
	}

}
