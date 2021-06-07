package com.upgrade.frontend.pages;

import com.upgrade.frontend.util.browser.BrowserActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GetStartedPage {
  private final BrowserActions browserActions;
  private WebDriver webDriver;

  @FindBy(name = "desiredAmount")
  private WebElement loanAmount;

  @FindBy(name = "loan-purpose")
  private WebElement loanPurposeDropDown;

  @FindBy(xpath = "//button[contains(text(), 'Check your rate')]")
  private WebElement checkYourRate;

  public GetStartedPage(WebDriver webDriver) {
    PageFactory.initElements(webDriver, this);
    browserActions = new BrowserActions(webDriver);
    this.webDriver = webDriver;
  }

  public void fillGetStartedPage(String text) {
    browserActions.enterTextInTextField(loanAmount, "2000");
    browserActions.selectElementFromTheDropdownMenuByVisibleText(text, loanPurposeDropDown);
    checkYourRate.click();
  }

  public void gotoGetStartedPage() {
    webDriver.navigate().to("https://www.credify.tech/funnel/nonDMFunnel");
  }
}
