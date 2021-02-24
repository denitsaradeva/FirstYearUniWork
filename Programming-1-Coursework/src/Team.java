import java.util.ArrayList;

//Simulation of a real team, having name and members.
public abstract class Team {
  private final String name;
  private ArrayList<Character> members;

  public Team(String name) {
    this.name = name;
    members = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  /**
   * The method returns all team members.
   *
   * @return all members from the team in the form of a one-dimensional array of Characters.
   */
  public Character[] getMembers() {
    Character[] membersArray = new Character[members.size()];
    for (int i = 0; i < members.size(); i++) {
      membersArray[i] = members.get(i);
    }
    return membersArray;
  }

  /**
   * The method adds a new member to the team if its size is not 5 already and returns the number of members.
   *
   * @return the number of members (best case), -2 if the members are 5 or -1 if the member is already in the team.
   */
  public int addMember(Character member) {
    if (members.contains(member)) {
      return -1;
    }
    if (members.size() == 5) {
      return -2;
    }
    members.add(member);
    return members.size();
  }

  public void setMembers(ArrayList<Character> members) {
    this.members = members;
  }

  public ArrayList<Character> getMembersArray() {
    return this.members;
  }

  /**
   * The method removes a member from the team.
   */
  public void removeMember(Character member) throws Exception {
    if (this.members.contains(member)) {
      this.members.remove(member);
    } else {
      throw new Exception("There isn't such a member in the team!");
    }
  }

  public abstract void move(Character member, Team enemyTeam) throws Exception;

  public abstract void printInformation();
}