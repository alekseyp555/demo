package ru.qa.testingsoft.login.tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.qa.testingsoft.login.appmanager.ApplicationManager;
import java.io.IOException;
import java.lang.reflect.Method;

public class TestBase {

  Logger logger = LoggerFactory.getLogger(TestBase.class);

  protected static final ApplicationManager app
          = new ApplicationManager(BrowserType.FIREFOX); //выбираем запуск браузера

  @BeforeSuite
  public void setUp() throws IOException {
    app.init();
  }

  @AfterSuite
  public void tearDown()   {
    app.stop();
  }

  @BeforeMethod (alwaysRun = true)
  public void logTestStart (Method m) {
    logger.info ("Start test " + m.getName());
  }

  @AfterMethod (alwaysRun = true)
  public void logTestStop (Method m) {
    logger.info ("Stop test " + m.getName());
  }
}
