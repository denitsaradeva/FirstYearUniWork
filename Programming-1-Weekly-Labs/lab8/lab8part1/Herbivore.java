public abstract class Herbivore extends Animal {
  public Herbivore(String name, int age) {
    super(name, age);
  }

  public void eat(Food food) throws Exception {
    if (food instanceof Meat) {
      throw new Exception("Herbivores don't eat meat!");
    }
    System.out.println("The animal is eating " + food.getName());
  }
}
