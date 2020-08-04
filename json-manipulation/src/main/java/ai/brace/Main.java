package ai.brace;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Main {
  public static void main(String[] args) {

    //I used static methods to break up the logic in this file.

    //Task 1
    System.out.println("\nTask 1... \n");

    File file1 = FileUtility.getFile("a1.json");

    Response response1 = null;
    try {
      response1 = FileUtility.convert(file1);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    Comparator<Text> sortyById = SortingUtility.sortTextById();

    List<Text> textDataList = response1.textArray;
    textDataList.sort(sortyById);

    for (Text text : textDataList) {
      System.out.println(text.textdata);
    }

    //Task 2
    System.out.println("\nTask 2... \n");

    File file2 = FileUtility.getFile("a2.json");
    Response response2 = null;
    try {
      response2 = FileUtility.convert(file2);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    //Combine two text arrays and sort them again.
    textDataList.addAll(response2.textArray);
    textDataList.sort(sortyById);

    textDataList.forEach(text -> System.out.println(text.textdata));

    //Task 3
    System.out.println("\nTask 3... \n");

    Map<String, Integer> counts = FrequencyUtility.getCounts(textDataList);

    //Create an array list to print out the words in order.
    ArrayList<String> sortedWords = new ArrayList(counts.keySet());
    Collections.sort(sortedWords);

    sortedWords.forEach(word -> System.out.printf("(%s) : %s%n", word, counts.get(word)));

    System.out.println("\nTask 4... \n");

    int epoch = Integer.parseInt(response2.lastModified);
    String lastModified = DateTimeUtility.convertEpochToISO(epoch);

    UUID newUUID = UUID.randomUUID();

    //A copy method for response could be useful.
    Response newResponse = new Response(response1.version, newUUID, lastModified, response1.title, response1.author, response1.translator, response1.releaseDate, response1.language, textDataList);

    System.out.println(FileUtility.toJson(newResponse));

//    FileWriter fileWriter = new FileWriter(classLoader.getResource("").getPath() + "output.json");
//    fileWriter.write(gson.toJson(newResponse));
//    fileWriter.close();
  }


}
