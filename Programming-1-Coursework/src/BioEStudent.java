public class BioEStudent extends Student {
  public BioEStudent(String name) {
    super(name, 8, 7, 6, 6, 5);
  }

  /**
   * The poison ability is available for biomedical electronic engineering students only.
   * The student reduces the hit points of each of all minions by 1.
   * The student's EP gets increased by 4 and their KP becomes 0. If a minion dies, the students gets 4 more EP.
   *
   * @param enemyTeam the enemy team that gets attacked.
   */
  public void poison(Team enemyTeam) throws Exception {
    if (!this.getCurrentKP().equals(this.getMaxKP())) {
      throw new Exception("not enough KP!");
    }

    enemyTeam.getMembersArray().forEach(entry -> {
      if (entry instanceof Minion) {
        entry.decreaseHP(1);
      }
      if (entry.getHP() <= 0) {
        this.increaseEP(4);
      }
    });

    this.increaseEP(4);
    this.setCurrentKP(0);
  }

  /**
   * The tech cure ability is available for biomedical electronic engineering students only.
   * Each alive member of the student's team increases his/her HP by half of his/her attack points.
   * The student's EP gets increased by 4 and their KP becomes 0.
   */
  public void techCure() throws Exception {
    if (!this.getCurrentKP().equals(this.getMaxKP())) {
      throw new Exception("not enough KP!");
    }

    this.getTeam().getMembersArray().forEach((entry) -> {
      if (entry.getHP() > 0) {
        entry.increaseHP(entry.getAttack() / 2);
      }
    });

    this.increaseEP(4);
    this.setCurrentKP(0);
  }
}
