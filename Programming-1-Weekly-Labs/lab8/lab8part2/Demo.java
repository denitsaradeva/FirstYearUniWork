import java.util.ArrayList;
import java.util.Collections;

public class Demo {
  public static void main(String[] args) {
    ArrayList<Animal> animals = new ArrayList<>();
    Parrot firstParrot = new Parrot(5);
    Animal firstDeer = new Deer("Deery", 10);
    Wolf firstWolf = new Wolf();
    Wolf secondWolf = new Wolf("Woolfy", 5);
    animals.add(firstParrot);
    animals.add(firstDeer);
    animals.add(firstWolf);
    animals.add(secondWolf);
    for (int i = 0; i < animals.size(); i++) {
      System.out.printf("Name: "+animals.get(i).getName()+"%nAge: %d", animals.get(i).getAge());
      System.out.println();
    }
    System.out.println();
    /**
     * An interface in Java is like an instruction for what the classes that
     * implement it will contain and how will they look like. It's different from an abstract
     * class because in abstract classes you can implement some methods, while in interfaces
     * you don't implement any method.
     */
    Collections.sort(animals);
    for (int i = 0; i < animals.size(); i++) {
      System.out.printf("Name: "+animals.get(i).getName()+"%nAge: %d", animals.get(i).getAge());
      System.out.println();
    }
  }
}
