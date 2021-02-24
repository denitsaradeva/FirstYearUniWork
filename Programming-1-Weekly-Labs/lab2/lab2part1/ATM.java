/**
 * ATM class, having functionallity for welcoming the users to the online banking.
 */
public class ATM {

  private Toolbox myToolBox = new Toolbox();
  private Integer bankBalance;

  /**
   * The method welcomes the user to the online banking.
   */
  public void go() {
    System.out.println("Welcome to online ATM banking\n"
            + "How much do you want in your account?\n"
            + "Enter your number");
    this.bankBalance = myToolBox.readIntegerFromCmd();
    System.out.println(this.bankBalance);
  }

  /**
   * The main method invokes the function, welcoming the user, on a newly created ATM object.
   */
  public static void main(String[] args) {
    ATM myATM = new ATM();
    myATM.go();
  }

}