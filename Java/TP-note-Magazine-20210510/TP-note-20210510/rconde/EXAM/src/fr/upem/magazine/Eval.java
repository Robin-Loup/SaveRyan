package fr.upem.magazine;
/*5.On veut utiliser une interface car on peut l'étendre à plusieurs classes*/

public interface Eval {
	default int score() {
		return 0;
	}
}
