package fr.upem.magazine;

public class Almanac extends Magazine{
	final private int year;
	
	public Almanac(String name, int price, int year) {
		super(name, price);
		if (year < 1900)
			throw new IllegalArgumentException(year + " < 1900");
		this.year = year;
	}
	
	@Override
	public String toString() {
		return name + " almanac of " + year + " at " + price() + "€";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Almanac) {
			Almanac al = (Almanac) obj;
			return name.equals(al.name) && al.year == year;
		}
		return false;
			
	}
	
	@Override
	String type() {
		return "Almanac";
	}
	
	@Override
	public boolean  isMoreTrendy(Magazine mag) {
		if (mag.type().equals("Magazine"))
			return true;
		return averageScore() >= mag.averageScore();
	}
}
