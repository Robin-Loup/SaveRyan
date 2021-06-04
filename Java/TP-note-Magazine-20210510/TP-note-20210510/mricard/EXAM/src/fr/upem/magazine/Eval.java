package fr.upem.magazine;

public interface Eval{

	public int score();
}
// Ici on choisir de créer une interface au lieu d'une classe où d'une classe abstraite
// car on va avoir les deux sous types StarEval et LikeEval. De ce fait on veut pas pouvoir
// initialiser d'objet Eval, et on veut aussi pouvoir l'implémenter dans nos classes.
