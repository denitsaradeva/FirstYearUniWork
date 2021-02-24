public class Main {
  /**
   * Testing getWordArray() method.
   */
  public static void main(String[] args) {

    WordGroup firstInstance = new WordGroup("You can discover more about a person "
        + "in an hour of play than in a year of conversation");
    WordGroup secondInstance = new WordGroup("When you play play hard when you work dont "
        + "play at all");
    String[] firstInstanceArray = firstInstance.getWordArray();
    String[] secondInstanceArray = secondInstance.getWordArray();

    for (int i = 0; i < firstInstanceArray.length; i++) {
      System.out.println(firstInstanceArray[i]);
    }

    for (int i = 0; i < secondInstanceArray.length; i++) {
      System.out.println(secondInstanceArray[i]);
    }

  }
}
