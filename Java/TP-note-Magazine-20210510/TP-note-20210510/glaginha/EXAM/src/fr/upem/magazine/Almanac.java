package fr.upem.magazine;

public class Almanac extends Magazine {
	private final int year;

	public Almanac(String name, int price, int year) {
		super(name, price);
		if(year <1990) {
			throw new IllegalArgumentException();
		}
		this.year = year;
	}

	@Override
	String preToString() {
		return " almanach of " + year;
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
		if(!(obj instanceof Almanac)) {
			return false;
		}
		Almanac a = (Almanac) obj;
		return super.equals(obj) && this.year == a.year;
	}

	@Override
	public boolean ismode() {
		return true;
	}
	
	
	
}
