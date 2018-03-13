package application.UserPages;

import application.adminPages.enums.URLHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class UserStartPage extends UserPage {
    private String url;
    private By searchField = By.className("ui-autocomplete-input");
    private By allGoodsButton = By.xpath("//*[@id=\"content\"]/section/a/i");
    private By logo = By.className("logo img-responsive");

    public UserStartPage(EventFiringWebDriver driver) {
        super(driver);
        this.url = URLHolder.USER_START_PAGE.getURL();
    }

    public UserAllGoodsPage goToAllGoodsPage() {
        driver.findElement(allGoodsButton).click();
        customWait(logo);
        return new UserAllGoodsPage(driver);
    }
}
