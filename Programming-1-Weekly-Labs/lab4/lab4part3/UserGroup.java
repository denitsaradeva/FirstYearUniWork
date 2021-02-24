import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

//The class simulates a database for users.
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

  public void removeFirstUser() {
    users.remove(0);
  }

  public void removeLastUser() {
    users.remove(users.size() - 1);
  }

  /**
   * The method iterates through the class' array and removes an user by given username.
   */
  public void removeUser(String usernameForSearch) {
    User[] copyOfUsers = users.toArray(new User[0]);
    Iterator<User> iterator = Arrays.stream(copyOfUsers).iterator();
    while (iterator.hasNext()) {
      User currentUser = iterator.next();
      if (currentUser.getUsername().equals(usernameForSearch)) {
        users.remove(currentUser);
      }
    }
  }

  public Iterator<User> getUserIterator() {
    Iterator<User> userIterator = users.iterator();
    return userIterator;
  }
}
