package application.adminPages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class GoodsPage extends Page {

    private By newGoodButton = By.xpath("//*[@id=\"page-header-desc-configuration-add\"]/span");

    GoodsPage(EventFiringWebDriver driver) {
        super(driver);
    }

    public NewGoodPage clickNewGoodButton() {
        driver.findElement(newGoodButton).click();
        return new NewGoodPage(driver);
    }
}
