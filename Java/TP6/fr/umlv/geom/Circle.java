package fr.umlv.geom;

public class Circle{
	final private Point center;
	final private int rayon;
	
	public Circle(Point center, int rayon) {
		this.center = new Point(center);
		this.rayon = rayon;
	}
	public int rayon() {
		return rayon;
	}
	
	public Point center() {
		return new Point(center);
	}
	
	String type() {
		return "Centre";
	}
	
	Double distance(Point p) {
		return Math.sqrt(((p.x() * center.x()) * (p.x() * center.x()))+ ((p.y() - center.y()) * (p.y() - center.y())));
	}
	
	@Override
	public String toString() {
	    return  type() + " : " + center + "; rayon : " + rayon + " surface : " + surface();
	  }
	
	public void translate(int dx, int dy) {
		center.translate(dx, dy);
	}
	
	public double surface() {
		return Math.PI * rayon * rayon;
	}
	
	public boolean contains(Point p) {
		return distance(p) < rayon;
	}
	
	public static boolean contains(Point p, Circle[] circles) {
		for(var circle : circles) {
			if (circle.contains(p)) {
				return true;
			}
		}
		return false;
	}
}