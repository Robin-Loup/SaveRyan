import java.util.Scanner; //on importe une classe Scanner du package java.util

public class Calc {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);; //variable de type Scanner
		int value = scanner.nextInt();	//variable de type integer
		int value2 = scanner.nextInt();	//variable de type integer
		int somme = value + value2;	//variable de type integer
		int produit = value * value2;	//variable de type integer
		int difference = value - value2;;	//variable de type integer
		int quotient = value / value2;	//variable de type integer
		int reste = value % value2;	//variable de type integer 
		System.out.println(somme);
		System.out.println(produit);
		System.out.println(difference);
		System.out.println(quotient);
		System.out.println(reste);
		scanner.close();
	}
}

//nextInt() est une methode, elle est reliée à une classe