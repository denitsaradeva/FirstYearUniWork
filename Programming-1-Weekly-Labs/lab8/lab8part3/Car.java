/*
The Car class is a child of the Transport class because it's a type of transport.
Moreover, it implements the Refuelable and RoadVehicle interfaces because
it's both refuelable and it's a type of road vehicle because it's driven on roads.
 */
public class Car extends Transport implements Refuelable, RoadVehicle {
  private Integer fuel;
  private String tiers;

  public Car(String model, String yearOfCreation, Integer fuel) {
    super(model, yearOfCreation);
    setTiers();
    this.fuel = fuel;
  }

  public Integer getFuel() {
    return fuel;
  }

  public void setFuel(Integer fuel) {
    this.fuel = fuel;
  }

  public String getTiers() {
    return tiers;
  }

  public void setTiers(String tiers) {
    this.tiers = tiers;
  }

  @Override
  public void refuel() {
    this.fuel+=100;
  }

  @Override
  public void setTiers() {
    if (isSummer()) {
      this.tiers = "Summer Tiers";
    } else {
      this.tiers = "Winter Tiers";
    }
  }

  @Override
  public void drive() {
    System.out.println("The car starts driving.");
  }
}
