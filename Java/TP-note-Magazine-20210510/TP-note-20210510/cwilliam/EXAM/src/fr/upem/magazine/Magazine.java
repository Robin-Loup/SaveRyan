package fr.upem.magazine;

import java.util.ArrayList;
import java.util.Objects;

public class Magazine {
	private final String name;
	private int price;
	private ArrayList<Eval> list;
	
	public Magazine(String name, int price) {
		Objects.requireNonNull(name);
		Objects.requireNonNull(price);
		if(price < 0) {
			throw new IllegalArgumentException("Price doit être toujours positif");
		}
		this.name = name;
		this.price = price;
		this.list = new ArrayList<Eval>();

	}
	
	public int price() {
		return getPrice();
	}
	
	public void price(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return getName() + " at " + getPrice() + "€";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Magazine){
			return true;
		}
		return false;
	}
	
	public boolean contains(Magazine m) {
		if(this.name.equals(m.name)) {
			return true;
		}
		return false;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
	
	public void addEval(Eval e) {
		list.add(e);
	}
	
	public double averageScore() {
 		double s = 0;
 		for(Eval e : list) {
 			s += e.score();
 		}
 		return s/list.size();
	}
	

	
	public Eval worstEval() {
		for(Eval worst : list) {
			if(worst.score() < 1) {
				return worst;
			}
		}
		return null;
	}
	
	
}
