package fr.umlv;

import java.util.HashMap;

public class Basket {
	final private HashMap<Fruit, Integer> panier;
	
	public Basket() {
		panier = new HashMap<Fruit, Integer>();
	}
	
	public void add(Fruit fruit) {
		panier.put(fruit, panier.getOrDefault(fruit, 0) + 1);
	}
	
	public void add(Fruit fruit, int q) {
		panier.put(fruit, panier.getOrDefault(fruit, 0) + q);
	}
	
	private int price() {
		int prix = 0;
		for(var entry : panier.entrySet()) {
			prix += entry.getKey().price() * entry.getValue();
		}
		return prix;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		panier.forEach((s, q) -> str.append(s).append(" x ").append(q).append('\n'));
		return str.append("price: ").append(price()).toString();
	}
	

}
