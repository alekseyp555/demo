package ru.qa.testingsoft.login.tests;
import org.testng.annotations.Test;
import ru.qa.testingsoft.login.model.UserData;

@Test
public class UserRegistrationTests extends TestBase {
  //private WebDriver wd;

  public void testUserRegistration () {
    app.register().fillUserRegistrationForm(
              new UserData("VasyaPupkin", "vasya@gmail.com", "P@ssword1", "for the best testing purposes, please allow it. thanks in advance"));
    app.register().selectAgreement();
    app.register().submitUserRegistration();
  }
}
