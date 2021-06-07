package fr.umlv.shopping;

import java.util.Objects;

public record Book(String author, String title, int price) implements Item {
  public Book {
    if (price < 0) {
      throw new IllegalArgumentException("price < 0");
    }
    Objects.requireNonNull(author);
    Objects.requireNonNull(title);
  }
  
  public int price() {
	  return price;
  }

  @Override
  public String toString() {
    return title + ", de " + author;
  }

	@Override
	public String toTextFormat() {
		return SaverLoader.BOOK_TYPE + SaverLoader.SEPARATOR + price + SaverLoader.SEPARATOR + title + SaverLoader.SEPARATOR + author;
	}
}
