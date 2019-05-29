package ru.qa.testingsoft.login.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.qa.testingsoft.login.model.UserData;

public class RegistrationHelper extends HelperBase {

  public RegistrationHelper(WebDriver wd) {
    super(wd);
  }

  public void fillUserRegistrationForm(UserData userData) {
    type(By.id("display_name"), userData.getUsername()); //заполнение ФИО пользователя
    type(By.id("email_1"), userData.getEmail());
    type(By.id("password_1"), userData.getPassword());
    type(By.id("password_2"), userData.getPassword());
    type(By.id("field_9"), userData.getDescription()); //Цель регистрации в форуме (Минимум 50 и максимум 500 символов)
  }

  public void selectAgreement() {
    click(By.id("agree_tos")); //Я прочитал и соглашаюсь с Условия использования
  }

  public void submitUserRegistration() {
    click(By.id("register_submit")); //регистрация
  }
}
