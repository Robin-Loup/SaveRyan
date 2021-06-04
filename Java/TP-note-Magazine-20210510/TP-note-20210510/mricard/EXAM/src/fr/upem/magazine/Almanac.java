package fr.upem.magazine;

public class Almanac extends Magazine {
	private final int publishDate;
	
	public Almanac(String name, int price, int publishDate) {
		super(name, price);
		this.publishDate = publishDate;
	}
	
	public String toString() {
		return name() + " almanach of " + publishDate + " at " + price() + "€" ;
	}

	@Override
	public boolean Equals(Object obj) {
		boolean same = super.Equals(obj);
		var al = (Almanac)obj;
		boolean res = false;
		if(same && this.publishDate == al.publishDate) {
			res = true;
		}
		return res;
	}
	
	
	
}
