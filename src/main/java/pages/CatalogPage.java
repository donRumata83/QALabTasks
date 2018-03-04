package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.enums.URLHolder;

public class CatalogPage extends Page {
    private String url;

    private By category = By.xpath("html/body/nav/ul/li[4]/ul/li[2]");

    CatalogPage(WebDriver driver) {
        super(driver);
        this.url = URLHolder.KATALOG.getURL();
    }

    public CategoryPage clickCategoryButton() {
        driver.findElement(category).click();
        waitForLoad();
        return new CategoryPage(driver);
    }
}
