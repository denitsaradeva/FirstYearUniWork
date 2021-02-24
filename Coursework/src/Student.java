//Simulation of a student, which is a type of character in the game.
public class Student extends Character {
  private final Integer maxKP;
  private Integer currentKP;

  public Student(String name, int baseHP, int baseAtk, int baseDef, int baseSpd, int maxKP) {
    super(name, baseHP, baseAtk, baseDef, baseSpd);
    this.maxKP = maxKP;
    this.currentKP = 0;
  }

  public Integer getMaxKP() {
    return maxKP;
  }

  public void setCurrentKP(Integer currentKP) {
    this.currentKP = currentKP;
  }

  public Integer getCurrentKP() {
    return currentKP;
  }

  public void increaseKP(int amount) {
    if (currentKP + amount > 0 && currentKP + amount <= maxKP) {
      currentKP += amount;
    }
  }

  /**
   * The student increases his/her EP and KP points and gains additional 4 EP if the enemy dies.
   * The enemy has his/her hit points decreased and EP are increased.
   * The enemy has his/her KP increased by 3 if he/she is a student.
   */
  public void javaProgramming(Character enemy) {
    this.increaseEP(3);
    this.increaseKP(1);
    enemy.decreaseHP((100 * this.getAttack()) / (100 + enemy.getDefence()));
    enemy.increaseEP(2);
    if (enemy instanceof Student) {
      ((Student) enemy).increaseKP(3);
    }
    if (enemy.getHP() == 0) {
      this.increaseEP(4);
    }
  }

  /**
   * The student has his/her HP, EP, and KP increased by respectively 2,6,2.
   */
  public void selfStudy() {
    this.increaseHP(2);
    this.increaseEP(6);
    this.increaseKP(2);
  }
}
