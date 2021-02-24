import java.util.Arrays;

//Simulation of a real team of monsters.
public class MonsterTeam extends Team {
  public MonsterTeam(String name) {
    super(name);
  }

  /**
   * A monster attacks the student with the lowest hit points.
   */
  @Override
  public void move(Character member, Team enemyTeam) throws Exception {
    if (member.getHP() <= 0) {
      throw new Exception("The member is dead");
    }
    Character target = enemyTeam.getMembers()[0];
    for (int i = 1; i < enemyTeam.getMembers().length; i++) {
      if (enemyTeam.getMembers()[i].getHP() > target.getHP() && target.getHP() != 0) {
        target = enemyTeam.getMembers()[i];
      }
    }
    if (member instanceof Boss) {
      ((Boss) member).strike(target);
    } else if (member instanceof Minion) {
      ((Minion) member).strike(target);
    } else {
      throw new Exception("There isn't such type of monster.");
    }
  }

  /**
   * Prints the current stats for all alive monsters.
   */
  @Override
  public void printInformation() {
    Arrays.stream(this.getMembers()).forEach(entry -> {
      if (entry.getHP() > 0) {
        System.out.printf("%s is still alive: %nCurrent HP: %d%nCurrent level: %d%nCurrent EP: %d%n",
            entry.getName(), entry.getHP(), entry.getLevel(), entry.getEP());
      } else {
        System.out.printf("%s is dead.%n", entry.getName());
      }
    });
  }
}
