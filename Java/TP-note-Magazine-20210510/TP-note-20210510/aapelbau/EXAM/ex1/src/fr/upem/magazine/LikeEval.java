package fr.upem.magazine;

public class LikeEval implements Eval{
	private boolean like;
	
	public LikeEval(boolean like) {
		this.like = like;
	}
	

	@Override
	public int score() {
		return like ? 50 : -50;
	}



	public boolean like() {
		return like;
	}



	public void like(boolean like) {
		this.like = like;
	}
	
	@Override
	public String toString() {
		return like ? "\uD83D\uDC4D" : "\uD83D\uDC4E";
	}


}
