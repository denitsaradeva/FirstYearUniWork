public class Main {
  /**
   * Multiplying a number from the input by all numbers from 1 to 20.
   */
  public static void main(String[] args) {
    Toolbox toolbox = new Toolbox();
    int input = toolbox.readIntegerFromCmd();

    for (int i = 1; i < 21; i++) {
      System.out.print(input * i + " ");
    }

    System.out.println();
    int sum = 0;
    int number = 0;
    int count = 0;

    while (sum <= 500) {
      number++;
      sum += number;
      count++;
    }

    System.out.println(count);
  }
}
