public class EEEStudent extends Student {
  public EEEStudent(String name) {
    super(name, 7, 5, 8, 7, 5);
  }

  /**
   * The smart hit ability is available for electronic and electrical students only.
   * The student reduces the hit points of each of the alive enemies in the enemy team by 2.
   * The student's EP gets increased by 4 and their KP becomes 0. If an enemy dies, the students gets 4 more EP.
   *
   * @param enemyTeam the enemy team that gets attacked.
   */
  public void smartHit(Team enemyTeam) throws Exception {
    if (!this.getCurrentKP().equals(this.getMaxKP())) {
      throw new Exception("not enough KP!");
    }

    enemyTeam.getMembersArray().forEach(entry -> {
      if (entry.getHP() > 0) {
        entry.decreaseHP(2);
      }
      if (entry.getHP() <= 0) {
        this.increaseEP(4);
      }
    });

    this.increaseEP(4);
    this.setCurrentKP(0);
  }


  /**
   * The ability to help two friends is available for electronic and electrical students only.
   * Two friends are healed with the amount of their defence, divided by 2.
   * The student's EP gets increased by 4 and their KP becomes 0.
   *
   * @param friend       who will be supported
   * @param secondFriend who will be supported too
   */
  public void helpTwoFriends(Character friend, Character secondFriend) throws Exception {
    if (!this.getCurrentKP().equals(this.getMaxKP())) {
      throw new Exception("not enough KP!");
    }
    if (friend.getHP() <= 0 || secondFriend.getHP() <= 0) {
      throw new Exception("The friend is not alive!");
    }

    friend.increaseHP(this.getDefence() / 2);
    secondFriend.increaseHP(this.getDefence() / 2);

    this.increaseEP(4);
    this.setCurrentKP(0);
  }
}
