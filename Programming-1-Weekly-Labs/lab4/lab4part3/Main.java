public class Main {
  /**
   * Testing all new methods in UserGroup and in User classes.
   */
  public static void main(String[] args) {
    UserGroup userGroup = new UserGroup();
    userGroup.addSampleData();
    userGroup.printUsernames();
    UserGroup administrators = new UserGroup();

    while (userGroup.getUserIterator().hasNext()) {
      User currentUser = userGroup.getUserIterator().next();

      if (currentUser.getUserType().equals("admin")) {
        administrators.getUsers().add(currentUser);
      }

    }

    administrators.printUsernames();
    administrators.getUser(administrators.getUsers().size() - 1).setUserType("user");
  }
}
