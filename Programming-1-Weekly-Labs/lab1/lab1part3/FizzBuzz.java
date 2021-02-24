/**
 * Simulating the Fizz Buzz game, which teaches about division.
 */
public class FizzBuzz { //Declaring a class "FizzBuzz" with a "public" access modifier, allowing everyone to access it.
  /**
   * Rules of the game are based on division with 3 and 5.
   *
   * @param args an array of Strings that come from the command-line
   */
  public static void main(String[] args) { //Declaring the main method, which allows JVM to execute the code.

    /**
     * A for-loop with initialized control variable "i" and the loop will be executed 60 times until "i" becomes 60.
     * "i" gets incremented by 1 each cycle.
     */
    for (int i = 1; i < 61; i++) {
      System.out.println(); //Printing an empty line, hence going onto a new line.

      if (i % 3 != 0 && i % 5 != 0) { //Conditional statement "if", checking if "i" is NOT divisible by both 3 and 5.
        System.out.print(i); //Printing the current value of the variable "i".
      } //Closing the body of the conditional statement with a curly bracket.
      if (i % 3 == 0) { //Conditional statement "if", checking if the variable "i" is divisible by 3.
        System.out.print("Fizz"); //Printing the message "Frizz" as an output.
      } //Closing the body of the conditional statement with a curly bracket.
      if (i % 5 == 0) { //Conditional statement "if", checking if the variable "i" is divisible by 5.
        System.out.print("Buzz"); //Printing the message "Buzz" as an output.
      } //Closing the body of the conditional statement with a curly bracket.

    } //Closing the body of the for cycle.
  } //Closing the body of the main method.
} //Closing the body of the class.