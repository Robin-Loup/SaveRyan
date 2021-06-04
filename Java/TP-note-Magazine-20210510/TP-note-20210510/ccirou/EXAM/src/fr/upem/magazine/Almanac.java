package fr.upem.magazine;

public class Almanac extends Magazine{
	private final int year;
	/**
	 * @param name
	 * @param price
	 * @param annee
	 */
	public Almanac(String name, int price, int year) {
		super(name, price);
		this.year = year;
		if(year<1900) {
			throw new IllegalArgumentException("year is than 1900");
		}
	}
	@Override
	public String toString() {
		return name()+" almanac of "+year()+" at "+price()+"€";
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + year+((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Almanac)) {
			return false;
		}
		Almanac almanac = (Almanac)obj;
		return name().equals(almanac.name()) && year==almanac.year();
	}
	/**
	 * @return the year
	 */
	public int year() {
		return year;
	}
	
}
