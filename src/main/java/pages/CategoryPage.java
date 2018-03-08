package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.enums.URLHolder;

public class CategoryPage extends Page {
    private String url;

    private By newCategory = By.id("page-header-desc-category-new_category");
    private By sortByName = By.xpath("//*[@id=\"table-category\"]/thead/tr[1]/th[3]/span/a[1]/i");
    private By nameOfCategoryInTable = By.xpath("//td[contains(text(), 'New Category')]");

    CategoryPage(WebDriver driver) {
        super(driver);
        this.url = URLHolder.KATEGORY.getURL();
    }

    public NewCategoryPage clickNewCategoryButton() {
        driver.findElement(newCategory).click();
        waitForLoad();
        return new NewCategoryPage(driver);
    }

    public void sortListByName(){
        driver.findElement(sortByName).click();
        customWait(nameOfCategoryInTable);
        System.out.println("Category is created = " + isElementpresent(nameOfCategoryInTable));
    }


}
