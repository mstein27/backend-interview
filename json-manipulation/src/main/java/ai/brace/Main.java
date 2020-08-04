package ai.brace;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
  public static void main(String[] args) throws FileNotFoundException {
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
  }

  public static class SortById implements Comparator<Text> {
    @Override
    public int compare(Text a, Text b) {
      return a.id - b.id;
    }
  }
}
