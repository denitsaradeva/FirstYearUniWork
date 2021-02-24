import java.util.*;

//Simulation of a guild, having unlimited number of members and the option to form a team.
public class Guild {
  private final ArrayList<Character> guildMembers;

  public Guild() {
    guildMembers = new ArrayList<>();
  }

  public void addMember(Character character) throws Exception {
    if (character.getHP() <= 0) {
      throw new Exception("The member is not alive.");
    }
    if (guildMembers.contains(character)) {
      throw new Exception("The character is already in the guild.");
    }
    guildMembers.add(character);
  }

  public Collection<Character> getMembers() {
    return guildMembers;
  }

  /**
   * The method returns a team that has the most potential to beat the opponent.
   * I created additional method "getBestFighter()" and "isGuildDead()"
   * to help me with the implementation of this method.
   */
  public Team getTeam(Team enemyTeam) {
    if (isGuildDead()) {
      return null;
    }
    Character[] enemyMembers = enemyTeam.getMembers();
    ArrayList<Character> guildMembers = (ArrayList<Character>) this.getMembers();
    StudentTeam chosenTeam = new StudentTeam("Fighters");
    int maxPeopleInTeam = 5;
    //If the members of the guild are already 5, the team is already chosen.
    if (guildMembers.size() <= maxPeopleInTeam) {
      chosenTeam.setMembers(guildMembers);
    } else {
      for (Character enemyMember : enemyMembers) {
        Character chosenFighter = getBestFighter(guildMembers, enemyMember, chosenTeam);
        chosenTeam.addMember(chosenFighter);
      }
      //If there were less than 5 people in the monsters team, the other remaining positions for students are filled.
      for (int i = 0; i < maxPeopleInTeam - chosenTeam.getMembers().length; i++) {
        Character chosenFighter = getBestFighter(guildMembers, enemyMembers[0], chosenTeam);
        chosenTeam.addMember(chosenFighter);
      }
      for (Character member : chosenTeam.getMembersArray()) {
        member.setTeam(chosenTeam);
      }
    }
    return chosenTeam;
  }

  /**
   * The method will choose the member that beats the opponent by most of his categories:
   * hit points, attack, defence, and speed.
   * If there are two or more members that beat the opponent by the same number of categories,
   * then those members will be compared by hit points and the best match will be returned.
   */
  public Character getBestFighter(ArrayList<Character> members, Character enemy, StudentTeam chosenTeam) {
    int enemyHitPoints = enemy.getHP();
    int enemyAttack = enemy.getAttack();
    int enemyDefence = enemy.getDefence();
    int enemySpeed = enemy.getSpeed();
    int count = 0;
    ArrayList<Integer> statsByMember = new ArrayList<>();

    for (Character member : members) {
      if (!(chosenTeam.getMembersArray().contains(member)) && member.getHP() != 0) {
        count = beatenCategories(member, enemyHitPoints, enemyAttack, enemyDefence, enemySpeed);
      }
      statsByMember.add(count);
      count = 0;
    }

    int maxCount = getMaxCategoriesBeaten(statsByMember);

    //Filling an arrayList with the indices of the members that have the highest number of beaten categories.
    ArrayList<Integer> positions = new ArrayList<>();
    for (int i = 0; i < statsByMember.size(); i++) {
      if (statsByMember.get(i) == maxCount) {
        positions.add(i);
      }
    }

    /*
    If there is only one member with highest number of beaten categories, he gets chosen.
    Else, a new arrayList is created with the members that will continue to be compared.
     */
    ArrayList<Character> bestMembersOfGuild = new ArrayList<>();
    if (positions.size() == 1) {
      return members.get(positions.get(0));
    } else {
      for (Integer position : positions) {
        bestMembersOfGuild.add(members.get(position));
      }
    }

    /*
    The following cycle will compare the members with equal beaten categories of the opponent.
    They will be compared only by their hit points and the best match will be returned.
    If they have the same number of hit points, then the first one will be returned.
     */
    Character chosenFighter = bestMembersOfGuild.get(0);
    int maxHP = 0;
    for (Character character : bestMembersOfGuild) {
      if (character.getHP() > maxHP) {
        maxHP = character.getHP();
        chosenFighter = character;
      }
    }
    return chosenFighter;
  }

  /**
   * @return the maximum times a category is beaten from the guild.
   */
  private Integer getMaxCategoriesBeaten(ArrayList<Integer> statsByMember) {
    int maxCount = 0;
    for (Integer integer : statsByMember) {
      if (integer > maxCount) {
        maxCount = integer;
      }
    }
    return maxCount;
  }

  /**
   * Checks how many categories of the opponent are beaten by a member.
   *
   * @return number of beaten categories.
   */
  private Integer beatenCategories(Character member, int enemyHitPoints, int enemyAttack, int enemyDefence, int enemySpeed) {
    int count = 0;
    if (member.getHP() > enemyHitPoints) {
      count++;
    }
    if (member.getAttack() > enemyAttack) {
      count++;
    }
    if (member.getDefence() > enemyDefence) {
      count++;
    }
    if (member.getSpeed() > enemySpeed) {
      count++;
    }
    return count;
  }

  /**
   * Checks whether all members of the guild are dead.
   */
  private boolean isGuildDead() {
    int totalHP = this.getMembers().stream().mapToInt(Character::getHP).sum();
    return totalHP == 0;
  }
}
