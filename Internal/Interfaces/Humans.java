package Internal.Interfaces;

import Internal.Entities.*;
import java.util.*;

/**
 * An interface representing the common functionality
 * of a person in the casino on the BlackJack table
 */
public interface Humans {
  // Gets the value of the human's hand
  public int getTotal();

  // Gets the cards within the human's hand
  public List<Card> showHand();

  // Performs a hit
  public void hit();
}
