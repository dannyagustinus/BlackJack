package Internal.Entities;

import java.util.*;

import Internal.Constants.GameConstants;
import Internal.Constants.HandConstants;

/**
 * A class that respresents a hand containing cards
 */
public class Hand {
  private final List<Card> cards;
  
  // Constructor
  public Hand() {
    cards = new ArrayList<>();
  }

  // Puts a new card into the hand
  public void put(Card card) {
    cards.add(new Card(card.getValue(), card.getSuite()));
  }

  // Gets a list of the cards in the hand
  public List<Card> getCards() {
    List<Card> res = new ArrayList<>();
    for (Card card : cards) {
      res.add(new Card(card.getValue(), card.getSuite())); 
    }
    return res;
  }

  // Finds the value of the current hand
  public int total() {
    int sum = 0;
    int aces = 0;
    for (Card card : cards) {
      // Avoids the Aces to be counted for later
      if (!card.getValue().equals("Ace")) {
        sum += HandConstants.VALUES_TO_INT.get(card.getValue());
      } else {
        aces++;
      }
    }

    for (int i = 0; i < aces; i++) {
      // Picks the appropriate value for the Ace
      sum += pickValueForAce(sum);
    }

    return sum;
  }

  // Chooses the value for an Ace based on the current value
  private int pickValueForAce(int currVal) {
    if (currVal + HandConstants.ACE_ELEVEN <= GameConstants.BLACKJACK) {
      return HandConstants.ACE_ELEVEN;
    } else {
      return HandConstants.VALUES_TO_INT.get("Ace");
    }
  }
}
