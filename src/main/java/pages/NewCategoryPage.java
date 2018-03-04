package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.enums.URLHolder;

import java.util.List;

public class NewCategoryPage extends Page {
    private String url;

    By nameField = By.xpath("html/body/div/div[2]/div[5]/div/form/div/div[2]/div/div/div/div[1]");
    By nameField2 = By.xpath(".//[contains(@class, 'translatable-field lang-1')][1]");
    By cpu = By.xpath(".//[contains(@class, 'translatable-field lang-1')][6]");
    By submit = By.id("category_form_submit_btn");
    By fields = By.className("translatable-field");
    private String categoryName = "New Category";
    private String cpuName = "cpu";

    public NewCategoryPage(WebDriver driver) {
        super(driver);
        this.url = URLHolder.NEWKATEGORY.getURL();
    }

    public CategoryPage createNewCategory() {
        List<WebElement> list = driver.findElements(fields);
        list.get(1).sendKeys(categoryName);
        list.get(6).sendKeys(cpuName);
        driver.findElement(submit).click();
        waitForLoad();
        return new CategoryPage(driver);
    }

}
