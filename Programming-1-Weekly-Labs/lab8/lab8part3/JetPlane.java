/*
The JetPlane class is a child of the Transport class because it's a type of transport.
Moreover, it implements the Refuelable interface because it's refueled after each flight.
 */
public class JetPlane extends Transport implements Refuelable {
  private Integer fuel;

  public JetPlane(String model, String yearOfCreation, Integer fuel) {
    super(model, yearOfCreation);
    this.fuel = fuel;
  }

  public Integer getFuel() {
    return fuel;
  }

  public void setFuel(Integer fuel) {
    this.fuel = fuel;
  }

  @Override
  public void refuel() {
    this.fuel+=600;
  }

  @Override
  public void drive() {
    System.out.println("The plane starts flying.");
  }
}
