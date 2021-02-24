public class CardLock {

  private SmartCard lastCardSeen;
  private boolean isUnlocked;
  private boolean isStudentAllowed;

  CardLock() {
    isUnlocked = true;
    isStudentAllowed = false;
  }

  public boolean isAllowed() {
    return isStudentAllowed;
  }

  public void setAllowed(boolean allowed) {
    isStudentAllowed = allowed;
  }

  public SmartCard getLastCardSeen() {
    return lastCardSeen;
  }

  public void setLastCardSeen(SmartCard lastCardSeen) {
    this.lastCardSeen = lastCardSeen;
  }

  /**
   * Testing whether the cardlock should be locked/unlocked.
   *
   * @return boolean, indicating whether or not the cardlock is unlocked
   */
  public boolean isUnlocked() {
    if (this.lastCardSeen.isStaff()) {
      isUnlocked = true;
    } else if ((!this.lastCardSeen.isStaff()) && isStudentAllowed) {
      isUnlocked = true;
    } else if (!this.lastCardSeen.isStaff()) {
      isUnlocked = false;
    } else {
      isUnlocked = false;
    }
    return isUnlocked;
  }

  public void setUnlocked(boolean unlocked) {
    isUnlocked = unlocked;
  }

  public void swipeCard(SmartCard cardA) {
    lastCardSeen = cardA;
  }

  public void toggleStudentAccess() {
    isStudentAllowed = !isStudentAllowed;
  }
}
