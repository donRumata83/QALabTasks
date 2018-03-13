package application.adminPages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import application.adminPages.enums.URLHolder;

public class CatalogPage extends Page {
    private String url;

    private By category = By.xpath("//li[contains(@class,'link-levelone')][3]/ul/li[2]");
    private By goods = By.xpath("//li[contains(@class,'link-levelone')][3]/ul/li[1]");
    private By catalog = By.xpath("//li[contains(@class,'link-levelone')][3]");

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

    public GoodsPage clickGoodsButton() {
        new Actions(driver).moveToElement(driver.findElement(catalog)).perform();
        driver.findElement(goods).click();
        waitForLoad();
        return new GoodsPage(driver);
    }
}
