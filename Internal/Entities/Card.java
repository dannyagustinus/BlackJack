package Internal.Entities;

/**
 * A class that represents an actual card with a suite and a value
 */
public class Card {
  // fields cannot be changed
  private final String value;
  private final String suite;

  // Constructor
  public Card(String value, String suite) {
    this.value = value;
    this.suite = suite;
  }

  // Gets the value of the card
  public String getValue() {
    return value;
  } 

  // Gets the suite of the card
  public String getSuite() {
    return suite;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    } else if (!(other instanceof Card)) {
      return false;
    } else if (this.hashCode() != other.hashCode()) {
      return false;
    } else {
      Card that = (Card) other;
      return (this.value.equals(that.value)) && (this.suite.equals(that.suite));
    }
  }

  @Override
  public int hashCode() {
    int result = suite.hashCode();
    result = (31 * result) + value.hashCode();
    return result;
  }
}
