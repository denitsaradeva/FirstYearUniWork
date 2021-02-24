/**
 * Simulating a guessing game, where the user guesses a random number.
 */
public class GuessingGame {
  /**
   * After generating a random number from [1,10], the program gives hints to the user to guess it.
   */
  public static void main(String[] args) {

    Integer guessedNumber;
    Toolbox myToolbox = new Toolbox();
    Integer numberToGuess = myToolbox.getRandomInteger(10);

    System.out.println("Welcome to Guessing Game");

    guessedNumber = myToolbox.readIntegerFromCmd();

    if (guessedNumber > numberToGuess) {
      System.out.println("too high");
    } else if (guessedNumber.equals(numberToGuess)) {
      System.out.println("right");
    } else {
      System.out.println("too low");
    }

  }
}
