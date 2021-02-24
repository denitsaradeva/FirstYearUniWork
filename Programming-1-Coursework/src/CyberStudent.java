import java.util.Arrays;

//Simulation of a cyber security student, who has numerous special abilities when attacking.
public class CyberStudent extends Student {

  public CyberStudent(String name) {
    super(name, 7, 7, 5, 6, 6);
  }

  /**
   * The cyber attack is available only fot the cyber security students. By using it, they decrease the enemy's HP
   * and if an enemy dies, they receive 4 EP. Moreover, additional 4 EP are gained and the EP is set to 0.
   *
   * @param enemyTeam that gets attacked
   */
  public void cyberAttack(Team enemyTeam) throws Exception {
    if (!this.getCurrentKP().equals(this.getMaxKP())) {
      throw new Exception("not enough KP!");
    }
    Arrays.stream(enemyTeam.getMembers()).forEach(entry -> {
          if (entry.getHP() > 0) {
            entry.decreaseHP((100 * this.getAttack()) / (100 + entry.getDefence()));
            if (entry.getHP() <= 0) {
              this.increaseEP(4);
            }
          }
        }
    );
    this.increaseEP(4);
    this.setCurrentKP(0);
  }
}
