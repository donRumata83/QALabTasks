package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainMenu extends Page {
    private String url;

    private String userIconLocator = "img-thumbnail";
    private String logoutLocator = "header_logout";
    private String menuElements = "maintab";

    MainMenu(WebDriver driver) {
        super(driver);
        this.url = URLHolder.MAIN_MENU_PAGE.getURL();
    }

    public LoginPage logout() {
        driver.findElement(By.className(userIconLocator)).click();
        driver.findElement(By.id(logoutLocator)).click();
        return new LoginPage(driver);
    }

    public MainMenu checkForAllMenuButtons(){
        List<WebElement> list = driver.findElements(By.className("maintab"));
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
