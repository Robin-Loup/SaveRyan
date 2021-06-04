package fr.upem.magazine.eval;

/* Il est nécessaire que Eval soit une Interface car on ne sait pas créer un objet de type "Eval".
 * Utiliser une classe abstraite n'a pas beaucoup de sens, étant donné que l'on ne peut pas réunir de champs
 * ou factoriser du code dans des méthodes spécifiques puisque l'utilisation des Eval peut être très large.
 * En effet, il peut exister plein de sous-types très différent de Eval.
 */
public interface Eval {
	int score();
}
