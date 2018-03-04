package pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.enums.URLHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainMenu extends Page {
    private String url;


    private By menuButtons = By.xpath("/html/body/div/div/nav/ul/li[contains(@class, 'maintab')]");

    MainMenu(WebDriver driver) {
        super(driver);
        this.url = URLHolder.MAIN_MENU_PAGE.getURL();
    }

    public MainMenu checkForAllMenuButtons() {
        for (int i = 1; i < driver.findElements(menuButtons).size() + 1; i++) {
            WebElement element = driver.findElement(getMenuButton(i));
            if (element.getText().equals("Dashboard")) {
                checkDasboardButton(element);
            } else {
                checkOtherMainMenuButtons(element);
            }
        }
        return this;
    }

    public CatalogPage clickKatalogButton() {
        driver.findElement(getMenuButton(3)).click();
        waitForLoad();
        return new CatalogPage(driver);
    }

    private void checkOtherMainMenuButtons(WebElement element) {
        element.click();
        waitForLoad();
        String tmp = showCurrentUrl();
        driver.navigate().refresh();
        waitForLoad();
        checkIsOnTheSameURl(isUrlEquals(tmp));
        driver.navigate().back();
        waitForLoad();
    }

    private void checkDasboardButton(WebElement element) {
        element.click();
        waitForLoad();
        String tmp = showCurrentUrl();
        driver.navigate().refresh();
        waitForLoad();
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

    private By getMenuButton(int number) {
        return By.xpath("/html/body/div/div/nav/ul/li[contains(@class, 'maintab')]" + "[" + number + "]");
    }
}
