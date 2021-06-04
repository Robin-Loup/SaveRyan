package fr.upem.magazine;

public class LikeEval implements Eval{
	private boolean like;
	/**
	 * @param like
	 */
	public LikeEval(boolean like) {
		this.like = like;
	}
	@Override
	public String toString() {
		if(like()) {
			return "\uD83D\uDC4D";
		}
		else {
			return "\uD83D\uDC4E";
		}
	}
	
	/**
	 * @return the like
	 */
	public boolean like() {
		return like;
	}
	public int score() {
		if(like()) {
			return 50;
		}
		else{
			return -50;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
