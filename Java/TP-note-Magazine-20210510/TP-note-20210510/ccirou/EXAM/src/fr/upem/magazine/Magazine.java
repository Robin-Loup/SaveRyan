package fr.upem.magazine;

import java.util.ArrayList;
import java.util.Objects;

public class Magazine {
	protected final String name;
	private int price;
	private ArrayList<Eval> evalist = new ArrayList<Eval>();
	/**
	 * @param name
	 * @param price
	 */
	public Magazine(String name, int price) {
		//super();
		this.name = Objects.requireNonNull(name);
		this.price = price;
		if(price<0) {
			throw new IllegalArgumentException("price is lower than 0");
		}
	}
	
	@Override
	public String toString() {
		return name()+" magazine at "+price()+"€";
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
		Magazine magazine = (Magazine)obj;
		return name.equals(magazine.name);
	}
	/**
	 * @return the price
	 */
	public int price() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void price(int price) {
		this.price = price;
	}
	/**
	 * @return the name
	 */
	public String name() {
		return name;
	}
	public void addEval(Eval eval) {
		evalist.add(eval);
	}
	public double averageScore() {
		if(evalist.isEmpty() ) {
			return 0;
		}
		double total=0;
		int counter=0;		
		for(var eval:evalist) {
			total+=eval.score();
			counter++;
		}
		return total/counter;
	}
	public String lastFiveEvals() {
		if(evalist.size()<=5) {
			var fivelast = new StringBuilder("[");
			for(var eval:evalist) {
				fivelast.append(eval).append(", ");
			}
			fivelast.append("]");
			return fivelast.toString();
		}
		else {
			int counter=1;
			int size= evalist.size();
			
				var fivelast = new StringBuilder("[");
				for(var eval:evalist) {
					if(size-counter<=5) {
						fivelast.append(eval).append(", ");
					}
					counter++;
				}
				fivelast.append("]");
				return fivelast.toString();
		}
		
	}
	public Eval worstEval(){
		Eval worst=null;
		for(var eval:evalist) {
			if(worst==null) {
				worst=eval;
			}
			else {
				if(eval.score()>worst.score()) {
					worst=eval;
				}
			}
		}
		return worst;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
