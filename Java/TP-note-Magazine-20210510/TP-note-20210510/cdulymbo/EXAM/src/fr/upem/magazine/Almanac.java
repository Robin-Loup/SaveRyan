package fr.upem.magazine;

public class Almanac extends Magazine {
	public final int year;

	public Almanac(String name, int price, int year) {
		super(name, price);

		if (year < 1900)
			throw new IllegalArgumentException();

		this.year = year;
	}

	@Override
	protected String getType() {

		return "almanac";
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Almanac))
			return false;

		Almanac al = (Almanac) obj;

		return super.equals(al) && al.year == this.year;
	}
}
