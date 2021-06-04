package fr.umlv.geom;

public class Ring extends Circle {
	final private int InternalRadius;
	
	public Ring(Point center, int rayon, int int_rayon) {
		super(center, rayon);
		this.InternalRadius = int_rayon;
		if (int_rayon >= rayon) {
			throw new IllegalArgumentException(int_rayon + " >= " + rayon);
		}
	}
	
	@Override
	String type() {
		return "Ring";
	}
	
	@Override
	public String toString() {
	    return  super.toString() + " InternalRadius : " + InternalRadius;
	  }
	
	@Override
	public boolean contains(Point p) {
		return distance(p) < rayon() && distance(p) > InternalRadius;
	}
	
	public static boolean contains(Point p, Ring[] rings) {
		for(var ring : rings) {
			if (ring.contains(p)) {
				return true;
			}
		}
		return false;
	}
}
