package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.enums.URLHolder;

public class CategoryPage extends Page {
    private String url;

    private By newCategory = By.id("page-header-desc-category-new_category");

    CategoryPage(WebDriver driver) {
        super(driver);
        this.url = URLHolder.KATEGORY.getURL();
    }

    public NewCategoryPage clickNewCategoryButton() {
        driver.findElement(newCategory).click();
        waitForLoad();
        return new NewCategoryPage(driver);
    }
}
