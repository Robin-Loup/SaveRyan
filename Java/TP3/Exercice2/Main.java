package Exercice2;

import Exercice1.Book;

public class Main {
	public static void main(String[] args) {
	    var b1 = new Book("Da Java Code", "Duke Brown");
	    var b2 = b1;
	    var b3 = new Book("Da Java Code", "Duke Brown");

	    System.out.println(b1 == b2);
	    System.out.println(b1 == b3);
	    
	    System.out.println(b1.equals(b2));
	    System.out.println(b1.equals(b3));
	    
	    var book1 = new Book("Da Vinci Code", "Dan Brown");
	    var book2 = new Book("Angels & Demons", new String("Dan Brown"));
	    System.out.println(book1.IsFromTheSameAuthor(book2));
	    
	    var javaBook = new Book("Da Java Code", "Duke Brown");
        System.out.println(javaBook);
	}
}
/*On regarde s'ils ont la me reference pas s'ils ont le même contenu
 */

/*L'Override permet de redéfinir des méthodes*/