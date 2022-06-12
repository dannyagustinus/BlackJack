package Internal.Usecase;

import Internal.Entities.*;
import Internal.Interfaces.Humans;

import java.util.*;

public class Player implements Humans {
  private Deck deck;
  private Hand hand;
  private boolean hasStood;

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

  public void stand() {
    hasStood = true;
  }
  
  public boolean hasStood() {
    return hasStood;
  }
}
