/**
 * ATM class, simulating the functionality of a real ATM when an user interacts with it.
 */
public class ATM {

  private Toolbox myToolBox = new Toolbox();
  private Integer bankBalance;

  /**
   * The method welcomes the user to the online banking and asks him how he wants to proceed.
   */
  public void go() {
    System.out.println("Welcome to online ATM banking\n"
            + "How much do you want in your account?\n"
            + "Enter your number");
    bankBalance = myToolBox.readIntegerFromCmd();
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
   */
  public void withdraw() {
    System.out.print("*****************************************\n"
            + "              Withdrawal                 \n"
            + "*****************************************\n"
            + "How much would you like to withdraw?\n"
            + "Enter your number\n");
    Integer withdrawValue = myToolBox.readIntegerFromCmd();
    this.bankBalance -= withdrawValue;
    System.out.printf("*****************************************\n"
            + "         Your new balance is %d        \n", this.bankBalance);
    System.out.println("*****************************************");
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
    this.bankBalance += depositValue;
    System.out.printf("*****************************************\n"
            + "         Your new balance is %d       \n", this.bankBalance);
    System.out.println("*****************************************");
  }

  /**
   * The method informs the user of his current bank account balance.
   */
  public void inquire() {
    System.out.printf("*****************************************\n"
            + "          Your balance is %d       \n"
            + "*****************************************", bankBalance);
  }

  /**
   * The method ends the online activity the user is having.
   */
  public void quit() {
    System.out.println("******************************************\n"
            + "         GoodBye!\n"
            + "******************************************");
  }

  /**
   * The main method invokes the function, welcoming the user, on a newly created ATM object.
   */
  public static void main(String[] args) {
    ATM myATM = new ATM();
    myATM.go();
  }

}