public class Deer extends Herbivore {
  public Deer(String name, int age) {
    super(name, age);
  }

  @Override
  public void makeNoise() {
    System.out.println("Uff...");
  }
}
