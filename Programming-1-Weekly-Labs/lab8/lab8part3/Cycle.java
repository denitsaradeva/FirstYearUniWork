/*
I chose the Cycle class to be an abstract one because it's an abstraction for all
possible types of Cycles (in our case - bicycles and tricycles). It's a child of the Transport class,
since all cycles are types of transport. Moreover, it implements the RoadVehicle interface because
all cycles have the behaviour of road vehicles.
 */
public abstract class Cycle extends Transport implements RoadVehicle {
  private String tiers;

  public Cycle(String model, String yearOfCreation) {
    super(model, yearOfCreation);
    setTiers();
  }

  public String getTiers() {
    return tiers;
  }

  public void setTiers(String tiers) {
    this.tiers = tiers;
  }

  public abstract Integer getWheelNumber();

  public abstract void setWheelNumber(Integer wheelNumber);

  @Override
  public void setTiers() {
    if (isSummer()) {
      this.tiers = "Summer Tiers";
    } else {
      this.tiers = "Winter Tiers";
    }
  }
}
