package Internal.Usecase;

import Internal.Entities.*;
import Internal.Interfaces.Humans;

import java.util.*;

/**
 * A class that represents a Dealer in a BlackJack game
 */
public class Dealer implements Humans{
  private static Card hiddenCard; // The hidden card at the first round
  private static Hand hand;
  private final Deck deck;

  // Constructor
  public Dealer(Deck deck) {
    this.deck = deck;
    hand = new Hand();
    hiddenCard = deck.getRandomCard();
    hand.put(new Card(hiddenCard.getValue(), hiddenCard.getSuite()));
    hand.put(deck.getRandomCard());
  }

  public int getTotal() {
    return hand.total();
  }

  public List<Card> showHand() {
    List<Card> res = new ArrayList<>();
    for (Card card : hand.getCards()) {
      // Don't show the hidden card
      if (Objects.equals(card.getSuite(), hiddenCard.getSuite()) && Objects.equals(card.getValue(), hiddenCard.getValue())) {
        res.add(new Card("", ""));
      } else {
        res.add(new Card(card.getValue(), card.getSuite()));
      }
    }

    unhide();

    return res;
  }

  public void hit() {
    hand.put(deck.getRandomCard());
  }

  // Makes the hidden card visible for next rounds
  private void unhide() {
    if (!Objects.equals(hiddenCard.getSuite(), "") && !Objects.equals(hiddenCard.getValue(), "")) {
      hiddenCard = new Card("", "");
    }
  }
}
