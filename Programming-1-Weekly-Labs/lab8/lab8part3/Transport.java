/*
I chose Transport to be the parent class for all other classes because it's the biggest abstraction.
That's also the reason for why I made it to be abstract.
 */
public abstract class Transport {
  private String model;
  private String yearOfCreation;

  public Transport(String model, String yearOfCreation) {
    this.model = model;
    this.yearOfCreation = yearOfCreation;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getYearOfCreation() {
    return yearOfCreation;
  }

  public void setYearOfCreation(String yearOfCreation) {
    this.yearOfCreation = yearOfCreation;
  }

  public boolean isSummer() {
    double randomNumber = Math.random() * 100;
    if (randomNumber >= 1 && randomNumber < 50) {
      return true;
    } else {
      return false;
    }
  }

  public abstract void drive();
}
