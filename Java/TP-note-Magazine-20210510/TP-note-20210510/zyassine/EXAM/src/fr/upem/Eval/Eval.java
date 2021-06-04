package fr.upem.Eval;

public interface Eval {
	default int score() {
		return 0;
	}
	/* 
	 * Sachant que nous allons recorder pour chaques méthodes d'évaluations, 
	 * il est utile de mettre en place une interface qui sert juste à dire que
	 * tel méthode est utilisable pour les class qui implementent l'interface.
	*/
}
