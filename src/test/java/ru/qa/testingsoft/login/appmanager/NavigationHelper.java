package ru.qa.testingsoft.login.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends  HelperBase{

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void RegisterPage() {
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.cssSelector(".maintitle")).getText().equals("Готовы зарегистрироваться?")
            && isElementPresent(By.id("display_name"))) {
      return;
    }
    click(By.cssSelector("#register_link"));
  }

}
