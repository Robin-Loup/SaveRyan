package fr.upem.magazine;

public interface Eval {
	int score();
}
/*c'est une interface car on utilise une même panoplie de méthodes mais avec une implantation différente selon le style d'eval
 *Donc vu que les implantations sont différentes, cela ne peut pas être une classe et ce n'est pas une abstract class car les implantations ne sont pas les même pour tout ce qui implante Eval
 */ 
