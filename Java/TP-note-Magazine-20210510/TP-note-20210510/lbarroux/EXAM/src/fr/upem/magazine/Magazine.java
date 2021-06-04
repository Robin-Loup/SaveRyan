package fr.upem.magazine;

import java.util.ArrayList;
import java.util.Objects;


public class Magazine implements Eval{
	private final String name;
	private int price;
	ArrayList<Eval> evals=new ArrayList<Eval>();
	
	public Magazine(String name,int price) {
		Objects.requireNonNull(name);
		this.name=name;
		if(price<0)
			throw new IllegalArgumentException("The price can't be lower than 0");
		this.price=price;
	}
	
	@Override
	public String toString() {
		return this.name+" magazine at "+this.price+"€";
	}
	
	protected String name() {
		return this.name;
	}
	
	public int price() {
		return this.price;
	}
	
	public void price(int price) {
		this.price=price;
	}
	
	public boolean contains(Magazine mag) {
		System.out.println("ababou");
		return this.name.equals(mag.name);
	}

	public void addEval(StarEval eval) {
		this.evals.add(eval);		
	}
	
	public void addEval(LikeEval eval) {
		this.evals.add(eval);		
	}
	

	public int averageScore() {
		if(evals.isEmpty()) return 0;
		int avg=0;
		for(int i=0;i<evals.size();i++) {
//			avg+=(evals.get(i)).score();
		}
		return avg/evals.size();
	}
	
	
	public String lastFiveEvals() {
		var sBuild=new StringBuilder();
		sBuild.append("[");
		if(evals.size()<5){
			for(int i=0;i<evals.size();i++)
				sBuild.append(evals.get(i)).append(", ");
		}else {
			for(int i=0;i<5;i++)
				sBuild.append(evals.get(i)).append(", ");
		}
		return sBuild.append("]").toString();
	}
}
