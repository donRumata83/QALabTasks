package application.userPages;

import application.adminPages.enums.URLHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class UserStartPage extends UserPage {
    private String url;
    private By searchField = By.className("ui-autocomplete-input");
    private By allGoodsButton = By.xpath("//a[contains(@class, \"all-product-link\")]");
    private By logo = By.id("_desktop_logo");

    public UserStartPage(EventFiringWebDriver driver) {
        super(driver);
        this.url = URLHolder.USER_START_PAGE.getURL();
    }

    public UserAllGoodsPage goToAllGoodsPage() {
        driver.get(url);
        driver.findElement(allGoodsButton).click();
        customWait(logo);
        return new UserAllGoodsPage(driver);
    }
}
