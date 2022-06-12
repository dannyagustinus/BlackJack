package Internal.Entities;

import java.util.*;

import Internal.Constants.HandConstants;

public class Hand {
  private List<Card> cards;
  
  public Hand() {
    cards = new ArrayList<>();
  }

  public void put(Card card) {
    cards.add(new Card(card.getValue(), card.getSuite()));
  }

  public List<Card> getCards() {
    List<Card> res = new ArrayList<>();
    for (Card card : cards) {
      res.add(new Card(card.getValue(), card.getSuite())); 
    }
    return res;
  }

  public int total() {
    int sum = 0;
    int aces = 0;
    for (Card card : cards) {
      if (!card.getValue().equals("Ace")) {
        sum += HandConstants.VALUES_TO_INT.get(card.getValue());
      }
    }

    for (int i = 0; i < aces; i++) {
      sum += pickValueForAce(sum);
    }

    return sum;
  }

  private int pickValueForAce(int currVal) {
    if (currVal + HandConstants.ACE_ELEVEN <= HandConstants.TWENTY_ONE) {
      return HandConstants.ACE_ELEVEN;
    } else {
      return HandConstants.VALUES_TO_INT.get("Ace");
    }
  }
}
