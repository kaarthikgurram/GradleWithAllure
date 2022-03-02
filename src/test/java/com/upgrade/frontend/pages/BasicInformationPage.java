package com.upgrade.frontend.pages;

import com.upgrade.frontend.fixtures.BasicInformationFixture;
import com.upgrade.frontend.util.browser.BrowserActions;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasicInformationPage {
  private final BrowserActions browserActions;
  private WebDriver webDriver;

  @FindBy(name = "borrowerFirstName")
  private WebElement firstName;

  @FindBy(name = "borrowerLastName")
  private WebElement lastName;

  @FindBy(name = "borrowerStreet")
  private WebElement homeAddress;

  @FindBy(name = "borrowerCity")
  private WebElement city;

  @FindBy(name = "borrowerState")
  private WebElement state;

  @FindBy(name = "borrowerZipCode")
  private WebElement zipCode;

  @FindBy(name = "borrowerDateOfBirth")
  private WebElement dateOfBirth;

  @FindBy(xpath = "//button[contains(text(), 'Continue')]")
  private WebElement continueButton;

  public BasicInformationPage(WebDriver webDriver) {
    PageFactory.initElements(webDriver, this);
    browserActions = new BrowserActions(webDriver);
    this.webDriver = webDriver;
  }

  public BasicInformationPage fillBasicInformationPage(BasicInformationFixture fixture) {
    browserActions.enterTextInTextField(firstName, fixture.firstName);
    browserActions.enterTextInTextField(lastName, fixture.lastName);
    browserActions.enterTextInTextField(homeAddress, fixture.homeAddress);
    webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    browserActions.enterTextInTextField(city, fixture.city);
    browserActions.enterTextInTextField(state, fixture.state);
    browserActions.enterTextInTextField(zipCode, fixture.zipCode);
    browserActions.enterTextInTextField(dateOfBirth, fixture.dateOfBirth);
    return this;
  }

  public BasicInformationPage clickContinueButton() {
    browserActions.moveTheCursorToElementAndClick(continueButton);
    return this;
  }
}
