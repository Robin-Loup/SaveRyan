package fr.umlv.geom;

public class Main {
	public static void main(String[] args) {
		 /*var point = new Point(1, 2);
	     var circle = new Circle(point, 1);

	     var circle2 = new Circle(point, 2);
	     circle2.translate(1, 1);

	     System.out.println(circle + " " + circle2);
	     
	     var p = new Point(1, 2);
	     var c = new Circle(p, 1);
	     var p2 = c.center();
	     p2.translate(1,1);
	     System.out.println(c);*/
	     
	     var point = new Point(1, 2);
	     var circle = new Circle(point, 2);
	     System.out.println(circle);
	     var ring = new Ring(point, 2, 1);
	     System.out.println(ring);
	}
}
