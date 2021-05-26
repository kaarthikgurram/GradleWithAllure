package com.upgrade.frontEnd.pages;

import com.upgrade.frontEnd.Fixtures.BasicInformationFixture;
import com.upgrade.frontEnd.util.browser.BrowserActions;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasicInformationPage {
    private final BrowserActions browserActions;
    private WebDriver webDriver;


    @FindBy(xpath = "//input[@name='borrowerFirstName']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@name='borrowerLastName']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@name='borrowerStreet']")
    private WebElement homeAddress;

    @FindBy(xpath = "//input[@name='borrowerCity']")
    private WebElement city;

    @FindBy(xpath = "//input[@name='borrowerState']")
    private WebElement state;

    @FindBy(xpath = "//input[@name='borrowerZipCode']")
    private WebElement zipCode;

    @FindBy(xpath = "//input[@name='borrowerDateOfBirth']")
    private WebElement dateOfBirth;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement continueButton;

    public BasicInformationPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        browserActions = new BrowserActions(webDriver);
        this.webDriver = webDriver;
    }

    public void fillBasicInformationPage(BasicInformationFixture fixture) {
    browserActions.enterTextInTextField(firstName, fixture.firstName);
    browserActions.enterTextInTextField(lastName, fixture.lastName);
    browserActions.enterTextInTextField(homeAddress, fixture.homeAddress);
    webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    browserActions.enterTextInTextField(city, fixture.city);
    browserActions.enterTextInTextField(state, fixture.state);
    browserActions.enterTextInTextField(zipCode, fixture.zipCode);
//    browserActions.waitForTextToAppear(city, "Big Bear Lake");
//    browserActions.waitForTextToAppear(state, "CA");
//    browserActions.waitForTextToAppear(zipCode, "92315");
    browserActions.enterTextInTextField(dateOfBirth, fixture.dateOfBirth);
    }

    public void clickContinueButton() {
        browserActions.moveTheCursorToElementAndClick(continueButton);
    }
}
