/*
The Tricycle class extends the Cycle class because it is a specific type of cycle,
moving with three wheels. Moreover, it drives on roads and that's why it implements
the RoadVehicle interface.
 */
public class Tricycle extends Cycle implements RoadVehicle {
  private Integer wheelNumber;

  public Tricycle(String model, String yearOfCreation, Integer wheelNumber) {
    super(model, yearOfCreation);
    this.wheelNumber = wheelNumber;
  }

  @Override
  public Integer getWheelNumber() {
    return this.wheelNumber;
  }

  @Override
  public void setWheelNumber(Integer wheelNumber) {
    this.wheelNumber = wheelNumber;
  }

  @Override
  public void drive() {
    System.out.println("The tricycle starts moving.");
  }
}
