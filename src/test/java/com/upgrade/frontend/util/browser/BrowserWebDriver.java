package com.upgrade.frontend.util.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWebDriver {

  public WebDriver getWebDriver() {
    System.setProperty(
        "webdriver.chrome.driver", "./src/test/resources/browserdrivers/chromedriver.exe");
    return new ChromeDriver();
  }
}
