package fr.upem.magazine;

import java.util.Objects;

public class Almanac extends Magazine{
	private final int date;
	public Almanac(String name, int price,int date) {
		super(name, price);
		// TODO Auto-generated constructor stub
		Objects.requireNonNull(date);
		if(date < 1900) {
			throw new IllegalArgumentException("La date de parution ne peut pas être inférieur à 1900");
		}
		this.date = date;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getName() + " almanac of " + date + " at " + getPrice() + " € " ;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Almanac){
			return true;
		}
		return false;
	}
	
	public boolean contains(Almanac m) {
		if(this.date == m.date ) {
			return true;
		}
		return false;
	}
	
}
