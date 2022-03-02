package com.upgrade.frontend.pages;

import com.upgrade.frontend.util.browser.BrowserActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AnnualIncomePage {
  private final BrowserActions browserActions;
  private WebDriver webDriver;

  @FindBy(name = "borrowerIncome")
  private WebElement annualIncome;

  @FindBy(name = "borrowerAdditionalIncome")
  private WebElement annualAdditionalIncome;

  @FindBy(xpath = "//button[contains(text(), 'Continue')]")
  private WebElement continueButton;

  public AnnualIncomePage(WebDriver webDriver) {
    PageFactory.initElements(webDriver, this);
    browserActions = new BrowserActions(webDriver);
    this.webDriver = webDriver;
  }

  public AnnualIncomePage fillIncomeDetails() {

    browserActions.enterTextInTextField(annualIncome, "120,000");
    browserActions.enterTextInTextField(annualAdditionalIncome, "5000");
    return this;
  }

  public AnnualIncomePage clickContinueButton() {
    browserActions.moveTheCursorToElementAndClick(continueButton);
    browserActions.moveTheCursorToElementAndClick(continueButton);
    return this;
  }
}
