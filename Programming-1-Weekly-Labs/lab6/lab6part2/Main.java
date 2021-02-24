public class Main {
  public static void main(String[] args) {
    Wolf wolf = new Wolf("First Wolf", 1);
    Parrot parrot = new Parrot("First Parrot", 4);
    System.out.printf("The wolf's name is: %s and is %d years old.%n", wolf.getName(), wolf.getAge());
    System.out.printf("The parrot's name is: %s and is %d years old.%n", parrot.getName(), parrot.getAge());
    Meat meat = new Meat("meat");
    Plant plant = new Plant("plant");
    parrot.makeNoise();
    wolf.makeNoise();
  }
}
