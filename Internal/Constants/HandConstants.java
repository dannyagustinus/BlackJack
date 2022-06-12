package Internal.Constants;

import java.util.*;

public class HandConstants {
  public static final int TWENTY_ONE = 21;
  public static final int ACE_ELEVEN = 11;

  public static final Map<String, Integer> VALUES_TO_INT = new HashMap<>() {{
    put("Ace", 1);
    put("Two", 2);
    put("Three", 3);
    put("Four", 4);
    put("Five", 5);
    put("Six", 6);
    put("Seven", 7);
    put("Eight", 8);
    put("Nine", 9);
    put("Ten", 10);
    put("Jack", 10);
    put("Queen", 10);
    put("King", 10);
  }};
}