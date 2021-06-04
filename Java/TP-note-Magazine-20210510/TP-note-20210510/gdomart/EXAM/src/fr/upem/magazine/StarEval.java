package fr.upem.magazine;

public class StarEval implements Eval{
	private int stars;
	private String comment;
	
	public StarEval(int stars, String comment) {
		
		if(stars > 5 || stars < 0)
			throw new IllegalArgumentException("Le nombre d'étoiles est invalide !");
		
		this.stars = stars;
		this.comment = comment;
	}

	public int score() {
		return (stars * 20) - 50;
	}

	@Override
	public String toString() {
		var text = new StringBuilder();
		for(int i = 0; i < stars; i++)
			text.append("*");
		
		text.append(" " + comment);
		
		return text.toString()	;
	}
	
	
}
