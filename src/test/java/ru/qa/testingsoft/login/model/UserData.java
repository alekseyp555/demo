package ru.qa.testingsoft.login.model;

public class UserData {
  private final String username;
  private final String email;
  private final String password;
  private final String description;

  public UserData(String username, String email, String password, String description) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.description = description;
  }

  public String getUsername() {
    return username;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getDescription() {
    return description;
  }
}
