package fr.umlv.shopping;

public record PrePaid(int value, int validTimeInWeek) implements Item{
  public PrePaid {
    if (value < 0) {
      throw new IllegalArgumentException("value < 0");
    }
    if (validTimeInWeek < 0 || validTimeInWeek >= 52) {  // 52 weeks == 1 year
      throw new IllegalArgumentException("validTimeInWeek < 0 || validTimeInWeek >= 52");
    }
  }

  public int price() {
    if (validTimeInWeek <= 2) {
      return value * 80 / 100;
    }
    return value;
  }

  @Override
  public String toString() {
    return "Carte cadeau (%d,%02d€), durée: %s semaines)".formatted(value / 100, value % 100, validTimeInWeek);
  }

  @Override
	public String toTextFormat() {
		return SaverLoader.PREPAID_TYPE + SaverLoader.SEPARATOR + value + SaverLoader.SEPARATOR + validTimeInWeek;
	}
}
