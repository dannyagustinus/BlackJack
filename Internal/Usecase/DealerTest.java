package Internal.Usecase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.*;
import org.junit.rules.*;
import Internal.Entities.*;

public class DealerTest {
  @Rule
  public Timeout globalTimeout = Timeout.seconds(2);

  private static Dealer dealer;
  private static Deck deck;

  /** Initialize dealer */
  @BeforeClass
  public static void initialize() {
    deck = new Deck();
  }

  /** Gets the visible cards of the dealer **/
  @Test
  public void testShowHand() {
    dealer = new Dealer(deck);
    assertTrue(dealer.showHand().contains(new Card("", "")));
    assertEquals(2, dealer.showHand().size());
    assertFalse(dealer.showHand().contains(new Card("", "")));
  }

  /** Dealer hits **/
  @Test
  public void testHit() {
    dealer = new Dealer(deck);
    dealer.hit();
    assertEquals(3, dealer.showHand().size());
  }
}
