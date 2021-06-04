package Exercice3;

public class Pixel {
	public final static int ORIGIN = 0;
	private int x;
	private int y;

	public Pixel(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void reset() {
		x = ORIGIN;
		y = ORIGIN;
	}

	public static String displayPixels(Pixel[] pixels) {
		StringBuilder str = new StringBuilder();
		str.append(pixels.length).append(" point(s): {\n");
		for (Pixel variable : pixels) {
			if (variable != null) {
				str.append('(').append(variable.x).append(',').append(variable.y).append(") ;\n");
			}
		}
		if (pixels.length != 0) {
			str.setLength(str.length() - 2);
		}
		str.append('}');
		
		return str.toString();
		
	}
	
	public static void resetAtOriginAllPixelsWithXAt(int targetX, Pixel[] pixels) {
		for (Pixel variable : pixels) {
			if (variable != null) {
				if (variable.x == targetX) {
					variable.reset();
				}
			}
		}
	}
	

	public static void main(String[] args) {
		var empty = new Pixel[] {};
		var singlePixel = new Pixel[] { new Pixel(1,1) };
		var fivePixels = new Pixel[] { new Pixel(1,1), new Pixel(2,2), new Pixel(3,3), new Pixel(4,4), new Pixel(5,5) };
		System.out.println(Pixel.displayPixels(empty));
		System.out.println(Pixel.displayPixels(singlePixel));
		System.out.println(Pixel.displayPixels(fivePixels));
		
		Pixel.resetAtOriginAllPixelsWithXAt(3, fivePixels);
		System.out.println(Pixel.displayPixels(fivePixels));
	}
}
