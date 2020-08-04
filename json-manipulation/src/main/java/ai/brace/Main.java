package ai.brace;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Main {
  public static void main(String[] args) throws IOException, URISyntaxException {
    // Task 1
    String json1 = "a1.json";
    ClassLoader classLoader = Main.class.getClassLoader();
    File file = new File(classLoader.getResource(json1).getFile());
    Gson gson = new Gson();

    Response response1 = gson.fromJson(new FileReader(file), Response.class);

    List<Text> textDataList = response1.textArray;

    textDataList.sort(new SortById());

    System.out.println("Task 1... \n");

    for (Text text : textDataList) {
      System.out.println(text.textdata);
    }

    System.out.println("Task 2... \n");

    String json2 = "a2.json";
    File file2 = new File(classLoader.getResource(json2).getFile());

    Response response2 = gson.fromJson(new FileReader(file2), Response.class);

    textDataList.addAll(response2.textArray);

    textDataList.sort(new SortById());

    for (Text text : textDataList) {
      System.out.println(text.textdata);
    }

    System.out.println("Task 3... \n");

    Map<String, Integer> counts = new HashMap<>();

    for (Text text : textDataList) {
      String[] words = text.textdata.split(" ");
      for (int i = 0; i < words.length; i++) {
        String word = words[i].replaceAll("[^a-zA-Z]", "").toLowerCase();
        counts.put(word, counts.getOrDefault(word, 0) + 1);
      }
    }

    ArrayList<String> sortedWords = new ArrayList(counts.keySet());
    Collections.sort(sortedWords);

    for (String word : sortedWords) {
      System.out.printf("(%s) : %s%n", word, counts.get(word));
    }

    System.out.println("Task 4... \n");

    ZoneOffset offset = ZoneOffset.UTC;
    LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(Integer.parseInt(response2.lastModified), 0, offset);
    String lastModified = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'").format(localDateTime);

    UUID newUUID = UUID.randomUUID();

    //A copy method for response could be useful.
    Response newResponse = new Response(response1.version, newUUID, lastModified, response1.title, response1.author, response1.translator, response1.releaseDate, response1.language, textDataList);

    System.out.println(gson.toJson(newResponse));

    System.out.println(classLoader.getResource("").getPath());

    FileWriter fileWriter = new FileWriter(classLoader.getResource("").getPath() + "output.json");
    fileWriter.write(gson.toJson(newResponse));
    fileWriter.close();
  }

  public static class SortById implements Comparator<Text> {
    @Override
    public int compare(Text a, Text b) {
      return a.id - b.id;
    }
  }

  public static class SortByString implements Comparator<String> {
    @Override
    public int compare(String a, String b) {
      return a.compareTo(b);
    }
  }
}
