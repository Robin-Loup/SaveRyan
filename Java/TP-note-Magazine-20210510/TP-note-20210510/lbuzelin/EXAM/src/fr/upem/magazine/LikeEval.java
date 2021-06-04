package fr.upem.magazine;

/**
 * LikeEval, Implementation of the Eval interface
 * 
 * @author lbuzelin
 */
public class LikeEval implements Eval{
	
	private boolean evaluation;
	
	public LikeEval(boolean evaluation) {
		this.evaluation = evaluation;
	}

	@Override
	public int score() {
		return this.evaluation==true ? 50 : -50;
	}

	@Override
	public String toString() {
		return this.evaluation==true ? "\uD83D\uDC4D" : "\uD83D\uDC4E";
	}
}
