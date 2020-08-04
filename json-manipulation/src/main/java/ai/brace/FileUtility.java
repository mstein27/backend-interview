package ai.brace;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileUtility {

  //Gson object should only be instantiated once.
  private static final Gson gson = new Gson();

  //I missed the hint to get the file from resources but I've used this method successfully.
  public static File getFile(String fileName) {
    ClassLoader classLoader = Main.class.getClassLoader();
    return new File(classLoader.getResource(fileName).getFile());
  }

  //I thought about combining this with getFile but decided not to because it would be easier to test and debug.
  public static Response convert(File file) throws FileNotFoundException {
    return gson.fromJson(new FileReader(file), Response.class);
  }

  public static String toJson(Object o) {
    return gson.toJson(o);
  }
}
