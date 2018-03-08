package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import pages.enums.URLHolder;

public class NewCategoryPage extends Page {
    private String url;

    private By success = By.className("alert alert-success");
    private By submit = By.id("category_form_submit_btn");
    private By firstField = By.xpath("//*[@id=\"name_1\"]");
    private By cpuField = By.xpath("//*[@id=\"link_rewrite_1\"]");
    private String categoryName = "New Category";
    private String cpuName = "cpu";

    NewCategoryPage(EventFiringWebDriver driver) {
        super(driver);
        this.url = URLHolder.NEWKATEGORY.getURL();
    }

    public CategoryPage createNewCategory() {
        driver.findElement(firstField).sendKeys(categoryName);
        driver.findElement(cpuField).clear();
        driver.findElement(cpuField).sendKeys(cpuName);
        driver.findElement(submit).click();
        waitForLoad();
        return new CategoryPage(driver);
    }

}
