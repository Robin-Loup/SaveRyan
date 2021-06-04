package fr.umlv.geom;

public class Point {
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(Point p) {
		this.x = p.x;
		this.y = p.y;
	}
	
	public int x() {
		return x;
	}
	
	public int y() {
		return y;
	}
  @Override
  public String toString() {
    return "(" + x + ',' + y + ')';
  }
  
  public void translate(int dx, int dy) {
    x += dx;
    y += dy;
  }
}
/*On veut changer x et y qui sont final par defaut
 * On peut soit faire une lasse soit créer de nouveau Point qu'on renvoir pour simuler le changement
 */