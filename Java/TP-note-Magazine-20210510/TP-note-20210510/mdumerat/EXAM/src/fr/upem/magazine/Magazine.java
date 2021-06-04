package fr.upem.magazine;

import java.util.ArrayList;
import java.util.Objects;

public class Magazine {
	private final String name;
	private int price;
	private ArrayList<Eval> list;
	
	public Magazine(String name,int price) {
		this.name=Objects.requireNonNull(name);
		if(price < 0) {
			throw new IllegalArgumentException("price can't be negative");
		}
		this.price=price;
		
		list = new ArrayList<Eval>();
	}
	
	public int price() {
		return this.price;
	}
	public void price(int price) {
		if(price<0) {
			throw new IllegalArgumentException("price can't be negative");
		}
		this.price=price;
	}
	
	public void addEval(Eval ev) {
		list.add(ev);
	}
	
	public double averageScore() {
		double result=0;
		for(Eval eval : list) {
			result += eval.score();
		}
		return result/list.size();
	}
	
	public ArrayList<Eval> lastFiveEvals(){
		var size = 5;
		if(list.size()<5) {
			size=list.size();
		}
		ArrayList<Eval> array = new ArrayList<Eval>();
		for(var i=0;i<size;i++) {
			array.add(list.get((size-1)-i));
		}
		return array;
	}
	
	public Eval worstEval() {
		Eval worst = null;
		int score = 50;
		for(Eval ev :list) {
			if(ev.score()<score) {
				score=ev.score();
				worst = ev;
			}
		}
		return worst;
	}
	
	boolean isCantTrendy() {
		return false;
	}
	
	
	public boolean isMoreTrendy(Magazine mg) {
		if(this.getClass()!= mg.getClass()){
			if(mg.isCantTrendy()){
				return false;
			}else {
				return true;
			}
		}
		return (this.averageScore()<mg.averageScore())? false: true;
	}
	
	@Override
	public String toString() {
		return this.name+" "+this.type()+" at "+price+"€";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Magazine)) {
			return false;
		}
		Magazine mag = (Magazine)obj;
		
		return this.name.equals(mag.name);
	}
	@Override
	public int hashCode() {
		return Objects.hash(this.name);
	}
	
	String type() {
		return "magazine";
	}
	
}

