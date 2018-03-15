package application.adminPages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import application.enums.URLHolder;

public class CatalogPage extends Page {
    private String url;

    private By category = By.xpath("//a[contains(text(), 'категории')]");
    private By goods = By.xpath("//a[contains(text(), 'товары')][1]");
    private By catalog = By.xpath("//span[contains(text(), 'Каталог')]");

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
