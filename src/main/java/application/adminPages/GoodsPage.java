package application.adminPages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class GoodsPage extends Page {

    private By newGoodButton = By.cssSelector("#page-header-desc-configuration-add > i");

    GoodsPage(EventFiringWebDriver driver) {
        super(driver);
    }

    public NewGoodPage clickNewGoodButton() {
        driver.findElement(newGoodButton).click();
        return new NewGoodPage(driver);
    }
}
