import java.util.ArrayList;

//Simulation of a real fight between students and monsters.
public class Battle {
  private final StudentTeam studentTeam;
  private final MonsterTeam monsterTeam;

  public Battle(StudentTeam studentTeam, MonsterTeam monsterTeam) {
    this.studentTeam = studentTeam;
    this.monsterTeam = monsterTeam;
  }

  /**
   * Students fight against monsters for up to 30 rounds.
   *
   * @return the winner team.
   */
  public Team fight() {
    int rounds = 0;
    int attackerIndex = -1;
    Character member;

    while (!areStudentsDead() && !areMonstersDead()) {
      ArrayList<Character> attackOrder = new ArrayList<>(this.studentTeam.getMembersArray());
      attackOrder.addAll(this.monsterTeam.getMembersArray());
      attackOrder = sortMembersDescending(attackOrder);

      attackerIndex++;

      if (attackerIndex == attackOrder.size() || attackerIndex > attackOrder.size()) {
        attackerIndex = 0;
      }
      member = attackOrder.get(attackerIndex);

      //A student or a monster makes a move.
      if (this.studentTeam.getMembersArray().contains(member)) {
        try {
          this.studentTeam.move(member, this.monsterTeam);
        } catch (Exception e) {
          e.printStackTrace();
        }
      } else {
        try {
          this.monsterTeam.move(member, this.studentTeam);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

      //Printing information for the current round.
      this.studentTeam.printInformation();
      this.monsterTeam.printInformation();
      System.out.println();

      //All dead members are spotted.
      ArrayList<Character> membersToRemove = new ArrayList<>();
      studentTeam.getMembersArray().forEach(entry -> {
        if (entry.getHP() == 0) {
          membersToRemove.add(entry);
        }
      });

      //All dead members are spotted.
      ArrayList<Character> monstersToRemove = new ArrayList<>();
      monsterTeam.getMembersArray().forEach(entry -> {
        if (entry.getHP() == 0) {
          monstersToRemove.add(entry);
        }
      });

      //All dead members are removed.
      membersToRemove.forEach(entry -> {
        try {
          studentTeam.removeMember(entry);
        } catch (Exception e) {
          e.printStackTrace();
        }
      });

      //All dead members are removed.
      monstersToRemove.forEach(entry -> {
        try {
          monsterTeam.removeMember(entry);
        } catch (Exception e) {
          e.printStackTrace();
        }
      });

      rounds++;
      if (rounds >= 30) {
        return null;
      }
    }

    if (areMonstersDead()) {
      return this.studentTeam;
    } else {
      return this.monsterTeam;
    }
  }

  /**
   * @return whether monsters are dead.
   */
  private boolean areMonstersDead() {
    if(this.monsterTeam==null){
      return true;
    }
    int totalHP = this.monsterTeam.getMembersArray().stream().mapToInt(Character::getHP).sum();
    return totalHP == 0;
  }

  /**
   * @return whether students are dead.
   */
  private boolean areStudentsDead() {
    if(this.studentTeam==null){
      return true;
    }
    int totalHP = this.studentTeam.getMembersArray().stream().mapToInt(Character::getHP).sum();
    return totalHP == 0;
  }

  /**
   * @return list of members, sorted in descending order by speed.
   */
  public ArrayList<Character> sortMembersDescending(ArrayList<Character> members) {
    for (int i = 0; i < members.size(); i++) {
      for (int j = 0; j < members.size(); j++) {
        if (j == members.size() - 1) {
          break;
        }
        if (members.get(j).getSpeed() <= members.get(j + 1).getSpeed()) {
          members.add(j, members.get(j + 1));
          members.remove(j + 2);
        }
      }
    }
    return members;
  }
}
