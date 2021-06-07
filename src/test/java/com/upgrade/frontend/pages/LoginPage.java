package com.upgrade.frontend.pages;

import com.upgrade.frontend.fixtures.AccountContext;
import com.upgrade.frontend.util.browser.BrowserActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

  private final BrowserActions browserActions;
  private WebDriver webDriver;

  @FindBy(name = "username")
  private WebElement emailAddress;

  @FindBy(name = "password")
  private WebElement password;

  @FindBy(xpath = "//button[contains(text(), 'Sign in to your account')]")
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
    System.out.println(AccountContext.getEmailAddress());
    System.out.println(AccountContext.getPassword());
    browserActions.enterTextInTextField(emailAddress, AccountContext.getEmailAddress());
    browserActions.enterTextInTextField(password, AccountContext.getPassword());
    browserActions.moveTheCursorToElementAndClick(signIn);
  }
}
