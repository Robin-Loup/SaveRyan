package fr.upem;

public class StarEval implements Eval {
	 private final int stars; 
	 public String comment;
	
	public StarEval(int stars,String comment) {
	       if(stars >= 0 && stars <=5) {
	    	   this.stars = stars;
	    	   this.comment = comment;
	       }
	       else {
	    	   throw new IllegalArgumentException("stars must be between 0 and 5 ");
	       }
		
	}
	public int getStars() {
		return stars;
	}
	public float  score() {
		return (stars*20)-50;
	}
	@Override
	public String toString() {
		var nsb = new StringBuilder("");
		for (int i = 0; i < stars; i++) {
			nsb.append("*");
			
		}
		nsb.append(" ").append(comment);
		return nsb.toString();
	}

}
