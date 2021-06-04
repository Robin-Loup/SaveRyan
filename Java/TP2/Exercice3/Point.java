package Exercice3;

public record Point(int x, int y) {
	
	public static String displayPoints(Point[] points) {
		StringBuilder str = new StringBuilder();
		str.append(points.length).append(" point(s): {\n");
		for (Point variable : points) {
			if (variable != null) {
				str.append('(').append(variable.x).append(',').append(variable.y).append(") ;\n");
			}
		}
		if (points.length != 0) {
			str.setLength(str.length() - 2);
		}
		str.append('}');
		return str.toString();
	}
	
	public static void resetAtOriginAllPointsWithXAt(int targetX, Point[] points) {
		for(int i = 0; i < points.length;i++){
			if (points[i] != null) {
				if (points[i].x == targetX) {
					points[i] = new Point(0,0);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		var empty = new Point[] {};
		var singlePoints = new Point[] { new Point(1,1) };
		var fivePoints = new Point[] { new Point(1,1), new Point(2,2), new Point(3,3), new Point(4,4), new Point(5,5) };
		System.out.println(Point.displayPoints(empty));
		System.out.println(Point.displayPoints(singlePoints));
		System.out.println(Point.displayPoints(fivePoints));
		
		Point.resetAtOriginAllPointsWithXAt(3, fivePoints);
		System.out.println(Point.displayPoints(fivePoints));
	}
}
