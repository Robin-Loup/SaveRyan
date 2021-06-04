import java.lang.Integer;

public record Point(int x, int y) {
	public static void distance(Point p) {
		System.out.println(Math.sqrt(p.x()*p.x() + p.y()*p.y()));
	}
	public static void main(String[] args) {
		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		System.out.println("x = " + x + " y = " + y);
		var p = new Point(x, y);
		System.out.println(p.x());
		System.out.println(p.y());
		Point.distance(p);
	}
}

//javac Point.java --enable-preview -source 15
//static fait que l'on appelle une methode par la classe et par un objet.
//message d'erreur The constructor Point(int, String) is undefined