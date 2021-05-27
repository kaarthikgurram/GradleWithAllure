package com.upgrade.frontEnd.pages;

import com.upgrade.frontEnd.Fixtures.AccountContext;
import com.upgrade.frontEnd.util.browser.BrowserActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

  private final BrowserActions browserActions;
  private WebDriver webDriver;

  @FindBy(xpath = "//input[@name='username']")
  private WebElement emailAddress;

  @FindBy(xpath = "//input[@name='password']")
  private WebElement password;

  @FindBy(xpath = "//button[@type='submit']")
  private WebElement signIn;

  public LoginPage(WebDriver webDriver) {
    PageFactory.initElements(webDriver, this);
    browserActions = new BrowserActions(webDriver);
    this.webDriver = webDriver;
  }

  public void gotoLogInPage() {
    webDriver.navigate().to("https://www.credify.tech/portal/login");
  }

  public void logInHomePage() {
    browserActions.enterTextInTextField(emailAddress, AccountContext.getEmailAddress());
    browserActions.enterTextInTextField(password, AccountContext.getPassword());
    browserActions.moveTheCursorToElementAndClick(signIn);
  }
}
