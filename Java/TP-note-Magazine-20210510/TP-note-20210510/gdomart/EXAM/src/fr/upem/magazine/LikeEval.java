package fr.upem.magazine;

public class LikeEval implements Eval{
	
	private boolean note;

	public LikeEval(boolean note) {
		this.note = note;
	}
	
	public int score() {
		if(note == true)
			return 50;
		return -50;
	}

	@Override
	public String toString() {
		if(note == true)
			return "\uD83D\uDC4D";
		return "\uD83D\uDC4E";
	}
	
	
	
	
}
