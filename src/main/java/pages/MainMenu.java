package pages;

import pages.enums.URLHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainMenu extends Page {
    private String url;

    private By userIcon = By.className("img-thumbnail");
    private By logout = By.id("header_logout");
    private By menuButtons = By.xpath("/html/body/div/div/nav/ul/li[contains(@class, 'maintab')]");

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
        for (int i = 1; i < driver.findElements(menuButtons).size()+1; i++) {
            WebElement element = driver.findElement(By.xpath("/html/body/div/div/nav/ul/li[contains(@class, 'maintab')]"+ "[" + i + "]"));
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
