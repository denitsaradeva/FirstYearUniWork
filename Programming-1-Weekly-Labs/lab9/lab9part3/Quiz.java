import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
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
    ArrayList<String> userAnswers = new ArrayList<>();
    Toolbox toolbox = new Toolbox();
    System.out.println("Do you want to save your results?");
    String response = toolbox.readStringFromCmd();
    boolean shouldSave = false;
    if (response.equals("Y")) {
      shouldSave = true;
    }
    boolean finalShouldSave = shouldSave;
    flashCards.forEach(entry -> {
      System.out.println(entry.getQuestion());
      String userAnswer = toolbox.readStringFromCmd();
      if (finalShouldSave) {
        userAnswers.add(userAnswer);
      }
      if (userAnswer.equals(entry.getAnswer())) {
        System.out.println("Your answer is correct!");
      } else {
        System.out.println("Your answer is wrong. The right one is: " + entry.getAnswer());
      }
    });
    if (finalShouldSave) {
      save(userAnswers);
    }
    System.out.println("");
  }

  public void save(ArrayList<String> answers) {
    int count = 0;
    try {
      File file = new File("save.txt");
      if (file.exists()) {
        PrintWriter printWriter = new PrintWriter(file);
        printWriter.print("");
        printWriter.close();
      }
      PrintStream printStream = new PrintStream(file);
      for (int i = 0; i < this.flashCards.size(); i++) {
        if (answers.get(i).equals(this.flashCards.get(i).getAnswer())) {
          count++;
          printStream.println(this.flashCards.get(i).getQuestion() + "," + answers.get(i) + ",right");
        } else {
          printStream.println(this.flashCards.get(i).getQuestion() + "," + answers.get(i) + ",wrong");
        }
      }
      double percentage=((count+0.0)/flashCards.size())*100;
      printStream.print(count+","+flashCards.size()+","+percentage);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    Quiz quizOne = new Quiz("Questions.txt");
  }
}
