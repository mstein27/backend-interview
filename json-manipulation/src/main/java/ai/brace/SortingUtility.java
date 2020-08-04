package ai.brace;

import java.util.Comparator;

public class SortingUtility {

  public static Comparator<Text> sortTextById() {
    //This is a nice compact comparator.
    return Comparator.comparingInt(a -> a.id);
  }

}
