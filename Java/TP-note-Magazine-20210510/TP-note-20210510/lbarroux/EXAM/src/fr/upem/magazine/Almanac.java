package fr.upem.magazine;

public class Almanac extends Magazine implements Eval{
	private final int releaseYear;
	
	public Almanac(String name,int price,int releaseYear) {
		super(name,price);
		if(releaseYear<1900)
			throw new IllegalArgumentException("The date of the release year can't be lower than 1900");
		this.releaseYear=releaseYear;
	}
	
	@Override
	public String toString() {
		return this.name()+" almanac of "+this.releaseYear+" at "+this.price()+"€";
	}
	
	public boolean contains(Magazine mag) {
		return this.name().equals(mag.name());
	}
}
