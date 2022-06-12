package Internal.Usecase;

import Internal.Constants.GameConstants;
import Internal.Entities.*;
import java.util.*;

public class Game {
  private static Deck deck;
  private static Dealer dealer;
  private static List<Player> players;

  public Game() {
    deck = new Deck();
    dealer = new Dealer(deck);
    players = new ArrayList<>();
    players.add(new Player(deck));
  }

  public List<Card> getDealerHand() {
    return dealer.showHand();
  }

  public List<List<Card>> getPlayersHand() {
    List<List<Card>> res = new ArrayList<>();
    for (Player player : players) {
      res.add(player.showHand());
    }
    return res;
  }
  
  public List<Integer> processRound(List<String> choices) {
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

    int dealerTotal = dealer.getTotal();
    List<Integer> playersTotal = new ArrayList<>();
    for (Player player : players) {
      playersTotal.add(player.getTotal());
    }

    if (dealerTotal < 17) {
      dealer.hit();
      dealerTotal = dealer.getTotal();
    }

    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < playersTotal.size(); i++) {
      int playerTotal = playersTotal.get(i);
      if (playerTotal > 21 ||
          (players.get(i).hasStood() && dealerTotal >= 17 && dealerTotal > playerTotal)) {
        res.add(GameConstants.STATUS_DEALER_WIN);
      } else if (players.get(i).hasStood() && dealerTotal >= 17 && dealerTotal < playerTotal) {
        res.add(GameConstants.STATUS_PLAYER_WIN);
      } else if (players.get(i).hasStood() && dealerTotal >= 17 && dealerTotal == playerTotal) {
        res.add(GameConstants.STATUS_DRAW);
      } else {
        res.add(GameConstants.STATUS_CONTINUE);
      }
    }

    return res;
  }

}
