package fr.umlv.shopping;

import java.util.Objects;

public record VideoGame(String title, Console console, int price) implements Item{
  public enum Console {  // static by default.
    PS3, PS4, XBOX, WII, DS
  }
	
  public VideoGame {
    if (price < 0) {
      throw new IllegalArgumentException("price < 0");
    }
    Objects.requireNonNull(title);
    Objects.requireNonNull(console);
  }
  
  public int price() {
	  return price;
  }

  @Override
  public String toString() {
    return title + ", sur " + console.name();
  }
  
  @Override
	public String toTextFormat() {
		return SaverLoader.VIDEO_GAME_TYPE + SaverLoader.SEPARATOR + price + SaverLoader.SEPARATOR + title + SaverLoader.SEPARATOR + console;
	}
}
