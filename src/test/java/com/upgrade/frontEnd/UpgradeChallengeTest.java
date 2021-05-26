package com.upgrade.frontEnd;

import com.upgrade.frontEnd.Fixtures.BasicInformationFixture;
import com.upgrade.frontEnd.pages.BasicInformationPage;
import com.upgrade.frontEnd.pages.GetStartedPage;
import com.upgrade.frontEnd.util.browser.BrowserActions;
import com.upgrade.frontEnd.util.browser.BrowserWebDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UpgradeChallengeTest {

    private static WebDriver webDriver;
    private BrowserWebDriver browserWebDriver;
    private BrowserActions browserActions;
    private GetStartedPage getStartedPage;
    private BasicInformationPage basicInformationPage;
    private BasicInformationFixture basicInformationFixture;

    @BeforeEach
    public void beforeEach() {
        browserWebDriver = new BrowserWebDriver();
        webDriver = browserWebDriver.getWebDriver();
        browserActions = new BrowserActions(webDriver);
        getStartedPage = new GetStartedPage(webDriver);
        basicInformationPage = new BasicInformationPage(webDriver);
        basicInformationFixture = new BasicInformationFixture();
    }

    @Test
    public void fillHomePage() {
        getStartedPage.gotoGetStartedPage();
        getStartedPage.fillGetStartedPage("Pay off Credit Cards");
        basicInformationPage.fillBasicInformationPage(basicInformationFixture);

        basicInformationPage.clickContinueButton();
    }
}
