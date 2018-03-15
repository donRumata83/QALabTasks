package application.adminPages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import application.enums.URLHolder;

public class NewCategoryPage extends Page {
    private String url;

    private By success = By.xpath("//*[@class='alert alert-success'][1]");
    private By submit = By.id("category_form_submit_btn");
    private By firstField = By.xpath("//*[@id='name_1']");
    private By cpuField = By.xpath("//*[@id='link_rewrite_1']");


    NewCategoryPage(EventFiringWebDriver driver) {
        super(driver);
        this.url = URLHolder.NEWKATEGORY.getURL();
    }

    public CategoryPage createNewCategory(String categoryName, String cpu) {
        driver.findElement(firstField).sendKeys(categoryName);
        driver.findElement(cpuField).clear();
        driver.findElement(cpuField).sendKeys(cpu);
        driver.findElement(submit).click();
        customWait(success);
        System.out.println("The new category is created = " + isElementpresent(success) + " with message " + driver.findElement(success).getText());
        return new CategoryPage(driver);
    }

}
