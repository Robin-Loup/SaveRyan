package fr.upem.magazine;

public class Almanac extends Magazine {
	private final int year;

	public Almanac(String name, int price, int year) {
		super(name, price);
		if (year < 1900)
			throw new IllegalArgumentException("year < 1900");
		this.year = year;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Almanac other = (Almanac) obj;
		if (year != other.year)
			return false;
		return true;
	}
	
	@Override
	String linkBetweenNameAndPrice() {
		return " almanac of " + year + " at ";
	}
}
