import java.util.ArrayList;

/**
 * The class simulates a database for users.
 */
public class UserGroup {
  private ArrayList<User> users;

  public UserGroup() {
    users = new ArrayList<>();
  }

  /**
   * The method adds sample data to users in the array list.
   */
  public void addSampleData() {
    String username;
    for (int i = 0; i < 10; i++) {
      username = "sample" + i;
      users.add(new User(username, "admin", "Sample"));
    }
  }

  public User getUser(int index) {
    return users.get(index);
  }

  /**
   * The method prints all the usernames and their types from the arraylist.
   */
  public void printUsernames() {
    for (int i = 0; i < users.size(); i++) {
      System.out.printf("%s %s%n", users.get(i).getUsername(), users.get(i).getUserType());
    }
  }

  public ArrayList<User> getUsers() {
    return users;
  }

  public void setUsers(ArrayList<User> users) {
    this.users = users;
  }
}
