package fr.upem.magazine;

public interface Eval {
	
	int score();
}
// Une classe abstraite est efficace lorsqu'on veut factoriser du code entre 2 classe semblable
// ici on veut juste deux sous classe pour les utiliser de la meme façon plus tard et qui ont des methodes qui se differencie 
// donc l'interface est la meilleurs alternative pour ce q'uon veut faie
