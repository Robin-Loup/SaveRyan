package fr.upem.magazine;

public interface Eval {
	public int score();
}

/*
 * Utiliser Eval comme une Interface plutôt qu'une Class est avantageu car chaque type d'évaluation est différent et donc chauqe score sera calculer différemment.
 * Faire une interface va donc permettre d'éviter la duplication de code.
 */