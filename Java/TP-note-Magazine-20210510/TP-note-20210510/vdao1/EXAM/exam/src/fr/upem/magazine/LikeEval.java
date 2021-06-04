package fr.upem.magazine;

import java.util.Objects;

public class LikeEval implements Eval{
	public int score;
	public int score() {
		return this.score;
	}
	
	@Override
	public String toString() {
		if(this.score==50) return "\uD83D\uDC4D";
		else return "\uD83D\uDC4E)";
	}

	public LikeEval(boolean b) {
		// TODO Auto-generated constructor stub
		Objects.requireNonNull(b);
		if(b==true) this.score=50;
		else this.score=-50;
	}
}
