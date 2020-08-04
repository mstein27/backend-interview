package ai.brace;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyUtility {

  public static Map<String, Integer> getCounts(List<Text> textDataList) {
    Map<String, Integer> counts = new HashMap<>();

    //I attempted to do this in Streams but it wasn't cleaner looking and it didn't reduce complexity so I left the two for loops.
    for (Text text : textDataList) {
      String[] words = text.textdata.split(" ");
      for (int i = 0; i < words.length; i++) {
        //Clean up the key values to only include letters and convert them to lower case.
        String word = words[i].replaceAll("[^a-zA-Z]", "").toLowerCase();
        counts.put(word, counts.getOrDefault(word, 0) + 1);
      }
    }

    return counts;
  }
}
