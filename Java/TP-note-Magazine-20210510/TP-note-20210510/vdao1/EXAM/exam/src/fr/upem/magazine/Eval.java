package fr.upem.magazine;

public interface Eval {
	// Interface et pas classe abstraite car on ne veut pas d'objec Eval
	public default int score() {
		return 0;
	}
}
