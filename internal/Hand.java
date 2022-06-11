package internal;

import java.util.*;

public class Hand {
  private List<Card> cards;
  
  public Hand() {
    cards = new ArrayList<>();
  }

  public void put(Card card) {
    cards.add(card);
  }

  public int total() {
    int sum = 0;
    int aces = 0;
    for (Card card : cards) {
      if (!card.getValue().equals("Ace")) {
        sum += Constants.VALUES_TO_INT.get(card.getValue());
      }
    }

    for (int i = 0; i < aces; i++) {
      sum += pickValueForAce(sum);
    }

    return sum;
  }

  private int pickValueForAce(int currVal) {
    if (currVal + Constants.ACE_ELEVEN <= Constants.TWENTY_ONE) {
      return Constants.ACE_ELEVEN;
    } else {
      return Constants.VALUES_TO_INT.get("Ace");
    }
  }
}
