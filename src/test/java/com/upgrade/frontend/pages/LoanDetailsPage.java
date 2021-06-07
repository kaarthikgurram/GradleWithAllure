package com.upgrade.frontend.pages;

import com.upgrade.frontend.fixtures.LoanDetails;
import com.upgrade.frontend.util.browser.BrowserActions;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoanDetailsPage {
  private final BrowserActions browserActions;
  private WebDriver webDriver;
  private LoanDetails loanDetails;

  @FindBy(xpath = "//span[contains(@class, 'guKkvw')]")
  private WebElement loanAmount;

  @FindBy(xpath = "(//div[contains(@class, 'number')])[1]")
  private WebElement monthlyPayment;

  @FindBy(xpath = "(//div[contains(@class, 'number')])[2]")
  private WebElement monthTerm;

  @FindBy(xpath = "(//div[contains(@class, 'number')])[3]")
  private WebElement interestRate;

  @FindBy(xpath = "(//div[contains(@class, 'number')])[4]")
  private WebElement apr;

  @FindBy(xpath = "//label[contains(text(), 'Menu')]")
  private WebElement menu;

  @FindBy(xpath = "//a[text()='Sign Out']")
  private WebElement signOut;

  public LoanDetailsPage(WebDriver webDriver) {
    PageFactory.initElements(webDriver, this);
    browserActions = new BrowserActions(webDriver);
    this.webDriver = webDriver;
  }

  public LoanDetails fetchLoanDetails() {
    loanDetails = new LoanDetails();
    webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    loanDetails.setLoanAmount(loanAmount.getText());
    loanDetails.setMonthlyPayment(monthlyPayment.getText());
    loanDetails.setInterestRate(interestRate.getText());
    loanDetails.setTerm(monthTerm.getText());
    loanDetails.setApr(apr.getText());

    return loanDetails;
  }

  public void signOut() {
    browserActions.moveTheCursorToElementAndClick(menu);
    browserActions.moveTheCursorToElementAndClick(signOut);
  }
}
