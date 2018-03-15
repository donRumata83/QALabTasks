package application.loger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Reporter;

public class LoggerWithReporter implements WebDriverEventListener {

    private Reporter reporter;

    public LoggerWithReporter(Reporter reporter) {
        this.reporter = reporter;
    }

    public void beforeAlertAccept(WebDriver webDriver) {

    }

    public void afterAlertAccept(WebDriver webDriver) {

    }

    public void afterAlertDismiss(WebDriver webDriver) {

    }

    public void beforeAlertDismiss(WebDriver webDriver) {

    }

    public void beforeNavigateTo(String s, WebDriver webDriver) {
        Reporter.log("Going on page " + s);
    }

    public void afterNavigateTo(String s, WebDriver webDriver) {
        Reporter.log("On page " + webDriver.getCurrentUrl());
    }

    public void beforeNavigateBack(WebDriver webDriver) {
        Reporter.log("On page " + webDriver.getCurrentUrl());
    }

    public void afterNavigateBack(WebDriver webDriver) {
        Reporter.log("On page " + webDriver.getCurrentUrl());
    }

    public void beforeNavigateForward(WebDriver webDriver) {

    }

    public void afterNavigateForward(WebDriver webDriver) {
        Reporter.log("On page " + webDriver.getCurrentUrl());
    }

    public void beforeNavigateRefresh(WebDriver webDriver) {
        Reporter.log("Refresh the page");
    }

    public void afterNavigateRefresh(WebDriver webDriver) {
        Reporter.log("Page refreshed");
    }

    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        Reporter.log("Searching for element " + by.toString());
    }

    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        Reporter.log("Element found");
    }

    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        Reporter.log("Trying to click on element" + webElement.getAttribute("name"));
    }

    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        Reporter.log("Element is clicked");
    }

    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        Reporter.log("Sending keys to element " + webElement.getAttribute("name"));
    }

    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }

    public void beforeScript(String s, WebDriver webDriver) {

    }

    public void afterScript(String s, WebDriver webDriver) {

    }

    public void onException(Throwable throwable, WebDriver webDriver) {

    }
}
