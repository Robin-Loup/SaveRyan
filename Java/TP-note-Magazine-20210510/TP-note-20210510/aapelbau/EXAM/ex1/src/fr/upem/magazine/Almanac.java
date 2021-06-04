package fr.upem.magazine;

public class Almanac extends Magazine{
	private final int year;

	public Almanac(String name, int price, int year) {
		super(name, price);
		this.year = year;
	}
	
	@Override
	public String toString() {
		return this.name() + " almanac of " + this.year + " at " + this.price() + "€";
	}
	
	@Override
	public boolean equals(Object obj) {
		Almanac other = (Almanac) obj;
		return super.equals(obj) && (this.year == other.year);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + year;
		return result;
	}
	
}
