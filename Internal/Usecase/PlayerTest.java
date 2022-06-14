package Internal.Usecase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.*;
import org.junit.rules.*;

import Internal.Entities.Deck;

public class PlayerTest {
  @Rule
  public Timeout globalTimeout = Timeout.seconds(2);

  private static Player player;
  private static Deck deck;

  /** Initialize player */
  @BeforeClass
  public static void initialize() {
    deck = new Deck();
  }

  /** Gets the visible cards of the player **/
  @Test
  public void testShowHand() {
    player = new Player(deck);
    assertTrue(player.showHand().size() == 2);
  }

  /** Player hits **/
  @Test
  public void testHit() {
    player = new Player(deck);
    assertTrue(player.showHand().size() == 2);
    player.hit();
    assertTrue(player.showHand().size() == 3);
  }

  /** Player stands **/
  @Test
  public void testStand() {
    player = new Player(deck);
    assertFalse(player.hasStood());
    player.stand();
    assertTrue(player.hasStood());
  }
}
