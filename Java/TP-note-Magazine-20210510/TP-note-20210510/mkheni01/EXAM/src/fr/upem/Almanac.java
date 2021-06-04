package fr.upem;

public class Almanac extends Magazine{
	final private int year ; 
	public Almanac(String nom, int price, int year) {
		super(nom, price);
		if(year < 1900) {
			throw new IllegalArgumentException("you can't put a year less than 1900");
		}
		this.year = year;
	}
	public int year() {
		return year;
	}
	@Override
	public String toString() {
	    
		return super.nom + " almanac " +" of " + year+" at " + super.price() + " € "; 
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Almanac) {
			
			if(((Almanac) obj).nom == nom && ((Almanac) obj).year() == year  ) {
				return true;
			}
		}
		
		return false;
	}
	
	

}
