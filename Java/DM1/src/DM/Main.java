package DM;
public class Main {

	public static void main(String[] args) {
		Matrice A = new Matrice(new long[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 13 } });
		
		Matrice B = A.times(A.transpose());
		Matrice C = B.inverse();
		System.out.println(C);
		Matrice D = A.transpose().times(A);
		try {
			Matrice E = D.inverse();
			System.out.println(E);
		} catch (ArithmeticException e) {
			System.out.println("D n'a pas d'inverse");
		}
		
		var testi = new Matrice(new long[][]{{250, 200, 129}, {125, 230, 50}, {160, 300, 42}});
		var b = new Matrice(new long[][]{{857}, {434}, {526}});
		System.out.println(testi.resoud(b));
	}

}
/*Le resultat (la matrice D) n'est pas inversible. Elle est symétrique mais pas diagonale,
 *   donc son determinent est donc null d'ou le fait qu'elle est non inversible.
 */