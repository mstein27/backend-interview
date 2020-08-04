package ai.brace;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DateTimeUtility {

  public static String convertEpochToISO(int epoch) {
    ZoneOffset offset = ZoneOffset.UTC;
    LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(epoch, 0, offset);

    //Use a datetime formatter to get proper ISO format.
    return DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'").format(localDateTime);
  }
}
