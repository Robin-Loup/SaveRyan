package fr.upem.magazine;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Magazine {
	private final String name;
	private int price;
	private ArrayList<Eval> evals;
	
	public Magazine(String name, int price) {
		this.name = Objects.requireNonNull(name);
		if(price <0) {
			throw new IllegalArgumentException("price must be positive");
		}
		this.price = price;
		evals = new ArrayList<>();
	}
	
	public int price() {
		return price;
	}
	
	public void price(int price) {
		if(price <0) {
			throw new IllegalArgumentException("price must be positive");
		}
		this.price = price;
	}

	@Override
	public String toString() {
		return  name + preToString() + " at "+ price +"€";
	}

	String preToString() {
		return " magazine" ;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Magazine)) {
			return false;
		}
		Magazine m = (Magazine) obj;
		return this.name.equals(m.name);
	}
	
	public void addEval(Eval e) {
		evals.add(e);
	}
	
	public double averageScore() {
		int tmp =0;
		for(Eval e : evals) {
			tmp += e.score();
		}
		return (double)tmp/evals.size();
	}
	
	public List<Eval> lastFiveEvals(){
		if(evals.size() ==0) {
			return null;
		}
		int i = evals.size()-5;
		if(i < 0) {
			i=0;
		}
		return evals.subList(i, evals.size());
		
	}
	
	public Eval worstEval() {
		Eval tmp = null;
		int w = 50;
		for(Eval e : evals) {
			if(e.score() < w) {
				tmp = e;
				w = e.score();
			}
		}
		return tmp;
	}
	
	public boolean isMoreTrendy(Magazine m){
		if(m.ismode()) {
			return false;
		}
		else if(this.ismode()) {
			return true;
		}
		return this.averageScore()> m.averageScore();
	}
	public boolean ismode() {
		return false;
	}
}
