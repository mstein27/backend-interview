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

    Response response = gson.fromJson(new FileReader(file), Response.class);

    List<Text> textDataList = response.textArray;

    textDataList.sort(new SortById());

    for (Text text : textDataList) {
      System.out.println(text.id);
    }


//        JsonReader jsonReader = new JsonReader(new FileReader("jsonFile.json"));
//
//        jsonReader.beginObject();
//
//
//
//        while (jsonReader.hasNext()) {
//
//            String name = jsonReader.nextName();
//            if (name.equals("descriptor")) {
//                readApp(jsonReader);
//
//            }
//        }
//
//        jsonReader.endObject();
//        jsonReader.close();

//        Response response = gson.fromJson(yourJson, Response.class);

      System.out.println("Hello, world.");
  }

  public static class SortById implements Comparator<Text> {
    @Override
    public int compare(Text a, Text b) {
      return a.id - b.id;
    }
  }
}
