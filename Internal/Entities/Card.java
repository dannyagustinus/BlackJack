package Internal.Entities;

public class Card {
  // fields cannot be changed
  private final String value;
  private final String suite;

  // Constructor
  public Card(String value, String suite) {
    this.value = value;
    this.suite = suite;
  }

  // Observers
  public String getValue() {
    return value;
  } 

  public String getSuite() {
    return suite;
  }
}
