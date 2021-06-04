package fr.upem.magazine;

public class Almanac extends Magazine {
	private final int year;
	public Almanac(String name, int price, int year) {
		super(name,price);
		if(year < 1900) {
			throw new IllegalArgumentException("Year cannot be less than 1900");
		}
		this.year = year;
	}
	@Override
	String getNameClass() {
		return "almanac of " + this.year;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean sup = super.equals(obj);
		Almanac al = (Almanac) obj;
		return sup && this.year == al.year;
	}
	
	
	
}
