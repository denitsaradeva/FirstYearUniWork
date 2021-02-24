import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FlashCardReader {
  private BufferedReader reader;

  public FlashCardReader(String fileName) {

    try {
      reader = new BufferedReader(new FileReader(fileName));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

  }

  public String getLine() {
    String line = "";
    try {
      line = this.reader.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return line;
  }

  public Boolean fileIsReady() {
    if (reader == null) {
      return false;
    }
    boolean isReady = false;
    try {
      isReady = reader.ready();
      return isReady;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return isReady;
  }
}
