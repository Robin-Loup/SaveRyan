package Exercice2;
import java.util.Scanner;

public class Stars {

	/*public static String stars(int n) {
		String val = "";
		for(int i = 0; i < n; i++) {
			val = val + "*"; 
		}
		return val;
	}*/
	
	public static String stars(int n) {
		StringBuilder val = new StringBuilder();
		for(int i = 0; i < n; i++) {
			val.append('*');
		}
		return val.toString();
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(Stars.stars(scanner.nextInt()));
	}
}

/*3)
 *  A chaque boucle for on copie dans une chaine de caractere i caracteres qui s'incremente à chaque fois
 *  donc le temps d'execution est exponentielle'
 */

/*5)
 *	sb.append("Bonjour") return un StringBuilder, on peut donc utiliser la methode append dessus,
 *	idem pour les autres methode tels que ToString()
 */

/*6)
 *	' ' est un caractere alors que " " est un String.
 *
 *  Il y a un appel à un StringBuilder
 */

/*7)
 *  Le + est beaucoup plus lourd que append et fait la même chose.
 */

/*8)
 *	StringBuilder est à priviligié quand on ne sait pas présicement ce qui va être mis dans la chaine de caractere.
 *	si on sait ce qui va être mis, un string est à priviligié. 
 */
