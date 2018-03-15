package application.userPages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class UserAllGoodsPage extends UserPage {

    private By logo = By.xpath("//img[contains(@class,'logo img-responsive')]");
    private String format = "//*[contains(text(), '%s')]";
    private By nextPage = By.xpath("//a[contains(@class,'next js-search-link')]/i");

    UserAllGoodsPage(EventFiringWebDriver driver) {
        super(driver);
    }

    public boolean isElementPresent(String goodName) {
        try {
            driver.findElement(By.xpath(String.format(format, goodName))).isDisplayed();
            return true;
        } catch (Exception e) {
            if (driver.findElement(nextPage).isEnabled()) {
                driver.findElement(nextPage).click();
                customWait(logo);
                isElementPresent(goodName);
            }
            else return false;
        }
        return false;
    }

    public UserGoodPage clickToGoodPage(String goodName) {
        driver.findElement(By.xpath(String.format(format, goodName))).click();
        customWait(logo);
        return new UserGoodPage(driver);
    }
}
