package application.adminPages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import application.enums.URLHolder;

public class CategoryPage extends Page {
    private String url;

    private By newCategory = By.id("page-header-desc-category-new_category");
    private By sortByName = By.name("categoryFilter_name");
    private String nameOfCategoryInTable = "//td[contains(text(), '%s')]";
    private By submitButton = By.name("submitFilter");


    CategoryPage(EventFiringWebDriver driver) {
        super(driver);
        this.url = URLHolder.KATEGORY.getURL();
    }

    public NewCategoryPage clickNewCategoryButton() {
        driver.findElement(newCategory).click();
        waitForLoad();
        return new NewCategoryPage(driver);
    }

    public void sortListByName(String categoryName){
        driver.findElement(sortByName).sendKeys(categoryName);
        driver.findElement(submitButton).click();
        By catInTable = By.xpath(String.format(nameOfCategoryInTable, categoryName));
        customWait(catInTable);
        System.out.println("Category is created = " + isElementpresent(catInTable));
    }
}
