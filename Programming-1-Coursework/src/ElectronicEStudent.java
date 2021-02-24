public class ElectronicEStudent extends Student {
  public ElectronicEStudent(String name) {
    super(name, 6, 7, 6, 4, 6);
  }

  /**
   * The stop current ability is available to the electronic students only.
   * The enemy loses 3 of his HP. The student also sets his/her KP to 0 and receives 4 EP.
   * If the enemy dies, the electronic student receives additional 4 EP.
   *
   * @param enemy the enemy that gets attacked.
   */
  public void stopCurrent(Character enemy) throws Exception {
    if (!this.getCurrentKP().equals(this.getMaxKP())) {
      throw new Exception("not enough KP!");
    }
    if (enemy.getHP() <= 0) {
      throw new Exception("The enemy is not alive!");
    }

    enemy.decreaseHP(3);

    if (enemy.getHP() <= 0) {
      this.increaseEP(4);
    }
    this.increaseEP(4);
    this.setCurrentKP(0);
  }
}