package Exercice1;

import java.util.Objects;

public record Book(String title, String author) {
	
	public Book{
		Objects.requireNonNull(title);
		Objects.requireNonNull(author);
	}
	
	public Book(String title){
		this(title, "<Anomymous>");
	}
	
	public Book withTitle(String title) {
		return new Book(title, this.author);
	}
	
	/*public Book(String title, String author) {
		this.title = Objects.requireNonNull(title);
		this.author = Objects.requireNonNull(author);
	}*/
	
	/*public static void main(String[] args) {
		  var book = new Book("Da Vinci Code", "Dan Brown");
		  System.out.println(book.title + ' ' + book.author);
	}*/
	public boolean IsFromTheSameAuthor(Book b1) {
		return this.author().equals(b1.author());
	}
	
	@Override
	public String toString() {
		return this.title + " by " + this.author;
	}
}
/*On cree un objet book avec comme title "Da Vinci Code" et comme author "Dan Brown";
 *puis on affiche le titre de book ainsi que son author.
 */

/*Le compilateur sait quelle constructeur appellé en fonction du nombre d'argument et de leur type*/
