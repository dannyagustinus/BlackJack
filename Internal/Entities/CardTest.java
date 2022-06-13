package Internal.Entities;

import org.junit.*;
import org.junit.rules.*;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.*;
import Internal.Constants.*;

/**
 * Junit tests for Card.java
 */
public class CardTest {
  @Rule
  public Timeout globalTimeout = Timeout.seconds(2);

  private static List<Card> deck;

  /** Initialize deck **/
  @BeforeClass
  public static void initialize() {
    deck = new ArrayList<>();
    for (String value : CardConstants.VALUES) {
      for (String suite : CardConstants.SUITES) {
        deck.add(new Card(value, suite));
      }
    }
  }

  /** Get the card's suite **/
  @Test
  public void testGetSuite() {
    assertEquals(deck.get(0).getSuite(), "Diamonds");
    assertEquals(deck.get(1).getSuite(), "Clubs");
    assertEquals(deck.get(2).getSuite(), "Hearts");
    assertEquals(deck.get(3).getSuite(), "Spades");
  }

  /** Get the card's value **/
  @Test
  public void testGetValue() {
    assertEquals(deck.get(0).getValue(), "Ace");
    assertEquals(deck.get(4).getValue(), "Two");
    assertEquals(deck.get(8).getValue(), "Three");
    assertEquals(deck.get(12).getValue(), "Four");
    assertEquals(deck.get(16).getValue(), "Five");
    assertEquals(deck.get(20).getValue(), "Six");
    assertEquals(deck.get(24).getValue(), "Seven");
    assertEquals(deck.get(28).getValue(), "Eight");
    assertEquals(deck.get(32).getValue(), "Nine");
    assertEquals(deck.get(36).getValue(), "Ten");
    assertEquals(deck.get(40).getValue(), "Jack");
    assertEquals(deck.get(44).getValue(), "Queen");
    assertEquals(deck.get(48).getValue(), "King");
  }

  /** Checks for equality between two cards**/
  @Test
  public void testEquals() {
    assertFalse(deck.get(0).equals(null));
    assertFalse(deck.get(0).equals(new Card("Ten", "Hearts")));
    assertFalse(deck.get(0).equals(new Card("Ace", "Hearts")));
    assertFalse(deck.get(0).equals(new Card("Ten", "Diamonds")));

    assertTrue(deck.get(0).equals(deck.get(0)));
    assertTrue(deck.get(0).equals(new Card("Ace", "Diamonds")));
  }

  /** Checks for equality of hashcodes between two cards**/
  @Test
  public void testHashcode() {
    assertEquals(deck.get(0).hashCode(), deck.get(0).hashCode());
    Card equalCard = new Card("Ace", "Diamonds");
    assertEquals(deck.get(0).hashCode(), equalCard.hashCode());
  }
}
