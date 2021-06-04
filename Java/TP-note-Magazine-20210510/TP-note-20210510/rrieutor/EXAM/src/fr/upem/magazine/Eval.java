package fr.upem.magazine;

public interface Eval {
	public int score();
	/*toute les évaluations seront soit de StarsEval soit de LikeEval
	 * qui sont tous les deux des Eval mais pas que.
	 * On ne veut pas avoir d'objet qui soit un Eval
	 */

}
