import java.util.Arrays;

//Simulation of a team with students.
public class StudentTeam extends Team {
  public StudentTeam(String name) {
    super(name);
  }

  /**
   * A student either attacks an enemy team or heals itself if he/she has low hit points.
   */
  @Override
  public void move(Character member, Team enemyTeam) throws Exception {
    if (member.getHP() <= 0) {
      throw new Exception("The member is dead");
    }

    Character lowestDefenceEnemy = lowestDefenceEnemy(enemyTeam);
    Character highestAttackFriend = highestAttackFriend();

    //If the currently attacking student has very low HP, then it should recharge. Else, it will attack the enemy.
    if (member.getHP() == 1 || member.getHP() == 2) {
      heal(member);
    } else {
      attackEnemy(member, enemyTeam, lowestDefenceEnemy, highestAttackFriend);
    }
  }

  /**
   * If the currently attacking student has enough KP for a special ability, then it will use it.
   * Else, it will use the general method - selfStudy().
   *
   * @param member that gets healed
   */
  private void heal(Character member) throws Exception {
    if (hasEnoughKP(member)) {
      if (member instanceof SEStudent) {
        ((SEStudent) member).groupDiscussion();
      } else if (member instanceof CSStudent) {
        ((CSStudent) member).support(member);
      } else if (member instanceof AIStudent) {
        ((AIStudent) member).naturalLanguageProcessing();
      }
    } else {
      ((Student) member).selfStudy();
    }
  }

  /**
   * If the currently attacking student has enough KP for a special ability, then it will use it.
   * Else, it will use the general method - javaProgramming().
   *
   * @param member              that attacks
   * @param enemyTeam           that gets attacked
   * @param lowestDefenceEnemy  provides the enemy with lowest defence
   * @param highestAttackFriend provides the friend with the highest attack
   */
  private void attackEnemy(Character member, Team enemyTeam, Character lowestDefenceEnemy, Character highestAttackFriend) throws Exception {
    if (hasEnoughKP(member)) {
      if (member instanceof CyberStudent) {
        ((CyberStudent) member).cyberAttack(enemyTeam);
      } else if (member instanceof SEStudent) {
        ((SEStudent) member).groupWork(lowestDefenceEnemy);
      } else if (member instanceof CSStudent) {
        ((CSStudent) member).pairWorking(highestAttackFriend, lowestDefenceEnemy);
      } else if (member instanceof AIStudent) {
        ((AIStudent) member).machineLearning(lowestDefenceEnemy);
      }
    } else {
      ((Student) member).javaProgramming(lowestDefenceEnemy);
    }
  }

  /**
   * Prints the current stats for all alive students.
   */
  @Override
  public void printInformation() {
    Arrays.stream(this.getMembers()).forEach(entry -> {
      if (entry.getHP() > 0) {
        System.out.printf("%s is still alive: %nCurrent HP: %d%nCurrent level: %d%nCurrent EP: %d%nCurrent KP: %d%n",
            entry.getName(), entry.getHP(), entry.getLevel(), entry.getEP(), ((Student) entry).getCurrentKP());
      } else {
        System.out.printf("%s is dead.%n", entry.getName());
      }
    });
  }

  /**
   * Checks if the member has enough KP to use a special ability.
   *
   * @return true if the member has enough KP or false if he/she doesn't.
   */
  private boolean hasEnoughKP(Character member) {
    return ((Student) member).getCurrentKP().equals(((Student) member).getMaxKP());
  }

  /**
   * @return the monster with the lowest defence.
   */
  private Character lowestDefenceEnemy(Team enemyTeam) {
    int lowestDefence = Integer.MAX_VALUE;
    Character lowestDefenceEnemy = enemyTeam.getMembers()[0];
    for (int i = 0; i < enemyTeam.getMembers().length; i++) {
      if (enemyTeam.getMembers()[i].getDefence() < lowestDefence) {
        lowestDefence = enemyTeam.getMembers()[i].getDefence();
        lowestDefenceEnemy = enemyTeam.getMembers()[i];
      }
    }
    return lowestDefenceEnemy;
  }

  /**
   * @return the student with the highest attack.
   */
  private Character highestAttackFriend() {
    int highestAttack = Integer.MIN_VALUE;
    Character highestAttackFriend = this.getMembers()[0];
    for (int i = 0; i < this.getMembers().length; i++) {
      if (this.getMembers()[i].getAttack() > highestAttack) {
        highestAttack = this.getMembers()[i].getAttack();
        highestAttackFriend = this.getMembers()[i];
      }
    }
    return highestAttackFriend;
  }
}
