public class MechatronicStudent extends Student {
  public MechatronicStudent(String name) {
    super(name, 5, 5, 5, 5, 5);
  }

  /**
   * The ability to attack mechanically is available to the mechatronic students only.
   * The enemy loses HP, determined by the value of the attack of the student, divided by two.
   * The student also sets his/her KP to 0 and receives 4 EP.
   * If the enemy dies, the mechatronic student receives additional 4 EP.
   *
   * @param enemy the enemy that gets attacked.
   */
  public void mechanicalAttack(Character enemy) throws Exception {
    if (!this.getCurrentKP().equals(this.getMaxKP())) {
      throw new Exception("not enough KP!");
    }
    if (enemy.getHP() <= 0) {
      throw new Exception("The enemy is not alive!");
    }

    enemy.decreaseHP(this.getAttack() / 2);

    if (enemy.getHP() <= 0) {
      this.increaseEP(4);
    }
    this.increaseEP(4);
    this.setCurrentKP(0);
  }

  /**
   * The help ability is available for mechatronic students only. By using it, they heal two friends with the amount
   * of their defence. The mechatronic's EP gets increased by 4 and their KP becomes 0.
   *
   * @param friend who will be supported
   * @param secondFriend who will be supported too
   */
  public void help(Character friend, Character secondFriend) throws Exception {
    if (!this.getCurrentKP().equals(this.getMaxKP())) {
      throw new Exception("not enough KP!");
    }
    if (friend.getHP() <= 0 || secondFriend.getHP() <= 0) {
      throw new Exception("The friend is not alive!");
    }

    friend.increaseHP(this.getDefence());
    secondFriend.increaseHP(this.getDefence());

    this.increaseEP(4);
    this.setCurrentKP(0);
  }
}
