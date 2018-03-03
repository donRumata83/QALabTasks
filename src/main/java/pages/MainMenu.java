package pages;

import pages.enums.URLHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainMenu extends Page {
    private String url;

    private By userIcon = By.className("img-thumbnail");
    private By logout = By.id("header_logout");
    private By menuButtons = By.className("maintab");

    MainMenu(WebDriver driver) {
        super(driver);
        this.url = URLHolder.MAIN_MENU_PAGE.getURL();
    }

    public LoginPage logout() {
        driver.findElement(userIcon).click();
        driver.findElement(logout).click();
        return new LoginPage(driver);
    }

    public MainMenu checkForAllMenuButtons(){
        List<WebElement> list = driver.findElements(menuButtons);
        for (WebElement element: list) {
            if (element.getText().equals("Dashboard")){
                checkDasboardButton(element);
            } else {
                checkOtherMainMenuButtons(element);
            }
        }
        return this;
    }

    private void checkOtherMainMenuButtons(WebElement element) {
        element.click();
        WebDriverUtils.waitForOneSecond(driver);
        String tmp = showCurrentUrl();
        driver.navigate().refresh();
        WebDriverUtils.waitForOneSecond(driver);
        checkIsOnTheSameURl(isUrlEquals(tmp));
        driver.navigate().back();
        WebDriverUtils.waitForOneSecond(driver);
    }

    private void checkDasboardButton(WebElement element) {
        element.click();
        WebDriverUtils.waitForOneSecond(driver);
        String tmp = showCurrentUrl();
        driver.navigate().refresh();
        WebDriverUtils.waitForOneSecond(driver);
        checkIsOnTheSameURl(isUrlEquals(tmp));
    }

    private void checkIsOnTheSameURl(boolean urlEquals) {
        System.out.println("Is the user stays on the same page = " + urlEquals);
    }

    private boolean isUrlEquals(String tmp) {
        return driver.getCurrentUrl().equals(tmp);
    }

    private String showCurrentUrl() {
        System.out.println(driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }
}
