/**
 * ATM class, simulating the functionality of a real ATM when an user interacts with it.
 */
public class ATM {

  private Toolbox myToolBox = new Toolbox();
  private Integer bankBalance;

  /**
   * The method welcomes the user to the online banking and asks him how he wants to proceed.
   * Edge cases are handled.
   */
  public void go() {
    System.out.println("Welcome to online ATM banking\n"
            + "How much do you want in your account?\n"
            + "Enter your number");
    bankBalance = myToolBox.readIntegerFromCmd();

    while (true) {
      if (bankBalance < 0) {
        bankBalance = myToolBox.readIntegerFromCmd();
      } else {
        break;
      }
    }

    System.out.println(bankBalance);
    System.out.println("What do you want to do?\n"
            + "1 : Withdraw\n"
            + "2 : Deposit\n"
            + "3 : Inquire\n"
            + "4 : Quit\n"
            + "Enter your number");
    int choice = myToolBox.readIntegerFromCmd();

    if (choice == 1) {
      withdraw();
    } else if (choice == 2) {
      deposit();
    } else if (choice == 3) {
      inquire();
    } else if (choice == 4) {
      quit();
    }

  }

  /**
   * The method deals with bank withdrawals and reflects the changes on the user's bank balance.
   * Edge cases are handled.
   */
  public void withdraw() {
    System.out.print("*****************************************\n"
            + "              Withdrawal                 \n"
            + "*****************************************\n"
            + "How much would you like to withdraw?\n"
            + "Enter your number\n");
    Integer withdrawValue = myToolBox.readIntegerFromCmd();

    while (true) {
      if (withdrawValue > 0 && bankBalance - withdrawValue > 0) {
        bankBalance = bankBalance - withdrawValue;
        break;
      } else if (withdrawValue < 0 || bankBalance - withdrawValue < 0) {
        withdrawValue = myToolBox.readIntegerFromCmd();
      }
    }

    System.out.printf("*****************************************\n"
            + "         Your new balance is %d        \n", bankBalance);
    System.out.println("*****************************************");
    System.exit(0);
  }

  /**
   * The method deals with bank deposits and reflects the changes on the user's bank balance.
   */
  public void deposit() {
    System.out.println("*****************************************\n"
            + "              Deposit                 \n"
            + "*****************************************\n"
            + "How much would you like to deposit?\n"
            + "Enter your number\n");
    Integer depositValue = myToolBox.readIntegerFromCmd();

    while (true) {
      if (depositValue > 0 && bankBalance + depositValue > 0) {
        bankBalance = bankBalance + depositValue;
        break;
      } else if (depositValue < 0 || bankBalance + depositValue < 0) {
        depositValue = myToolBox.readIntegerFromCmd();
      }
    }

    System.out.printf("*****************************************\n"
            + "         Your new balance is %d       \n", bankBalance);
    System.out.println("*****************************************");
    System.exit(0);
  }

  /**
   * The method informs the user of his current bank account balance.
   */
  public void inquire() {
    System.out.printf("*****************************************\n"
            + "          Your balance is %d       \n"
            + "*****************************************", bankBalance);
    System.exit(0);
  }

  /**
   * The method ends the online activity the user is having.
   */
  public void quit() {
    System.out.println("******************************************\n"
            + "         GoodBye!\n"
            + "******************************************");
    System.exit(0);
  }

  /**
   * The main method invokes the function, welcoming the user, on a newly created ATM object.
   */
  public static void main(String[] args) {
    ATM myATM = new ATM();
    myATM.go();
  }

}
