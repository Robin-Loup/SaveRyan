package fr.upem.Magazine;

import java.util.Objects;

public class Almanac extends Magazine{
	private final int date;
	
	public Almanac(String name, int price, int date) {
		super(name, price);
		Objects.requireNonNull(date);
		if(date < 1900) {
			throw new IllegalArgumentException("Date doit etre superieur à 1900 !");
		}
		this.date = date;
	}
	
	@Override
	public boolean isMoreTrendy(Magazine m) {
		if(m instanceof Magazine) {
			return true;
		}
		if(averageScore() > m.averageScore()) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return name() + " almanac of " + date + " at " + price() + "€";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Almanac)) {
			return false;
		}
		Almanac a = (Almanac) obj;
		return name().equals(a.name());
	}

}
