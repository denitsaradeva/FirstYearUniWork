//The class is a simulation of a storage for words.
public class WordGroup {
  private String words;

  public WordGroup(String words) {
    this.words = words.toLowerCase();
  }

  public String[] getWordArray() {
    return words.split(" ");
  }
}
