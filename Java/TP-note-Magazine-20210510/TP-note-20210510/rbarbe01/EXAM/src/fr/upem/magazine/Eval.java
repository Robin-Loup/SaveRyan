package fr.upem.magazine;

public interface Eval {
	int score();
	/*
	 * Il faut que ce soit une interface et non une classe ou une classe abstraite
	 * car "StarEval" et "LikeEval" vont tous deux utiliser les méthodes de
	 * l'interface et car on voudra avoir la possibilité d'instancier "Eval" pour
	 * par exemple faire des listes d'évaluations ou pour donner des évaluations (ce
	 * qui ne sera pas possible avec une classe abstraite car on ne pourra pas
	 * l'instancier)
	 */
}
