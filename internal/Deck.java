package internal;

import java.util.*;

public class Deck {
  private List<Card> cards = new ArrayList<>();

  // Constructor
  public Deck() {
    cards.clear();

    for (String value : Constants.VALUES) {
      for (String suite : Constants.SUITES) {
        cards.add(new Card(value, suite));
      }
    }
  }

  public boolean isEmpty() {
    return cards.size() == 0;
  }

  // Mutators
  public Card getRandomCard() {
    Collections.shuffle(cards);
    return cards.get(0);
  }
}
