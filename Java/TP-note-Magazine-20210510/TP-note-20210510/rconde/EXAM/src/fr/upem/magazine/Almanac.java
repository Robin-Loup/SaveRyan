package fr.upem.magazine;

public class Almanac extends Magazine{
	private final int parution;
	public Almanac(String name, int price, int parution) {
		super(name, price);
		if(parution>=1900) {
			this.parution = parution;
		}
		else {
			throw new IllegalArgumentException("Parution is lower than 1900");
		}
	}
	
	@Override
	String nameClass() {
		return "almanac";
	}
	
	@Override
	public int hashCode() {
		return this.name().hashCode() ^ this.parution;
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Almanac)) {
			return false;
		}
		Almanac magazine = (Almanac) o;
		
		return this.name().equals(magazine.name()) && this.parution == magazine.parution;
		
	}

	

}
