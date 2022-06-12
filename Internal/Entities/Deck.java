package Internal.Entities;

import java.util.*;

import Internal.Constants.*;

/**
 * A class that respresents a deck of cards
 */
public class Deck {
  private static List<Card> cards;

  // Constructor
  public Deck() {
    cards = new ArrayList<>();
    refillDeck();
  }

  // Checks if the deck is empty or not
  public boolean isEmpty() {
    return cards.size() == 0;
  }

  // Gets a random card from the deck
  public Card getRandomCard() {
    Collections.shuffle(cards);
    return cards.remove(0);
  }

  // Refills the deck into it's initial setup
  public void refillDeck() {
    cards.clear();

    for (String value : CardConstants.VALUES) {
      for (String suite : CardConstants.SUITES) {
        cards.add(new Card(value, suite));
      }
    }
  }
}
