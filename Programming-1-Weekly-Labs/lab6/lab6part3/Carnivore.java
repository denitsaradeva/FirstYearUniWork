public abstract class Carnivore extends Animal {
  public Carnivore(String name, int age) {
    super(name, age);
  }

  public void eat(Food food) throws Exception {
    if (food instanceof Plant) {
      throw new Exception("Carnivores don't eat plants!");
    }
    System.out.println("The animal is eating " + food.getName());
  }
}
