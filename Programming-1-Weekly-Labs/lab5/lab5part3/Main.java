import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
  /**
   * Testing the newly created classes and methods.Working with sets and maps.
   */
  public static void main(String[] args) {

    WordGroup firstInstance = new WordGroup("You can discover more about a person "
        + "in an hour of play than in a year of conversation");
    WordGroup secondInstance = new WordGroup("When you play play hard when you work "
        + "dont play at all");
    String[] firstInstanceArray = firstInstance.getWordArray();
    String[] secondInstanceArray = secondInstance.getWordArray();

    for (int i = 0; i < firstInstanceArray.length; i++) {
      System.out.println(firstInstanceArray[i]);
    }

    for (int i = 0; i < secondInstanceArray.length; i++) {
      System.out.println(secondInstanceArray[i]);
    }

    for (String word : firstInstance.getWordSet(secondInstance)) {
      System.out.println(word);
    }

    HashMap<String, Integer> firstMap = firstInstance.getWordCounts();

    System.out.println();
    System.out.println("Keys and values from first HashMap:");

    for (String entry : firstMap.keySet()) {
      System.out.println(entry + ": " + firstMap.get(entry));
    }

    System.out.println();
    System.out.println("Keys and values from second HashMap:");

    HashMap<String, Integer> secondMap = secondInstance.getWordCounts();
    for (String entry : secondMap.keySet()) {
      System.out.println(entry + ": " + secondMap.get(entry));
    }
    System.out.println();
    System.out.println("Keys and values from both HashMaps:");
    HashMap<String, Integer> combinedMap = new HashMap<>();

    for (int i = 0; i < firstMap.keySet().size(); i++) {
      firstMap.forEach(combinedMap::put);
    }

    for (String entry : secondMap.keySet()) {
      if (combinedMap.containsKey(entry)) {
        combinedMap.replace(entry, combinedMap.get(entry) + secondMap.get(entry));
      } else {
        combinedMap.put(entry, secondMap.get(entry));
      }
    }

    combinedMap.forEach((k, v) -> {
      System.out.println(k + ": " + v);
    });
  }
}
