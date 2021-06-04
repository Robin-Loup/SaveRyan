package fr.upem.magazine;

public class Almanac extends Magazine{
	private final int year;

	public Almanac(String name, int price, int year) {
		super(name, price);
		
		if(year < 1900)
			throw new IllegalArgumentException("L'année de parution doit être au moins 1900 !");

		this.year = year;
	}

	@Override
	public String toString() {
		return name() + " almanac of " + year + " at " + price() + "€";
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
		super.equals(obj);
		
		Almanac object = (Almanac) obj;
		
		if(year == object.year)
			return true;
		
		return false;
	}
	
	
	
}
