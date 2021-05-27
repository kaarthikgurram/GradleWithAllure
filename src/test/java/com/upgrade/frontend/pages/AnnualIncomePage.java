package com.upgrade.frontend.pages;

import com.upgrade.frontend.util.browser.BrowserActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AnnualIncomePage {
  private final BrowserActions browserActions;
  private WebDriver webDriver;

  @FindBy(xpath = "//input[@name='borrowerIncome']")
  private WebElement annualIncome;

  @FindBy(xpath = "//input[@name='borrowerAdditionalIncome']")
  private WebElement annualAdditionalIncome;

  @FindBy(xpath = "//button[@type='submit']")
  private WebElement continueButton;

  public AnnualIncomePage(WebDriver webDriver) {
    PageFactory.initElements(webDriver, this);
    browserActions = new BrowserActions(webDriver);
    this.webDriver = webDriver;
  }

  public void fillIncomeDetails() {

    browserActions.enterTextInTextField(annualIncome, "120,000");
    browserActions.enterTextInTextField(annualAdditionalIncome, "5000");
  }

  public void clickContinueButton() {
    browserActions.moveTheCursorToElementAndClick(continueButton);
    browserActions.moveTheCursorToElementAndClick(continueButton);
  }
}
