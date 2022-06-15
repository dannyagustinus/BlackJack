package Internal.Usecase;

import Internal.Entities.*;
import Internal.Interfaces.Humans;

import java.util.*;

/**
 * A class representing the players of a BlackJack game
 */
public class Player implements Humans {
  private final Deck deck;
  private final Hand hand;
  private boolean hasStood; // flag for a stand

  // Constructor
  public Player(Deck deck) {
    this.deck = deck;
    hand = new Hand();
    hand.put(deck.getRandomCard());
    hand.put(deck.getRandomCard());
    hasStood = false;
  }

  public int getTotal() {
    return hand.total();
  }

  public List<Card> showHand() {
    List<Card> res = new ArrayList<>();
    for (Card card : hand.getCards()) {
      res.add(new Card(card.getValue(), card.getSuite()));
    }
    return res;
  }

  public void hit() {
    hand.put(deck.getRandomCard());
  }

  // Sets the flag to true
  public void stand() {
    hasStood = true;
  }
  
  // Checks if the player has stood or not
  public boolean hasStood() {
    return hasStood;
  }
}
