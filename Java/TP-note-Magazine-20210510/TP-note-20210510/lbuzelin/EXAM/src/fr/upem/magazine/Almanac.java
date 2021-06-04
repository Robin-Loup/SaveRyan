package fr.upem.magazine;

/**
 * Almanac class, subtype of Magazine
 * 
 * @author lbuzelin
 */
public class Almanac extends Magazine{
	
	private final int parutionYear;
	
	public Almanac(String name, int price, int year) {
		super(name,price);
		
		assert(year>=1900);
		this.parutionYear = year;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	@Override
	String almanacInfo() {
		return " almanac of " + this.parutionYear;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(this.getClass() != obj.getClass()) {
			return false;
		}
		
		Almanac almanac = (Almanac) obj;
		return super.equals(obj) && this.parutionYear==almanac.parutionYear;
	}
}
