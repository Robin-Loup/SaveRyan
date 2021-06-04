package fr.upem.magazine;

/**
 * StarEval, Implementation of the Eval interface
 * 
 * @author lbuzelin
 */
public class StarEval implements Eval {
	
	private int numberOfStars;
	private String commentary;
	
	public StarEval(int numberOfStars, String commentary) {
		assert(numberOfStars>=0);
		assert(numberOfStars<=5);
		
		this.numberOfStars = numberOfStars;
		this.commentary = commentary;
	}

	@Override
	public int score() {
		return this.numberOfStars * 20 - 50;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int  i = 0; i < numberOfStars; i++) {
			sb.append('*');
		}
		return sb.append(' ').append(this.commentary).toString();
	}
}
