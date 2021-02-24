public class AIStudent extends Student {
  //Simulation of an artificial intelligence student, who has numerous special abilities when attacking.
  public AIStudent(String name) {
    super(name, 6, 7, 7, 5, 4);
  }

  /**
   * The machine learning is an ability that artificial intelligence students have.
   * It decreases the enemy's HP and the AI student receives 4 EP and sets his/her KP to 0.
   * If the enemy dies, the AI student gets 4 bonus EP.
   *
   * @param enemy the enemy that will be attacked.
   */
  public void machineLearning(Character enemy) throws Exception {
    if (!this.getCurrentKP().equals(this.getMaxKP())) {
      throw new Exception("not enough KP!");
    }
    if (enemy.getHP() <= 0) {
      throw new Exception("The enemy is not alive!");
    }
    enemy.decreaseHP(2 * (100 * this.getAttack()) / (100 + enemy.getDefence()));
    if (enemy.getHP() <= 0) {
      this.increaseEP(4);
    }
    this.increaseEP(4);
    this.setCurrentKP(0);
  }

  /**
   * The natural learning processing is an ability that artificial intelligence students have.
   * It increases the student's HP by the student's defence and his/her EP by 4. It also sets the KP to 0.
   */
  public void naturalLanguageProcessing() throws Exception {
    if (!this.getCurrentKP().equals(this.getMaxKP())) {
      throw new Exception("not enough KP!");
    }
    this.increaseHP(this.getDefence());
    this.increaseEP(4);
    this.setCurrentKP(0);
  }
}
