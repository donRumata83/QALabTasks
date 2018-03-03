package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainMenu extends Page {
    private String url;

    private String userIconLocator = "img-thumbnail";
    private String logoutLocator = "header_logout";

    public MainMenu(WebDriver driver) {
        super(driver);
        this.url = URLHolder.MAIN_MENU_PAGE.getURL();
    }

    public LoginPage logout() {
        driver.findElement(By.className(userIconLocator)).click();
        driver.findElement(By.id(logoutLocator)).click();
        return new LoginPage(driver);
    }
}
