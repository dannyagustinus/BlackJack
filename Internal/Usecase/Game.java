package Internal.Usecase;

import Internal.Constants.DealerConstants;
import Internal.Constants.GameConstants;
import Internal.Entities.*;
import java.util.*;

/**
 * A class representing the game of BlackJack
 */
public class Game {
  private static Deck deck;
  private static Dealer dealer;
  private static List<Player> players; // Could be multiple players

  public Game() {
    deck = new Deck();
    dealer = new Dealer(deck);
    players = new ArrayList<>();
    players.add(new Player(deck));
  }

  // Gets the dealer's visible cards
  public List<Card> getDealerHand() {
    return dealer.showHand();
  }

  // Gets all players' cards
  public List<List<Card>> getPlayersHand() {
    List<List<Card>> res = new ArrayList<>();
    for (Player player : players) {
      res.add(player.showHand());
    }
    return res;
  }
  
  // Determines the outcome of each round after each
  // player makes a move
  public List<Integer> processRound(List<String> choices) {
    // Determines the action of each player
    for (int i = 0; i < players.size(); i++) {
      switch(choices.get(i)) {
        case "hit":
          players.get(i).hit();
          break;
        default:
          players.get(i).stand();
          break;
      }
    }

    // Gets the current total of everyone after the players' 
    // move
    int dealerTotal = dealer.getTotal();
    List<Integer> playersTotal = new ArrayList<>();
    for (Player player : players) {
      playersTotal.add(player.getTotal());
    }

    // Dealer automatically hits if the value of their card
    // is below 17
    if (dealerTotal < DealerConstants.MIN_VALUE_DEALER) {
      dealer.hit();
      dealerTotal = dealer.getTotal();
    }

    // Determines the outcome for each player
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < playersTotal.size(); i++) {
      int playerTotal = playersTotal.get(i);

      // If the player goes bust or has a smaller value than the dealer
      if (playerTotal > GameConstants.BLACKJACK ||
          (players.get(i).hasStood() && dealerTotal >= DealerConstants.MIN_VALUE_DEALER && dealerTotal > playerTotal)) {
        res.add(GameConstants.STATUS_DEALER_WIN);

      // If the player has a bigger value than the dealer (including a blackjack)
      } else if (players.get(i).hasStood() && dealerTotal >= DealerConstants.MIN_VALUE_DEALER && dealerTotal < playerTotal) {
        res.add(GameConstants.STATUS_PLAYER_WIN);

      // If the player has the same value as the dealer (including a blackjack)
      } else if (players.get(i).hasStood() && dealerTotal >= DealerConstants.MIN_VALUE_DEALER && dealerTotal == playerTotal) {
        res.add(GameConstants.STATUS_DRAW);

      // Continues if the player hasn't stood yet
      } else {
        res.add(GameConstants.STATUS_CONTINUE);
      }
    }

    return res;
  }

}
