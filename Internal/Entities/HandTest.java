package Internal.Entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.*;
import org.junit.rules.*;

public class HandTest {
  @Rule
  public Timeout globalTimeout = Timeout.seconds(2);

  private static Hand blackjack;
  private static Hand noAces;
  private static Hand oneAce;
  private static Hand twoAces;
  private static Hand threeAces;
  private static Hand fourAces;

  /** Initialize hands **/
  @BeforeClass
  public static void initialize() {
    blackjack = new Hand();
    blackjack.put(new Card("Jack", "Diamonds"));
    blackjack.put(new Card("Ace", "Diamonds"));

    noAces = new Hand();
    noAces.put(new Card("Ten", "Hearts"));
    noAces.put(new Card("Two", "Hearts"));

    oneAce = new Hand();
    oneAce.put(new Card("Ace", "Spades"));
    oneAce.put(new Card("Ten", "Clubs"));
    oneAce.put(new Card("Nine", "Hearts"));

    twoAces = new Hand();
    twoAces.put(new Card("Ace", "Spades"));
    twoAces.put(new Card("Ace", "Diamonds"));
    twoAces.put(new Card("Five", "Hearts"));

    threeAces = new Hand();
    threeAces.put(new Card("Ace", "Spades"));
    threeAces.put(new Card("Ace", "Diamonds"));
    threeAces.put(new Card("Ace", "Clubs"));

    fourAces = new Hand();
    fourAces.put(new Card("Ace", "Spades"));
    fourAces.put(new Card("Ace", "Diamonds"));
    fourAces.put(new Card("Ace", "Clubs"));
    fourAces.put(new Card("Ace", "Hearts"));
    fourAces.put(new Card("Seven", "Hearts"));
  }

  /** Gets the cards at each hand **/
  @Test
  public void testGetCards() {
    assertEquals(Arrays.asList(new Card("Jack", "Diamonds"),
                               new Card("Ace", "Diamonds")),
                 blackjack.getCards());
    
    assertEquals(Arrays.asList(new Card("Ten", "Hearts"),
                               new Card("Two", "Hearts")),
                 noAces.getCards());
    
    assertEquals(Arrays.asList(new Card("Ace", "Spades"),
                               new Card("Ten", "Clubs"),
                               new Card("Nine", "Hearts")),
                 oneAce.getCards());
     
    assertEquals(Arrays.asList(new Card("Ace", "Spades"),
                               new Card("Ace", "Diamonds"),
                               new Card("Five", "Hearts")),
                 twoAces.getCards());

    assertEquals(Arrays.asList(new Card("Ace", "Spades"),
                               new Card("Ace", "Diamonds"),
                               new Card("Ace", "Clubs")),
                 threeAces.getCards());

    assertEquals(Arrays.asList(new Card("Ace", "Spades"),
                               new Card("Ace", "Diamonds"),
                               new Card("Ace", "Clubs"),
                               new Card("Ace", "Hearts"),
                               new Card("Seven", "Hearts")),
                 fourAces.getCards());
  }
  
  /** Gets the total for each hand **/
  @Test
  public void testTotal() {
    assertEquals(blackjack.total(), 21);
    assertEquals(noAces.total(), 12);
    assertEquals(oneAce.total(), 20);
    assertEquals(twoAces.total(), 17);
    assertEquals(threeAces.total(), 13);
    assertEquals(fourAces.total(), 21);
  }
}
