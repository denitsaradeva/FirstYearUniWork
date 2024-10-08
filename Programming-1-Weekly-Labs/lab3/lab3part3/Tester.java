public class Tester {
  // Uncomment each part as you go.
  // Remember to test often!
  public static void main(String... args) {
    testPart1a();
    testPart1b();
    testPart1c();
    testPart2a();
    testPart2b();
    testPart2c();
    testPart3();
  }

  public static void testPart1a() {
    System.out.println("Part 1 - Accessor methods");
    System.out.println("======");

    System.out.println("--- Part 1a ---");
    System.out.println();

    System.out.println("* Creating a new SmartCard for student Anna Undergrad...");
    SmartCard card = new SmartCard("Anna Undergrad");
    System.out.println("Owner is: " + card.getOwner());
    System.out.println();
  }

  public static void testPart1b() {
    System.out.println("--- Part 1b ---");
    System.out.println();

    SmartCard card = new SmartCard("Anna Undergrad");

    System.out.println("Is " + card.getOwner() + " staff? " + card.isStaff());
    System.out.println();
  }

  public static void testPart1c() {
    System.out.println("--- Part 1c ---");
    System.out.println();

    System.out.println("* Creating a new SmartCard for staff member Dr. Bob Lecturer...");
    SmartCard card = new SmartCard("Dr. Bob Lecturer");
    card.setStaff(true);
    System.out.println("Is " + card.getOwner() + " staff? " + card.isStaff());
    System.out.println();
  }

  public static void testPart2a() {
    System.out.println("Part 2 - Object interactions");
    System.out.println("======");

    System.out.println("--- Part 2a ---");
    System.out.println();

    System.out.println("* Creating a new CardLock...");
    CardLock lock = new CardLock();
    System.out.println();

    SmartCard cardA = new SmartCard("Anna Undergrad");
    SmartCard cardB = new SmartCard("Dr. Bob Lecturer");
    cardB.setStaff(true);

    System.out.println("* Swiping " + cardA.getOwner() + "'s card");
    lock.swipeCard(cardA);
    System.out.println("Last card seen: " + lock.getLastCardSeen().getOwner() + "'s card");
    System.out.println();

    System.out.println("* Swiping " + cardB.getOwner() + "'s card");
    lock.swipeCard(cardB);
    System.out.println("Last card seen: " + lock.getLastCardSeen().getOwner() + "'s card");
    System.out.println();
  }

  public static void testPart2b() {
    System.out.println("--- Part 2b ---");
    System.out.println();

    CardLock lock = new CardLock();
    SmartCard cardA = new SmartCard("Anna Undergrad");
    SmartCard cardB = new SmartCard("Dr. Bob Lecturer");
    cardB.setStaff(true);

    System.out.println("* Swiping some cards on the lock...");
    System.out.println("(This lock should only let staff in)");
    System.out.println();

    System.out.println("* Swiping " + cardA.getOwner() + "'s card");
    lock.swipeCard(cardA);
    System.out.println("Is the card lock unlocked? " + lock.isUnlocked());
    System.out.println();

    System.out.println("* Swiping " + cardB.getOwner() + "'s card");
    lock.swipeCard(cardB);
    System.out.println("Is the card lock unlocked? " + lock.isUnlocked());
    System.out.println();
  }

  public static void testPart2c() {
    System.out.println("--- Part 2c ---");
    System.out.println();

    CardLock lock = new CardLock();
    SmartCard cardA = new SmartCard("Anna Undergrad");
    SmartCard cardB = new SmartCard("Dr. Bob Lecturer");
    cardB.setStaff(true);

    System.out.println("* Toggling the lock to allow both students and staff...");
    lock.toggleStudentAccess();
    System.out.println();

    System.out.println("* Swiping " + cardA.getOwner() + "'s card");
    lock.swipeCard(cardA);
    System.out.println("Is the card lock unlocked? " + lock.isUnlocked());
    System.out.println();

    System.out.println("* Swiping " + cardB.getOwner() + "'s card");
    lock.swipeCard(cardB);
    System.out.println("Is the card lock unlocked? " + lock.isUnlocked());
    System.out.println();

    System.out.println("* Toggling the lock to allow only staff...");
    lock.toggleStudentAccess();
    System.out.println();

    System.out.println("* Swiping " + cardA.getOwner() + "'s card");
    lock.swipeCard(cardA);
    System.out.println("Is the card lock unlocked? " + lock.isUnlocked());
    System.out.println();

    System.out.println("* Swiping " + cardB.getOwner() + "'s card");
    lock.swipeCard(cardB);
    System.out.println("Is the card lock unlocked? " + lock.isUnlocked());
    System.out.println();
  }

  public static void testPart3() {
    System.out.println("Part 3 - Writing tests");
    System.out.println("======");

    Door door = new Door();
    door.setRoomName("Research Labs");
    CardLock cardLock = new CardLock();
    door.attachLock(cardLock);
    SmartCard smartCardStudent = new SmartCard("Denitsa");
    cardLock.swipeCard(smartCardStudent);
    door.openDoor();
    SmartCard smartCardStaff = new SmartCard("Professor Richard");
    smartCardStaff.setStaff(true);
    cardLock.swipeCard(smartCardStaff);
    door.openDoor();

    // TODO: Write a test harness for the Door class
  }
}
