package ai.brace;

import java.util.List;
import java.util.UUID;

//I named this class Response because I'm imagining this class to represent json in a response body but something more specific would be better.
public class Response {

  //These properties are public for easy access. They could be made private for encapsulation.
  public String version;
  public UUID uuid;
  public String lastModified;
  public String title;
  public String author;
  public String translator;
  public String releaseDate;
  public String language;
  public List<Text> textArray;

  //This constructor is kind of long so a builder pattern would be nice here.
  public Response(String version, UUID uuid, String lastModified, String title, String author, String translator, String releaseDate, String language, List<Text> textArray) {
    this.version = version;
    this.uuid = uuid;
    this.lastModified = lastModified;
    this.title = title;
    this.author = author;
    this.translator = translator;
    this.releaseDate = releaseDate;
    this.language = language;
    this.textArray = textArray;
  }
}