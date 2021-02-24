public abstract class Animal {
  private String name;
  private int age;

  public Animal(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public Animal() {
    this("newborn", 0);
  }

  public abstract void makeNoise();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public abstract void eat(Food food) throws Exception;

  public void eat(Food food, Integer amount) throws Exception {
    for (int i = 0; i < amount; i++) {
      this.eat(food);
    }
  }
}
