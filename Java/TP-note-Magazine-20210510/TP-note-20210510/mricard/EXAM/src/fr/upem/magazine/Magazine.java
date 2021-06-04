package fr.upem.magazine;

import java.util.ArrayList;

public class Magazine {
	private final String name;
	private int price;
	private ArrayList<Eval> evals = new ArrayList(5);

	//Programmation défensive pas possible avec des if,et je ne me souviens plus de 
	//la méthode qui empêche les attributs de classe d'être initialisés à null
	public Magazine(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public String magazine() {
		return this.name;
	}
	
	public String name() {
		return this.name;
	}
	
	public int price() {
		return this.price;
	}
	
	public void price(int price) {
		this.price = price;
	}
	
	public String toString() {
		return this.name +" magazine at "+ price+"€";
		
	}
	
	public boolean Equals(Object obj) {
		var m = (Magazine) obj;
		System.out.println("magazine 1: " + this + ", magazine 2: "+ m);
		if(obj == null) {
			return false;
		}
		else if( obj != this.getClass()) {
			return false;
		}
		boolean res = false;
		
		if(this.name == m.name) {
			res = true;
			}
		return res;
	}
	
	public void addEval(Eval e) {
		if(e != null && evals.size() != 5) {
		this.evals.add(e);
		}
		
	}
	
	public double averageScore() {
		int sum = 0;
		if(evals.isEmpty()) {
			return 0;
		}
		for(int i = 0; i < evals.size(); i++) {
			sum += evals.get(i).score();
		}
		return sum/evals.size();
	}
	
	public String lastFiveEvals() {
		StringBuilder strb = new StringBuilder();
		strb.append("[");
		/*for(Eval e: evals) {
			strb.append(e);
			strb.append(", ");
		}
		strb.append(" ]");
		return strb.toString();*/
		if(evals.size() >= 1) {
		for(int i = 0; i < evals.size()-1; i++) {
			strb.append(evals.get(i));
			strb.append(", ");
			}
		}
		if(!evals.isEmpty()) {
		strb.append(evals.get(evals.size()-1));
		}
		strb.append(" ]");
		
		return strb.toString();
	}	
	
}


