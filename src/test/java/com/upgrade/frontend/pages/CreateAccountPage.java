package com.upgrade.frontend.pages;

import com.upgrade.frontend.fixtures.AccountContext;
import com.upgrade.frontend.util.browser.BrowserActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {
  private final BrowserActions browserActions;
  private WebDriver webDriver;

  @FindBy(xpath = "//input[@name='username']")
  private WebElement emailAddress;

  @FindBy(xpath = "//input[@name='password']")
  private WebElement password;

  @FindBy(xpath = "//div[contains(@class, 'gTusOv ')]")
  private WebElement agreementCheckbox;

  @FindBy(xpath = "//button[@type='submit']")
  private WebElement checkYourRateButton;

  public CreateAccountPage(WebDriver webDriver) {
    PageFactory.initElements(webDriver, this);
    browserActions = new BrowserActions(webDriver);
    this.webDriver = webDriver;
  }

  public void createAccount() {
    browserActions.enterTextInTextField(emailAddress, AccountContext.getEmailAddress());
    browserActions.enterTextInTextField(password, AccountContext.getPassword());
    agreementCheckbox.click();
    checkYourRateButton.click();
  }
}
