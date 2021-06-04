package fr.upem.magazine;

public class LikeEval implements Eval {
	private boolean like;
	
	public LikeEval(boolean like){
		this.like = like;
	}
	
	@Override
	public int score() {
		if(like) {
			return 50;
		}
		else {
			return -50;
		}
	}

	@Override
	public String toString() {
		if(like) {
			return "\uD83D\uDC4D";
		}
		else {
			return "\uD83D\uDC4E";
		}
	}
		
}
