package fr.upem.magazine;

/**
 * Eval Interface including the method score()
 * 
 * @author lbuzelin
 */
public interface Eval {
	
	/**
	 * 	Return the score of the evaluation
	 * 
	 * @return
	 * 			{@link Integer} 
	 */
	public int score();
	
	
	
	/*
	 * There's multiple types of Evaluation, we don't at first what's gonna be the parameters and how they will
	 * be implement.
	 * The easiest way to deal with all the cases possible is to use an interface including the method we
	 * want the user to have access whatever the type of evaluation it is.
	 */
}
