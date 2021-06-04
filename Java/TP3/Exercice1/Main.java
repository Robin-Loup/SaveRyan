package Exercice1;


public class Main {
	public static void main(String[] args) {
		var book = new Book("Da Vinci Code", "Dan Brown");
		System.out.println(book.title() + ' ' + book.author());
		var weirdBook = new Book("oops");
		System.out.println(weirdBook.title() + ' ' + weirdBook.author());
		weirdBook = weirdBook.withTitle("oops 2");
		System.out.println(weirdBook.title() + ' ' + weirdBook.author());
	}
}
/*On utilise des getters pour acceder au contenu des arguments qui ne sont pas accessible en dehors de la classe.
 */
