package fr.upem.magazine;

import java.util.Objects;

public class LikeEval implements Eval{
	
	private final boolean like;
	
	public LikeEval(boolean like) {
		this.like=Objects.requireNonNull(like);
	}
	
	@Override
	public String toString() {
	
		return this.like ? "\uD83D\uDC4D" :"\uD83D\uDC4E"; 
	}
	
	@Override
	public int score() {
		// TODO Auto-generated method stub
		return this.like? 50: -50;
	}
}
