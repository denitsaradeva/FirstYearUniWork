import java.util.Arrays;

//Simulation of a software engineering student, who has numerous special abilities when attacking.
public class SEStudent extends Student {

  public SEStudent(String name) {
    super(name, 8, 5, 8, 4, 10);
  }

  /**
   * Working in a group is a special ability that the software engineering student has.
   * The student and his/her partner decrease the HP of each member of the enemy's team.
   * The student increases his/her EP by 4 and sets his/her own KP to be 0.
   * If the enemy is killed, additional 4 EP are gained by the student.
   *
   * @param enemy that will be attacked.
   */
  public void groupWork(Character enemy) throws Exception {
    if (!this.getCurrentKP().equals(this.getMaxKP())) {
      throw new Exception("not enough KP!");
    }
    if (enemy.getHP() <= 0 || this.getHP() <= 0) {
      return;
    }
    Arrays.stream(this.getTeam().getMembers()).forEach(entry -> {
      if (entry.getHP() > 0) {
        enemy.decreaseHP((100 * entry.getAttack()) / (100 + enemy.getDefence()));
      }
    });
    this.increaseEP(4);
    this.setCurrentKP(0);
    if (enemy.getHP() <= 0) {
      this.increaseEP(4);
    }
  }

  /**
   * Group discussion a special ability that the software engineering student has.
   * Each student from the team increases his/her HP.
   * The student also increases his/her EP by 4 and sets his/her own KP to be 0.
   */
  public void groupDiscussion() throws Exception {
    if (!this.getCurrentKP().equals(this.getMaxKP())) {
      throw new Exception("not enough KP!");
    }
    Arrays.stream(this.getTeam().getMembers()).forEach(entry -> {
      if (entry.getHP() > 0) {
        entry.increaseHP(this.getDefence() / 2);
      }
    });
    this.increaseEP(4);
    this.setCurrentKP(0);
  }
}
