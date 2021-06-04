package fr.upem.magazine;

public class StarEval implements Eval {
	private int number;
	private String comment;
	
	public StarEval(int number, String comment) throws IllegalArgumentException {
		if(number < 0 || number > 5) {
			throw new IllegalArgumentException("The number can not be negetive");
		}
		this.number = number;
		this.comment = comment;
	}

	@Override
	public int score() {
		return number*20 - 50;
	}
	
	@Override
	public String toString() {
		var sb = new StringBuilder();
		for(int i = 0; i < number; i ++) {
			sb.append("*");
		}
		sb.append(" ").append(comment);
		return sb.toString(); 
	}

}
