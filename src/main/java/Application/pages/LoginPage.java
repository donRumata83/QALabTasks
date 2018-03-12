package application.pages;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import application.pages.enums.URLHolder;
import application.pages.enums.UserData;
import org.openqa.selenium.By;


public class LoginPage extends Page {
    private String url;

    private By submit = By.name("submitLogin");
    private By pass = By.id("passwd");
    private By email = By.id("email");

    public LoginPage(EventFiringWebDriver driver) {
        super(driver);
        this.url = URLHolder.LOGIN_PAGE.getURL();
    }

    public MainMenu login() {
        driver.get(url);
        driver.findElement(email).sendKeys(UserData.LOGIN.getData());
        driver.findElement(pass).sendKeys(UserData.PASS.getData());
        driver.findElement(submit).click();
        waitForLoad();
        return new MainMenu(driver);
    }
}
