package ru.qa.testingsoft.login.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.qa.testingsoft.login.model.UserData;

import static org.testng.Assert.assertTrue;

public class RegistrationHelper extends HelperBase {

  public RegistrationHelper(WebDriver wd) {
    super(wd);
  }

  public void createUser(UserData user) {
    fillUserRegistrationForm(user);
    selectAgreement();
    submitUserRegistration();
  }

  public void fillUserRegistrationForm(UserData userData) {
    type(By.id("display_name"), userData.getUsername()); //заполнение ФИО пользователя
    type(By.id("email_1"), userData.getEmail());
    type(By.id("password_1"), userData.getPassword());
    type(By.id("password_2"), userData.getPassword());
    type(By.id("field_9"), userData.getDescription()); //Цель регистрации в форуме (Минимум 50 и максимум 500 символов)
  }

  public void selectAgreement() {
    click(By.id("agree_tos")); //чекбокс "Я прочитал и соглашаюсь с Условия использования"
  }

  public void submitUserRegistration() {
    click(By.id("register_submit")); //регистрация
  }

  public void checkNamePopupError() {
    assertTrue(isElementPresent(By.id("display_name_msg"))
            && wd.findElement(By.cssSelector("#display_name_msg")).getText().equals("Имя может содержать только следующие символы: a-z0-9_"));
  }

  public void checkEmailPopupError() {
    assertTrue (isElementPresent(By.id("email_1_msg"))
            && wd.findElement(By.cssSelector("#email_1_msg")).getText().equals("✗ E-mail адрес неправильный"));
  }

  public void checkNamePopupValid() {
    assertTrue (isElementPresent(By.id("display_name_msg"))
            && wd.findElement(By.cssSelector("#display_name_msg")).getText().equals("✔ Доступно!"));
  }

  public void checkEmailPopupValid() {
    assertTrue (isElementPresent(By.id("email_1_msg"))
            && wd.findElement(By.cssSelector("#email_1_msg")).getText().equals("✔ Доступно!"));
  }

}
