package fr.upem.magazine;

import java.util.Objects;

public class Almanac extends Magazine {
	private final int year;
	
	public Almanac(String name, int price, int year) {
		super(name, price);
		Objects.requireNonNull(year);
		if (year<1900) {
			throw new IllegalArgumentException("L'année de parution est invalide.");
		}
		this.year = year;
	}
	
	@Override
	public String toString() {
		return name() + " almanac of " + this.year + " at " + price() + "€";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Almanac)) {
			return false;
		}
		Almanac o = (Almanac) obj;
		return super.equals(obj) && this.year == o.year;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode() ^ Objects.hash(year);
	}
	
	@Override
	boolean alwaysTrendy() {
		return true;
	}
}
