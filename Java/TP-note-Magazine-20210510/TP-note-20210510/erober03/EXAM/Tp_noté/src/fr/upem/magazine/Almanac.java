package fr.upem.magazine;

import java.util.Objects;

public class Almanac extends Magazine {
	private final int years;

	public Almanac(String name, int price,int years) {
		super(name, price);
		if (years < 1900) {
			throw new IllegalArgumentException("Almanac's years must be higher then 1900");
		}
		this.years = years;
	}
	
	@Override
	String completeToString() {
		// TODO Auto-generated method stub
		return " almanac of " + years + " at ";
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (!(obj instanceof Almanac)) {
			return false;
		} else {
			Almanac a = (Almanac) obj;
			return a.years == years && super.equals(obj);
		}
	}
	
	@Override
	public int hashCode() {

		return Objects.hash(years)+super.hashCode();
	}
	
	
	@Override
	public boolean isMoreTrendy(Magazine m) {
		if (m.isTrendy() == false) {
			return true;
		}
		return averageScore() >= m.averageScore() ? true : false;
	}
	@Override
	boolean isTrendy() {
		return true;
	}

}
