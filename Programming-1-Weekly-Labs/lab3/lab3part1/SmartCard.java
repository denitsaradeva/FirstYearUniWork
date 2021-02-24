public class SmartCard {

  private String owner;
  private boolean isStaff;

  public boolean isStaff() {
    return isStaff;
  }

  public void setStaff(boolean staff) {
    isStaff = staff;
  }

  public SmartCard(String owner) {
    this.owner = owner;
    this.isStaff = false;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public static void main(String[] args) {
    SmartCard smartCard = new SmartCard("Deni");
  }

}


