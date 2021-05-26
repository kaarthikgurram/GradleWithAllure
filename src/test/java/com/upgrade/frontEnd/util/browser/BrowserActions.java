package com.upgrade.frontEnd.util.browser;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class BrowserActions {

    private WebDriver webDriver;
    private Actions action;

    public BrowserActions(WebDriver webDriver) {
        this.webDriver = webDriver;
        action = new Actions(webDriver);
    }

    public void moveTheCursorToElementAndClick(WebElement element) {
        waitForCondition("clickAble", element);
        action.moveToElement(element).click().build().perform();
    }

    public void waitForCondition(String typeOfWait, WebElement element) {
        try {
            Wait<WebDriver> wait = getWebDriverWait(240);
            switch (typeOfWait) {
                case "clickAble":
                    wait.until(ExpectedConditions.elementToBeClickable(element));
                    break;
                case "staleness":
                    wait.until(ExpectedConditions.stalenessOf(element));
                    break;
                case "visible":
                    wait.until(ExpectedConditions.visibilityOf(element));
                    break;
                case "invisible":
                    wait.until(ExpectedConditions.invisibilityOf(element));
                    break;
                default:
                    wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("wait For Condition \"" + typeOfWait + "\" isn't supported.");
        }
    }

    public Wait<WebDriver> getWebDriverWait(long durationOfWait) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver).withTimeout(Duration.ofSeconds(durationOfWait))
            .pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

        return wait;
    }

    public void selectElementFromTheDropdownMenuByVisibleText(String text, WebElement element) {
        Select s = new Select(element);
        s.selectByVisibleText(text);
    }
    public void enterTextInTextField(WebElement searchBox, String textToSearchFor) {
        waitForCondition("click", searchBox);
        searchBox.clear();
        searchBox.sendKeys(textToSearchFor + "\n");
    }

    public void waitForTextToAppear(WebElement element, String textToAppear) {
        Wait<WebDriver> wait = getWebDriverWait(120);
        wait.until(ExpectedConditions.textToBePresentInElement(element, textToAppear));
    }
}
