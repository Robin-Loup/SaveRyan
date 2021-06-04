package fr.upem.magazine;
import java.util.Objects;

/*
 * Eval doit etre une interface afin de pouvoir stocker
 * dans la même liste de nombreux types/classes d'Evalutaion
 * (Star/Like,...). 
 */

public interface Eval {
	
	public class StarEval implements Eval{
		private final int stars;
		private final String comment;
		
		public StarEval(int stars,String comment) {
			Objects.requireNonNull(comment);
			this.comment=comment;
			if(stars<0 || stars>5)
				throw new IllegalArgumentException("The numbers of stars must be between 0 and 5");
			this.stars=stars;
		}
		
		@Override
		public String toString() {
			var sBuild=new StringBuilder();
			for(int i=0;i<this.stars;i++)
				sBuild.append('*');
			return sBuild.toString()+" "+this.comment;
		}
		
		public int score() {
			return (this.stars*20)-50;
		}
	}
	
	public class LikeEval implements Eval{
		private final boolean like;
		
		public LikeEval(boolean like) {
			this.like=like;
		}
		
		@Override
		public String toString() {
			if(this.like)
				return "\uD83D\uDC4D";
			else
				return "\uD83D\uDC4E";
		}
		
		public int score() {
			if(this.like)
				return 50;
			else
				return-50;
		}
	}
}

