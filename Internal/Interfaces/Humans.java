package Internal.Interfaces;

import Internal.Entities.*;
import java.util.*;

public interface Humans {
  public int getTotal();
  public List<Card> showHand();
  public void hit();
}
