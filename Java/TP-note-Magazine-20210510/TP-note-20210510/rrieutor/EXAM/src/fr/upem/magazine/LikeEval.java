package fr.upem.magazine;

public class LikeEval implements Eval {
	final private boolean avis;
	
	public LikeEval(boolean avis) {
		this.avis = avis;
	}
	
	@Override
	public int score() {
		if (avis)
			return 50;
		else
			return -50;
	}
	@Override
	public String toString() {
		if (avis)
			return "\uD83D\uDC4D";
		else
			return "\uD83D\uDC4E";
	}
}
