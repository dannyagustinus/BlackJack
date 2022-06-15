package Internal.Entities;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;

import org.junit.*;
import org.junit.rules.*;

public class DeckTest {
  @Rule
  public Timeout globalTimeout = Timeout.seconds(2);

  private static Deck deck;

  /** Initialize deck **/
  @BeforeClass
  public static void initialize() {
    deck = new Deck();
  }

  /** Gets a random card from the deck **/
  @Test
  public void testGetRandomCard() {
    List<Card> temp = new ArrayList<>();

    // Checks if we're getting different cards each time
    for (int i = 0; i < 52; i++) {
      Card card = deck.getRandomCard();
      assertFalse(temp.contains(card));
      temp.add(card);
    }

    // Checks if we get a card that we've already gotten
    // after the deck is empty because of the refill
    Card card = deck.getRandomCard();
    assertTrue(temp.contains(card));
  }

}
