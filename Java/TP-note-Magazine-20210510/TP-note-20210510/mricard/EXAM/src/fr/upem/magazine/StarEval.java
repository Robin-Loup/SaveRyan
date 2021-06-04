package fr.upem.magazine;

public class StarEval implements Eval{
	int score;
	String comment;
	
	public StarEval(int score, String comment) {
		this.score = score*20 - 50;
		this.comment = comment;
	}
	
	@Override
	public int score() {
		return this.score;
	}
	
	public String toString() {
		StringBuilder strb = new StringBuilder();
		for(int i = 0; i < (score+50) /20; i++) {
			strb.append('*');
		}
		strb.append(' '+ comment);
		
		return strb.toString();
	}
	
}
