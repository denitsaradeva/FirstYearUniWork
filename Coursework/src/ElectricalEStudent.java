public class ElectricalEStudent extends Student{
  public ElectricalEStudent(String name) {
    super(name, 9, 6, 6, 6, 4);
  }

  /**
   * The ability to electrocute an enemy is available to the electrical students only.
   * The enemy loses half of his HP. The student also sets his/her KP to 0 and receives 4 EP.
   * If the enemy dies, the electrical student receives additional 4 EP.
   *
   * @param enemy the enemy that gets attacked.
   */
  public void electrocute(Character enemy) throws Exception {
    if (!this.getCurrentKP().equals(this.getMaxKP())) {
      throw new Exception("not enough KP!");
    }
    if (enemy.getHP() <= 0) {
      throw new Exception("The enemy is not alive!");
    }

    enemy.decreaseHP(enemy.getHP() / 2);

    if (enemy.getHP() <= 0) {
      this.increaseEP(4);
    }
    this.increaseEP(4);
    this.setCurrentKP(0);
  }
}
