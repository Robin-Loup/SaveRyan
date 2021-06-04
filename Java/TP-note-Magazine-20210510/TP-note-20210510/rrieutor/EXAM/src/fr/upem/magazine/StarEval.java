package fr.upem.magazine;

public class StarEval implements Eval {
	final private int note;
	final private String commentaire;
	
	public StarEval(int note, String com) {
		this.note = note;
		this.commentaire = com;
	}
	@Override
	public int score() {
		return (note * 20) - 50;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < note; i++) {
			str.append('*');
		}
		str.append(' ').append(commentaire);
		return str.toString();
	}

}
