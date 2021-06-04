package fr.upem.magazine;

import java.util.Objects;

public class Almanac extends Magazine {
	private final int year;
	public Almanac(String name, int price, int year) {
		super(name, price);
		if(year < 0) throw new IllegalArgumentException();
		this.year = year;
	}
	public int year() {
		return year;
	}
	@Override
	public String toString() {
		return name() +" Almanac of " +this.year() +  " at " + price() +"€";
	}
	@Override
	public int hashCode() {
		return Objects.hash(super.name(),year);
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Magazine)) return false;
		Almanac a = (Almanac) obj;
		return this.name().equals(a.name()) && this.year()== a.year() ;
	}
}
