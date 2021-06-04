package fr.upem.magazine;

import java.util.Objects;

public class StarEval implements Eval {
	private final int nbStar;
	private final String commentaire;
	
	public StarEval(int nbStar, String commentaire) {
		super();
		if (nbStar < 0 || nbStar > 5)
			throw new IllegalArgumentException("score between 0 and 5 include");
		this.nbStar = nbStar;
		if (Objects.requireNonNull(commentaire).length() < 1)
			throw new IllegalArgumentException("Commentaire mustn't be empty");
		this.commentaire = commentaire;
	}
	
	public int score() {
		return nbStar * 20 - 50;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < nbStar; i++)
			str.append("*");
		str.append(" ").append(commentaire);
		return str.toString();
	}
}
