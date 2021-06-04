package fr.upem.magazine;

/*
 * Eval is a non-default option that can be add
 * to any class in order to provide a score to  the
 * given object it represents.
 * It is not meant be to be a default feature rather
 * an optional one, that is why this an interface and
 * should only be implemented when needed.
 */

public interface Eval {
	int score();
}
