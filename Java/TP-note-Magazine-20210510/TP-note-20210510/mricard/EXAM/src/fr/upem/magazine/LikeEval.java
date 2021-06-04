package fr.upem.magazine;

public class LikeEval implements Eval{
	boolean rating;
	int score;
	
	public LikeEval(boolean rating) {
		this.rating = rating;
		if(rating == true){
			this.score = 50;
		}
		else {
			this.score = -50;
		}
	}
	
	@Override
	public int score() {
		return this.score;
	}
	
	public String toString() {
		String thumb;
		if(rating == true){
			thumb = "👍";
		}
		else {
			thumb = "👎";
		}
		return thumb;
	}
	
}
