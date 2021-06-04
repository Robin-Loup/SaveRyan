package fr.upem.magazine;

/*
 *  Cet objet ne peut pas être une classe abstraite ou une classe car il n'y a aucunnes propriétés 
 *  communes entre les évaluations. Par exemple dans l'objet startEval, 
 *  il y a un entier et un string alors que dans l'objet likeEval, *  il y a juste un booléen.
 *  	
 *  On cosntate qu'entre les différentes types d'évaluations, la seule chose qui est en commun est la méthode
 *  score.
 *  
 *  Une interface est un contrat. Ainsi quand une classe implémente une interface. La classe doit avoir 
 *  les méthodes  contenues dans l'interface.
 *  Donc il faut utiliser une interface comme super-type pour les différentes évaluations.
 */
public interface Eval {
	public int score();	
}
