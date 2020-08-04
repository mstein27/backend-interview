package ai.brace;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtility {
  //These objects are reused and should only be instantiated once.
  private static final Gson gson = new Gson();
  private static final ClassLoader classLoader = Main.class.getClassLoader();

  //I missed the hint to get the file from resources but I've used this method successfully.
  public static File getFile(String fileName) {
    return new File(classLoader.getResource(fileName).getFile());
  }

  //I thought about combining this with getFile but decided not to because it would be easier to test and debug.
  public static Response convert(File file) throws FileNotFoundException {
    return gson.fromJson(new FileReader(file), Response.class);
  }

  public static String toJson(Object o) {
    return gson.toJson(o);
  }

  public static void write(Response response) throws IOException {
    //This saves to the build package instead of resources.
    FileWriter fileWriter = new FileWriter(classLoader.getResource("").getPath() + "output.json");
    fileWriter.write(gson.toJson(response));
    fileWriter.flush();
    fileWriter.close();
  }
}
