//The class simulates an user, having an username, type, and real name.
public class User {
  private String username;
  private String userType;
  private String name;

  /**
   * Constructor, taking data from the input to initialize the properties of the class.
   */
  public User(String username, String userType, String name) {
    this.username = username;
    this.userType = userType;
    this.name = name;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getUserType() {
    return userType;
  }

  public void setUserType(String userType) {
    this.userType = userType;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
