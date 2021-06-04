package fr.upem.magazine;

import java.util.Objects;

public class Almanac extends Magazine{
	private final int year;
	
	public Almanac(String name, int price, int year) {
		super(name,price);
		this.year = year;
	}
	
//	@Override
//	public String type() {
//		return super.type() + " of ";
//	}
	
	@Override
	public String toString() {
		return super.name() + " almanac of " + year + " at " + price() + "€";
	}
	
	@Override
	public boolean equals(Object o) {
		 if(!( o instanceof Almanac ) ) {
			 return false;
		 }
		 var almanac = (Almanac) o;
//		 System.out.println("name: "+name().equals(almanac.name()));
		 return name().equals(almanac.name()) && (year == almanac.year) ;
	}
	
	 @Override
	 public int hashCode() {
		 return Objects.hash(name());
	 }
	
}
