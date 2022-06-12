package Internal.Usecase;

import Internal.Entities.*;
import Internal.Interfaces.Humans;

import java.util.*;

public class Dealer implements Humans{
  private static Card hiddenCard;
  private static Hand hand;
  private Deck deck;

  public Dealer(Deck deck) {
    this.deck = deck;
    hand = new Hand();
    
    hiddenCard = deck.getRandomCard();

    hand.put(hiddenCard);
    hand.put(deck.getRandomCard());
  }

  public int getTotal() {
    return hand.total();
  }

  public List<Card> showHand() {
    List<Card> res = new ArrayList<>();
    for (Card card : hand.getCards()) {
      if (card.getSuite() == hiddenCard.getSuite() &&
          card.getValue() == hiddenCard.getValue()) {
        res.add(new Card("", ""));
      } else {
        res.add(new Card(card.getValue(), card.getSuite()));
      }
    }

    if (hiddenCard.getSuite() != "" && hiddenCard.getValue() != "") {
      hiddenCard = new Card("", "");
    }

    return res;
  }

  public void hit() {
    hand.put(deck.getRandomCard());
  }
}
