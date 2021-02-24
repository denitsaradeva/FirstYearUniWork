public class CSStudent extends Student {
  //Simulation of a computer science student, who has numerous special abilities when attacking.
  public CSStudent(String name) {
    super(name, 7, 6, 6, 6, 4);
  }

  /**
   * The ability to work with a friend is available to the computer science students only.
   * By attacking the enemy by two characters, he/she loses double HP. The CSStudent receives 4 EP.
   * The student also sets his/her KP to 0. If the enemy dies, the CSStudent gets 4 EP.
   *
   * @param friend the student who will help.
   * @param enemy  the enemy that gets attacked.
   */
  public void pairWorking(Character friend, Character enemy) throws Exception {
    if (!this.getCurrentKP().equals(this.getMaxKP())) {
      throw new Exception("not enough KP!");
    }
    if (friend.getHP() <= 0) {
      throw new Exception("The friend is not alive!");
    }
    enemy.decreaseHP((100 * this.getAttack()) / (100 + enemy.getDefence()));
    enemy.decreaseHP((100 * friend.getAttack()) / (100 + enemy.getDefence()));
    if (enemy.getHP() <= 0) {
      this.increaseEP(4);
    }
    this.increaseEP(4);
    this.setCurrentKP(0);
  }

  /**
   * The support ability is available for CSStudents only. By using it, they heal a friend with the amount
   * of their defence. The CSStudent's EP gets increased by 4 and their KP becomes 0.
   *
   * @param friend who will be supported
   */
  public void support(Character friend) throws Exception {
    if (!this.getCurrentKP().equals(this.getMaxKP())) {
      throw new Exception("not enough KP!");
    }
    if (friend.getHP() <= 0) {
      throw new Exception("The friend is not alive!");
    }
    friend.increaseHP(this.getDefence());
    this.increaseEP(4);
    this.setCurrentKP(0);
  }
}
