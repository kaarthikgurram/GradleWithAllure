package com.upgrade.frontEnd;

import com.upgrade.frontEnd.Fixtures.BasicInformationFixture;
import com.upgrade.frontEnd.Fixtures.LoanDetails;
import com.upgrade.frontEnd.pages.AnnualIncomePage;
import com.upgrade.frontEnd.pages.BasicInformationPage;
import com.upgrade.frontEnd.pages.CreateAccountPage;
import com.upgrade.frontEnd.pages.GetStartedPage;
import com.upgrade.frontEnd.pages.LoanDetailsPage;
import com.upgrade.frontEnd.pages.LoginPage;
import com.upgrade.frontEnd.util.browser.BrowserActions;
import com.upgrade.frontEnd.util.browser.BrowserWebDriver;
import com.upgrade.frontEnd.validation.LoanDetailsValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class UpgradeChallengeTest {

  private static WebDriver webDriver;
  public LoanDetails loanDetails;
  private BrowserWebDriver browserWebDriver;
  private BrowserActions browserActions;
  private GetStartedPage getStartedPage;
  private BasicInformationPage basicInformationPage;
  private BasicInformationFixture basicInformationFixture;
  private AnnualIncomePage annualIncomePage;
  private CreateAccountPage createAccountPage;
  private LoanDetailsPage loanAmountPage;
  private LoginPage loginPage;
  private LoanDetailsValidation loanDetailsValidation;

  @BeforeEach
  public void beforeEach() {
    browserWebDriver = new BrowserWebDriver();
    webDriver = browserWebDriver.getWebDriver();
    browserActions = new BrowserActions(webDriver);
    getStartedPage = new GetStartedPage(webDriver);
    basicInformationPage = new BasicInformationPage(webDriver);
    basicInformationFixture = new BasicInformationFixture();
    annualIncomePage = new AnnualIncomePage(webDriver);
    createAccountPage = new CreateAccountPage(webDriver);
    loanAmountPage = new LoanDetailsPage(webDriver);
    loginPage = new LoginPage(webDriver);
    loanDetailsValidation = new LoanDetailsValidation(webDriver);
    loanDetails = new LoanDetails();
  }

  @Test
  public void fillHomePage() {
    getStartedPage.gotoGetStartedPage();
    getStartedPage.fillGetStartedPage("Pay off Credit Cards");
    basicInformationPage.fillBasicInformationPage(basicInformationFixture);
    basicInformationPage.clickContinueButton();
    annualIncomePage.fillIncomeDetails();
    annualIncomePage.clickContinueButton();
    createAccountPage.createAccount();
    loanDetails = loanAmountPage.fetchLoanDetails();
    loanAmountPage.signOut();
    loginPage.gotoLogInPage();
    loginPage.logInHomePage();
    loanDetailsValidation.validateLoanDetails(loanDetails);
  }
}
