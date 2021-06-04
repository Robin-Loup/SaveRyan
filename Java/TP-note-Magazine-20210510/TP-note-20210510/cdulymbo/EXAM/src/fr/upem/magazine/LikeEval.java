package fr.upem.magazine;

import java.util.Objects;

public class LikeEval implements Eval {

	private final boolean isGood;



	public LikeEval(boolean isGood) {
		this.isGood = Objects.requireNonNull(isGood);
	}

	@Override
	public String toString() {
		if (this.isGood)
			return "\uD83D\uDC4D";
		else
			return "\uD83D\uDC4E";
	}


	@Override
	public int score() {
		if (this.isGood)
			return 50;
		else
			return -50;
	}

}
