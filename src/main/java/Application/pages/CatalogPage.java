package application.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import application.pages.enums.URLHolder;

public class CatalogPage extends Page {
    private String url;

    private By category = By.xpath("/html/body/nav/ul/li[4]/ul/li[2]");
    private By catalog = By.xpath("/html/body/nav/ul/li[4]/a");

    CatalogPage(EventFiringWebDriver driver) {
        super(driver);
        this.url = URLHolder.KATALOG.getURL();
    }

    public CategoryPage clickCategoryButton() {
        new Actions(driver).moveToElement(driver.findElement(catalog)).perform();
        driver.findElement(category).click();
        waitForLoad();
        return new CategoryPage(driver);
    }
}
