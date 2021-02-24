import java.util.HashSet;

//The class is a simulation of a storage for words.
public class WordGroup {
  private String words;

  public WordGroup(String words) {
    this.words = words.toLowerCase();
  }

  public String[] getWordArray() {
    return words.split(" ");
  }

  public String getWords() {
    return words;
  }

  public void setWords(String words) {
    this.words = words;
  }

  /**
   * The method returns a HashSet, containing all words from two WordGroup classes.
   */
  public HashSet<String> getWordSet(WordGroup wordGroup) {
    HashSet<String> setOfWords = new HashSet<String>();
    for (int i = 0; i < wordGroup.getWordArray().length; i++) {
      setOfWords.add(wordGroup.getWordArray()[i]);
    }
    for (int i = 0; i < this.getWordArray().length; i++) {
      setOfWords.add(this.getWordArray()[i]);
    }
    return setOfWords;
  }
}
