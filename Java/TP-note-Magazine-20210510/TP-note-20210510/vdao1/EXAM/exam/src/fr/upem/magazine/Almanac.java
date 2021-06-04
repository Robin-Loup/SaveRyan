package fr.upem.magazine;

public class Almanac extends Magazine{
	private final int parution;
	public Almanac(String name, int price,int parution) {
		super(name, price);
		if(parution<1900) throw new IllegalArgumentException("Year of parution has to be >1900");
		this.parution=parution;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return this.name()+ " almanac of " + this.parution + 
				" at "+this.price()+"€";
	}
	@Override
	public boolean equals(Object a) {
		Almanac b=(Almanac) a;
		return (super.equals(a) && 
				this.parution==b.parution);
	}
	public boolean isMoreTrendy(Magazine m2) {
		if(m2.getClass()!=Almanac.class)return false;
		return super.isMoreTrendy(m2);
	}

}
