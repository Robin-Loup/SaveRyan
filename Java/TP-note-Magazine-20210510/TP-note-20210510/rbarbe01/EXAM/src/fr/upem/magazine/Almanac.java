package fr.upem.magazine;

public class Almanac extends Magazine {
	private final int year;

	public Almanac(String name, int price, int year) {
		super(name, price);
		if (year < 1900) {
			throw new IllegalArgumentException("Invalid year");
		}
		this.year = year;
	}
	
	@Override
	public String toString() {
		return super.name() + " almanac of " + this.year + " at " + super.price() + " €";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Almanac) {
			Almanac almanac = (Almanac) obj;
			return super.equals(almanac) && this.year == almanac.year;
		}
		return false;
	}
}
