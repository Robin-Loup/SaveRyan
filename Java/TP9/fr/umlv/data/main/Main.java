package fr.umlv.data.main;

import fr.umlv.data.LinkedList;

public class Main {
	public static void main(String[] args) {
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.add(115);
		l.add(200);
		l.add(10);
		System.out.println(l);
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		System.out.println(l2);
		LinkedList<Integer> l3 = new LinkedList<Integer>();
		l3.add(3);
		System.out.println(l3);	
		System.out.println(l.get(1));
		//System.out.println(l.get(4));	
		//System.out.println(l.get(-1));
		
		LinkedList<String> lc = new LinkedList<String>();
		System.out.println(lc);
		lc.add("n");
		System.out.println(lc);
		lc.add("i");
		System.out.println(lc);
		lc.add("b");
		System.out.println(lc);
		lc.add("o");
		System.out.println(lc);
		lc.add("R");
		System.out.println(lc);
		lc.add("Mr");
		lc.add("Rieutord");
		lc.add("Bonjour");
		System.out.println(lc);
		String str = (String) lc.get(2);
		System.out.println(str.length());
		System.out.println(lc.contains("Mr"));
	}
}
/*	Le cast sert pour pouvoir considere lc.get(2) vomme un string et utilisé la methode length de String
 * 	On aime pas car en cas d'erreur on peut demander à considérer comme string un object qui n'en est pas 1 sans qu'on est d'erreur
 */
/*
 * Un type parametré permet de pouvoir d'adapter la classe avec plusieurs typer tout en sachant quel type d'objet y est stock" contrairement à une list d'object
 */
/*	Contains prend un Object plustot que T ou E car cela permet d'utiliser
 *  la methode equal de l'Object
 */
 