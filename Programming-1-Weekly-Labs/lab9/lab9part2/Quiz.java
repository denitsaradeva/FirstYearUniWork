import java.util.ArrayList;

public class Quiz {
  private FlashCardReader reader;
  private ArrayList<FlashCard> flashCards;


  public Quiz(String fileName) {
    reader = new FlashCardReader(fileName);
    flashCards = reader.getFlashCards();
    play();
  }

  public void play() {
    Toolbox toolbox = new Toolbox();
    flashCards.forEach(entry -> {
      System.out.println(entry.getQuestion());
      String userAnswer = toolbox.readStringFromCmd();
      if (userAnswer.equals(entry.getAnswer())) {
        System.out.println("Your answer is correct!");
      } else {
        System.out.println("Your answer is wrong. The right one is: " + entry.getAnswer());
      }
    });
    System.out.println("");
  }

  public static void main(String[] args) {
    Quiz quizOne = new Quiz("Questions.txt");
  }
}
