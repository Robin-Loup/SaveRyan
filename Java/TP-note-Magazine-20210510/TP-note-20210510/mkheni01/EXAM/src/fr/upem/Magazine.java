package fr.upem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;



public class Magazine {
	protected final String nom;
	private int price;
	//private ArrayList<Eval> list;
	private LinkedList<Eval> list;
	public Magazine(String nom,int price) {
		 this.nom = Objects.requireNonNull(nom); 
		 this.price = Objects.requireNonNull(price); 
		 this.list = new LinkedList<Eval>() ;
		
	}
	public void  addEval(Eval e) {
		this.list.add(e);
	}
	public int averageScore() {
		if(list.isEmpty()) {
			return 0;
		}
		int sum = 0;
		for (Eval eval : list) {
			sum += eval.score();
		}
		return sum/list.size();
		
	}
	public LinkedList<Eval>  lastFiveEvals() {
		var l = new LinkedList<Eval>();
		
		if(list.size()< 5){
			for (int i = list.size()-1; i >= 0; i--) {
				l.add(list.get(i));
			}
			return l;
			
		}
		
		
		for (int i = list.size()-1; i >= 1; i--) {
			l.add(list.get(i));
		}
		return l;
		
	}
	public int price() {
		return price;
	}
	public void price(int prix) {
		this.price = prix;
	}
	public  Eval worstEval() {
		if(list.isEmpty()) {
			return null;
		}
		Eval worst = list.getFirst();
		
		System.out.println(worst.score());
		for (Eval eval : list) {
			if(worst.score() > eval.score()) {
				worst = eval;
			}
			
		}
		return worst;
	}
	@Override
	public String toString() {
		
		return this.nom + " at " + price + " € ";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Magazine) {
			
			if(((Magazine) obj).nom == nom) {
				return true;
			}
		}
		
		return false;
	}
	public boolean isMoreTrendy(Magazine m  )
	{
		if(m.getClass().isInstance(this)) {
			if(m.averageScore() < this.averageScore()) {
				return true ;
			}
			
		}
		return false;
		}
		

}
