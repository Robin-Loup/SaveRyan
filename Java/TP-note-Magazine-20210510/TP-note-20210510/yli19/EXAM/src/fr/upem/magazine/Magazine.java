package fr.upem.magazine;

import java.util.ArrayList;
import java.util.Objects;

public class Magazine {
	private final String name;
	private int price;
	private ArrayList<Eval> evals;
	
	public Magazine(String name, int price) throws IllegalArgumentException{
		this.name = Objects.requireNonNull(name);
		if(price < 0) {
			throw new IllegalArgumentException("THe price can not be negetive !");
		}
		this.price = price;
		this.evals = new ArrayList<>();
	}
	
	public int price() {
		return price;
	}
	
	 public void price(int price) throws IllegalArgumentException {
		 if(price < 0) {
				throw new IllegalArgumentException("THe price can not be negetive !");
			}
		 this.price = price;
	 }
	 
	 @Override
	 public String toString() {
		 return name + "magazine at " + price +"€";
	 }

	 @Override
	 public boolean equals(Object o) {
		 if(!( o instanceof Magazine ) ) {
			 return false;
		 }
		 var magazine = (Magazine) o;
		 return this.name.equals(magazine.name);
	 }
	 
	 @Override
	 public int hashCode() {
		 return Objects.hash(name);
	 }
	 
	 public String name() {
		 return name;
	 }
	 
	 public void addEval(Eval eval) {
		 evals.add(eval);
	 }
	 
	 public int averageScore() {
		 int sum = 0;
		 for(Eval eval : evals) {
			 sum += eval.score();
			 }
		 return sum/evals.size();
	 }
	 
	 public String lastFiveEvals() {
		 var sb = new StringBuilder();
		 if(evals.size() <= 5) {
			 for(Eval eval : evals) {
				 sb.append(eval.toString()).append(", ");
			 }
		 }
		 else {
			 for(int i = evals.size()-5; i < evals.size(); i++) {
				 sb.append(evals.get(i).toString()).append(", ");
			 }
		 }
		 return sb.toString();
	 }
	 
	 public String worstEval() {
		 if(evals.size() == 0) {
			 return null;
		 }
		 int worestScore = 0 ;
		 var worest  = evals.get(0);
		 for(Eval eval : evals) {
			 if(eval.score() <= worestScore) {
				 worestScore = eval.score();
				 worest = eval;
			 }
		 }
		 return worest.toString();
	 }
	 
	 public boolean isMoreTrendy(Object o) {
		 if(o instanceof Magazine ) {
			 var magazine = (Magazine) o;
			 return magazine.averageScore() >= this.averageScore();
		 }
		 else{
			 return true;
		 }
	 }
}
