package Internal.Constants;

import java.util.*;

/**
 * Class to hold constants regarding a Card structure
 */
public class CardConstants {
  // A list of all possible values of a card
  public static final List<String> VALUES = new ArrayList<>(Arrays.asList(
    "Ace",
    "Two",
    "Three",
    "Four",
    "Five",
    "Six",
    "Seven",
    "Eight",
    "Nine",
    "Ten",
    "Jack",
    "Queen",
    "King"
  ));
  
  // A list of all possible suites of a card
  public static final List<String> SUITES = new ArrayList<>(Arrays.asList(
    "Diamonds",
    "Clubs",
    "Hearts",
    "Spades"
  ));
}
