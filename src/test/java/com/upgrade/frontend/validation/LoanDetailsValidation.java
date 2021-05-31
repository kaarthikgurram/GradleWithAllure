package com.upgrade.frontend.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.upgrade.frontend.fixtures.LoanDetails;
import com.upgrade.frontend.util.browser.BrowserActions;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoanDetailsValidation {

  private final BrowserActions browserActions;
  private WebDriver webDriver;

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

  public LoanDetailsValidation(WebDriver webDriver) {
    PageFactory.initElements(webDriver, this);
    browserActions = new BrowserActions(webDriver);
    this.webDriver = webDriver;
  }

  public void validateLoanDetails(LoanDetails loanDetails) {
    System.out.println(loanDetails.getLoanAmount());
    System.out.println(loanDetails.getTerm());
    webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    assertEquals(loanAmount.getText(), loanDetails.getLoanAmount());
    assertEquals(monthlyPayment.getText(), loanDetails.getMonthlyPayment());
    assertEquals(monthTerm.getText(), loanDetails.getTerm());
    assertEquals(interestRate.getText(), loanDetails.getInterestRate());
    assertEquals(apr.getText(), loanDetails.getApr());
  }
}
