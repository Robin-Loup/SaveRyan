package fr.upem.magazine;

import java.util.Objects;

public class Almanac extends Magazine{
	
	private final int year;
	
	public Almanac(String name,int price,int year) {
		super(name,price);
		Objects.requireNonNull(year);
		if(year<1900) {
			throw new IllegalArgumentException("the year has to be after 1900");
		}
		this.year=year;
	}
	
	@Override
	String type() {
		return "almanac of "+this.year;
	}
	
	@Override
	boolean isCantTrendy() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!super.equals(obj)) {
			return false;
		}
		Almanac al = (Almanac)obj;
		return this.year==al.year;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode() + Objects.hash(year);
	}
	
	
}
