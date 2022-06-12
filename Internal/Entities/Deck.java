package Internal.Entities;

import java.util.*;

import Internal.Constants.*;

public class Deck {
  private static List<Card> cards;

  // Constructor
  public Deck() {
    cards = new ArrayList<>();
    refillDeck();
  }

  public boolean isEmpty() {
    return cards.size() == 0;
  }

  // Mutators
  public Card getRandomCard() {
    Collections.shuffle(cards);
    return cards.remove(0);
  }

  public void refillDeck() {
    cards.clear();

    for (String value : CardConstants.VALUES) {
      for (String suite : CardConstants.SUITES) {
        cards.add(new Card(value, suite));
      }
    }
  }
}
