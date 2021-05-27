package com.upgrade.frontEnd.pages;

import com.upgrade.frontEnd.Fixtures.LoanDetails;
import com.upgrade.frontEnd.util.browser.BrowserActions;
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

  @FindBy(xpath = "//div[contains(@class, 'gIXPbp')]/span[1]")
  private WebElement monthlyPayment;

  @FindBy(xpath = "(//div[@class = 'section--xs'])[1]")
  private WebElement monthTerm;

  @FindBy(xpath = "(//div[@class = 'section--xs'])[2]")
  private WebElement interestRate;

  @FindBy(xpath = "(//div[@class = 'section--xs'])[3]")
  private WebElement apr;

  @FindBy(xpath = "//label[@class = 'header-nav__toggle']")
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
