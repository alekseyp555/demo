package ru.qa.testingsoft.login.tests;
import org.testng.annotations.Test;
import ru.qa.testingsoft.login.model.UserData;

public class UserRegistrationTests extends TestBase {

  //private WebDriver wd;
  @Test
  public void testUserRegistrationEng () {
    app.register().createUser(
            new UserData()
                    .withUsername("VasyaPupkin")
                    .withEmail("vasya@gmail.com")
                    .withPassword("P@ssword1")
                    .withDescription("for the best testing purposes, please allow it. thanks in advance"));
    app.register().checkNamePopupValid();
    app.register().checkEmailPopupValid();
  }

  @Test
  public void testUserRegistrationBoundary() {
    app.register().createUser(//max symbols
            new UserData()
                    .withUsername("VasyaPupkinBestOfTheBestUs")
                    .withEmail("vasya@gmail.com")
                    .withPassword("P@P@ssword1P@ssword1P@ssword1P@ssw")
                    .withDescription("for the best testing purposes. for the best testing purposes. for the best testing purposes. for the best testing purposes. for the best testing purposes. for the best testing purposes. for the best testing purposes. for the best testing purposes. for the best testing purposes. for the best testing purposes. for the best testing purposes. for the best testing purposes. for the best testing purposes. for the best testing purposes. for the best testing purposes. for the best testing purposes. for the best testing purposes. for the best testing purposes. for the best testing purposes. for the "));
    app.register().checkNamePopupValid();
    app.register().checkEmailPopupValid();
  }

  @Test
  public void testBadUserRegistration () {
    app.register().createUser(
            new UserData()
                    .withUsername("Va")
                    .withEmail("vasyaatgmail.com.com")
                    .withPassword("va")
                    .withDescription("for the best testing purposes"));
    app.register().checkShortNamePopupError();
    app.register().checkShortNamePopupError();
  }

  @Test
  public void testBadUserRegistrationRu () {
    app.register().createUser( //кириллица запрещена
            new UserData()
                    .withUsername("ВасяПупкинЛучший")
                    .withEmail("вася@почта.рф")
                    .withPassword("васяпароль")
                    .withDescription("это тестовая регистрация, пожалуйста разрешите эту регистрацию"));
    app.register().checkNamePopupError();
  }

  @Test
  public void testBadUserRegistrationSpecCharacters () {
    app.register().createUser( //спец символы нельзя
            new UserData()
                    .withUsername("!@$%^*(^)53582")
                    .withEmail("(**(&@email.com")
                    .withPassword("!#(%*^__$*^+*$&%^")
                    .withDescription("это тестовая регистрация, пожалуйста разрешите эту регистрацию !(№%(№%%:::"));
    app.register().checkNamePopupError();
  }
}
