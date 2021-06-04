package fr.upem.magazine;

import java.util.ArrayList;
import java.util.Objects;

public class Magazine {
	final String name;
	private int price;
	private ArrayList<Eval> notes;
	
	public Magazine(String name, int price) {
		this.name = name;
		this.price = price;
		this.notes = new ArrayList<Eval>();
		if (Objects.isNull(name)) {
			throw new IllegalArgumentException("Name is Null");
		}
	}

	public int price() {
		return price;
	}
	
	public void price(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return(name + " magazine at " + price + "€");
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Magazine) {
			Magazine mag = (Magazine) obj;
			return name.equals(mag.name);
		}
		return false;
			
	}
	
	public void addEval(Eval eval) {
		notes.add(eval);
	}
	
	public double averageScore() {
		double scores = 0;
		for (Eval e : notes) {
			scores += e.score();
		}
		if (!notes.isEmpty())
			scores = scores / notes.size();
		return scores;
	}
	
	public String lastFiveEvals() {
		StringBuilder str = new StringBuilder();
		str.append('[');
		for (int i = notes.size()-5; i < notes.size(); i++) {
			if (i < 0)
				i = 0;
			str.append(notes.get(i));
			if (i+1 < notes.size())
				str.append(", ");
		}
		str.append(']');
		return str.toString();
	}
	
	public String worstEval() {
		if (notes.isEmpty())
			return "No comment (null)";
		int min = notes.get(0).score();
		int index = 0;
		for (int i = 1; i < notes.size(); i++) {
			Eval e = notes.get(i);
			if (e.score() < min) {
				min = e.score();
				index = i;
			}
		}
		
		return notes.get(index).toString();
	}
	
	String type() {
		return "Magazine";
	}
	
	public boolean  isMoreTrendy(Magazine mag) {
		if (mag.type().equals("Almanac"))
			return false;
		return averageScore() >= mag.averageScore();
	}
}
