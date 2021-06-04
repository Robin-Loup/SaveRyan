package fr.upem.magazine;


/* On ne veux pas instancier d'Eval, on ne peut donc pas en faire une 
 * classe classique. Cependant, mais on veux pouvoir avoir une liste d'Eval 
 * dont Eval ne peux pas être une classe abstraite 
 */
public interface Eval {
	public int score();
}
