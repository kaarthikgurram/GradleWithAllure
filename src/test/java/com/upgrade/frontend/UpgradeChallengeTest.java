package com.upgrade.frontend;

import com.upgrade.frontend.fixtures.BasicInformationFixture;
import com.upgrade.frontend.fixtures.LoanDetails;
import com.upgrade.frontend.pages.AnnualIncomePage;
import com.upgrade.frontend.pages.BasicInformationPage;
import com.upgrade.frontend.pages.CreateAccountPage;
import com.upgrade.frontend.pages.GetStartedPage;
import com.upgrade.frontend.pages.LoanDetailsPage;
import com.upgrade.frontend.pages.LoginPage;
import com.upgrade.frontend.util.browser.BrowserActions;
import com.upgrade.frontend.util.browser.BrowserWebDriver;
import com.upgrade.frontend.validation.LoanDetailsValidation;
import org.junit.jupiter.api.AfterEach;
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
  public void upgradeApplication_applyLoan_verifyLoanCreatedAndDisplayed() {
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

  @AfterEach
  public void afterEach() {
    webDriver.quit();
  }
}
