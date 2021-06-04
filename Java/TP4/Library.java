package Exercice2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Objects;

public class Library {
	
	/*private final ArrayList<Book> books;
	
	public Library() {
		books = new ArrayList<Book>();
	}
	
	public void add(Book b) {
		Objects.requireNonNull(b);
		books.add(b);
	}
	
	public Book findByTitle(String str) {
		for( Book b : books) {
			if (b.title().equals(str)) {
				return b;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (Book book : books) {
			str.append(book.toString()).append('\n');
		}
		return str.toString();
	}*/
	
	private final LinkedHashMap<String, Book> books;
	
	public Library() {
		books = new LinkedHashMap<String, Book>();
	}
	
	public void add(Book b) {
		Objects.requireNonNull(b);
		books.put(b.title(), b);
	}
	
	public Book findByTitle(String str) {
		
		return books.get(str);
	}
	
	public void removeAllBooksFromAuthor(String str) {
		/*for (String title : books.keySet()) {
			if (str.equals(books.get(title).author())) {
				books.remove(books.get(title));
			}
		}*/
	    /*var values = this.books.values();
	    for (Iterator iterator = values.iterator(); iterator.hasNext();) {
	    	Book book = (Book) iterator.next();
	        if(book.author().equals(str)) {
	        	iterator.remove();
	        }     
	    }*/
		
		this.books.values().removeIf(  (i) -> i.author().equals(str));  
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (Book book : books.values()) {
			str.append(book.toString()).append('\n');
		}
		return str.toString();
	}
	
	
	public static void main(String[] args) {
		var book = new Book("bilbo", "Tolkien");
		var book2 = new Book("bilbo2", "Tolkien");
		var book3 = new Book("bilboquet", "Talking to me");
		var library = new Library();
		library.add(book3);
		library.add(book);
	    library.add(book2);
	   
	    /*System.out.println(library.findByTitle("Da Vinci Code"));
	    System.out.println(library.findByTitle("bilbo"));*/
	    System.out.println(library.toString());
	    
	    library.removeAllBooksFromAuthor("Talking to me");
	    
	    System.out.println(library.toString());
	    
	    var library2 = new Library();
	    library2.add(new Book("Da Vinci Code", "Dan Brown"));
	    library2.add(new Book("Angels & Demons", "Dan Brown"));
	    library2.removeAllBooksFromAuthor("Dan Brown");
	}
}

/* 2.4
 * foreach crée un itérateur qui parcourt toute la liste
 * 
 * 2.5
 *  l'exeption est uniquement pour les erreur, pas pour les cas prévus
 * 
 * 3.1
 * complexité n
 * 
 * 3.2
 * Hashmap<TypeCle,TypeValeur>
 * Hashmap<String,Book>
 * 
 * 3.4
 * Un record construit automatiquement ses constructeurs,
 * dans ce cas il est plus interessant de les faire nous même 
 * d'oû la classe plutôt que le record
 * 
 * 
 * 3.7
 * Il ne supporte pas la modification de la list qu'il est actuellement en train parcourir.
 */
