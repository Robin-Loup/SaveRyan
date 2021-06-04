package Exercice3;

public class Book2 {
	  private final String title;
	  private final String author;

	  public Book2(String title, String author) {
	    this.title = title;
	    this.author = author;
	  }
	  
	  @Override
	  public boolean equals(Object obj) {
		  if(obj instanceof Book2) {
			  Book2 other = (Book2)obj;
			  return this.title.equals(other.title) || this.author.equals(other.author);
		  }
		  return false;
	  }
	  
	  public static void main(String[] args) {
	    var book1 = new Book2("Da Vinci Code", "Dan Brown");
	    var book2 = new Book2("Da Vinci Code", "Dan Brown");
	    System.out.println(book1.equals(book2));
	  }
	}
/*	Equals verifie les references et non pas le contenu car
 *  elle fonctioone avec des oject et ne verifie pas les arguments de Book2
 */