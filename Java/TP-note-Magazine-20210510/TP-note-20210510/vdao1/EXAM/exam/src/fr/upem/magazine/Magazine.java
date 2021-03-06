package fr.upem.magazine;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Magazine {
	private final String name;
	private int price;
	private ArrayList <Eval> evals=new ArrayList<Eval>();
	public Magazine(String name,int price) {
		// TODO Auto-generated constructor stub
		Objects.requireNonNull(name);
		this.name=name;
		this.price(price);
	}
	public int price() {
		return this.price;
	}
	public void price(int price) {
		if(price<0)throw new IllegalArgumentException("Price cannot be negative.");
		this.price=price;
	}
	@Override
	public String toString() {
		return this.name+ " magazine at "+ this.price()+"€" ;
	}
	@Override
	public boolean equals(Object m2) {
		if(!(m2 instanceof Magazine)) return false;
		Magazine m=(Magazine) m2;
		return(this.name==m.name);
	}
	String name() {
		return this.name;
	}
	public boolean equals(Object a, Object b) {
		// TODO Auto-generated method stub
		Magazine m1=(Magazine) a;
		Magazine m2=(Magazine) b;
		return m1.equals(m2);
	}
	@Override
	public int hashCode() {
		return this.name().length();
	}
	public void addEval(Eval e) {
		evals.add(e);
	}
	public double averageScore() {
		double sum=0;
		int i=0;
			for(Eval e : evals) {
				sum+=e.score();
				i++;
			}
		return sum/i;
	}
	public List<Eval> lastFiveEvals() {
		int a=this.evals.size()-5;
		if(a<0)a=0;
		return this.evals.subList(a, this.evals.size());
	}
	public Eval worstEval() {
		Eval e = null;
		for(Eval a : this.evals) {
			if(e==null) {
				if(a.score()<50) e=a;
			}
			else if(a.score()<e.score()) e=a;
		}
		return e;
	}
	public boolean isMoreTrendy(Magazine m2) {
		if(m2.getClass()!= Magazine.class) return false;
		return this.averageScore()>m2.averageScore();
	}
	
	
}
