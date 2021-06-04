package fr.upem.magazine;

public class LikeEval implements Eval{
	private final boolean like;
	public LikeEval(boolean like) {
		this.like = like;
	}

	
	
	public int score() {
	int score;
	if(like) {
		score = 50;
	}
	else {
		score = -50;
	}
		return score;
	}

	@Override
	public String toString() {
		if(this.score()==50) {
			return "\uD83D\uDC4D";
		}
		else {
			return "\uD83D\uDC4E";
		}
	}

	

	
}
