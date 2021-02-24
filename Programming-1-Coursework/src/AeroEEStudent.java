public class AeroEEStudent extends Student {
  public AeroEEStudent(String name) {
    super(name, 6, 6, 6, 6, 6);
  }

  /**
   * The parachute attack ability is available for aerospace electronic engineering students only.
   * The student reduces the hit points of each of all bosses by 1.
   * The student's EP gets increased by 4 and their KP becomes 0. If a minion dies, the students gets 4 more EP.
   *
   * @param enemyTeam the enemy team that gets attacked.
   */
  public void parachuteAttack(Team enemyTeam) throws Exception {
    if (!this.getCurrentKP().equals(this.getMaxKP())) {
      throw new Exception("not enough KP!");
    }

    enemyTeam.getMembersArray().forEach(entry -> {
      if (entry instanceof Boss) {
        entry.decreaseHP(1);
      }
      if (entry.getHP() <= 0) {
        this.increaseEP(4);
      }
    });

    this.increaseEP(4);
    this.setCurrentKP(0);
  }
}
