package magazine;

public class LikeEval implements Eval {
	private boolean bool;
	
	public LikeEval(boolean b) {
		this.bool=b;
	}

	@Override
	public int score() {
		return this.bool ? 50 : -50;
	}
	
	@Override
	public String toString() {
		return this.bool ? "\uD83D\uDC4D" : "\uD83D\uDC4E";
	}

}
