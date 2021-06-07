package fr.umlv.shopping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class ShoppingCart {
  private final HashMap<Item, Integer> cart = new HashMap<>();

  public void add(Item item) {
    Objects.requireNonNull(item);
    cart.add(item);
  }

  public void remove(Item item) {
    Objects.requireNonNull(item);
    cart.remove(item);
  }

  public int price() {
    var sum = 0;
    for (var item : cart) {
      sum += item.price();
    }
    return sum;
  }

  @Override
  public String toString() {
    var builder = new StringBuilder();
    builder.append("--- Shopping cart ---\n");
    for (var item : cart) {
      builder.append(item).append("\n");
    }
    builder.append("---------------------");
    return builder.toString();
  }
}
