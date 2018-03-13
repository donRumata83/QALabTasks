package application.UserPages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public class UserAllGoodsPage extends UserPage {

    private By logo = By.className("logo img-responsive");

    UserAllGoodsPage(EventFiringWebDriver driver) {
        super(driver);
    }

    public boolean isElementpresent(String element) {
        return driver.findElements(By.partialLinkText(element.toLowerCase().replace(" ", "-"))).size() > 0;
    }

    public UserGoodPage clickToGoodPage(String goodName) {
        driver.findElement(By.partialLinkText(goodName.toLowerCase().replace(" ", "-"))).click();
        customWait(logo);
        return new UserGoodPage(driver);
    }
}
