package application.adminPages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class GoodsPage extends Page {

    private By newGoodButton = By.xpath("//*[@id=\"page-header-desc-configuration-add\"]/i");

    GoodsPage(EventFiringWebDriver driver) {
        super(driver);
    }

    public NewGoodPage clickNewGoodButton() {
        new Actions(driver).moveToElement(driver.findElement(newGoodButton)).perform();
        driver.findElement(newGoodButton).click();
        return new NewGoodPage(driver);
    }
}
