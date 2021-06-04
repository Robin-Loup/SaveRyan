package fr.upem.magazine;

import java.util.Objects;

/**
 * Almanac
 * 
 * An Almanac is like a Magazine but with a year
 * Also it is always trendier than a Magazine
 * 
 */
public class Almanac extends Magazine {
	private final int year;

	public Almanac(String name, int price, int year) {
		super(name, price);
		if (year < 1900) {
			throw new IllegalArgumentException("Year must be superior or equal to 1900");
		}

		this.year = year;
	}

	@Override
	protected String displayType() {
		return " almanac of " + year;
	}
	
	/**
	 * An almanac is always trendier than a magazine
	 * If it's compared to an other almanac, then it is also trendier, don't ask me why
	 * 
	 * @return true
	 * 
	 */
	@Override
	public boolean isMoreTrendy(Magazine mag) {
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(year);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Almanac))
			return false;
		Almanac other = (Almanac) obj;
		return year == other.year;
	}

	

}
