import java.lang.Integer;

public record Point(int x, int y) {
	public  double distance(Point p) {
		return Math.sqrt((p.x() - this.x())*(p.x() - this.x()) + (p.y() - this.y()) * (p.y() - this.y()));
	}
	public static void main(String[] args) {
		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		System.out.println("x = " + x + " y = " + y);
		var p = new Point(x, y);
		System.out.println(p.x());
		System.out.println(p.y());
		var po = new Point(0, 0);
		System.out.println(p.distance(po));
	}
}

//javac Point.java --enable-preview -source 15
//static fait que l'on appelle une methode par la classe et par un objet.
//message d'erreur The constructor Point(int, String) is undefined