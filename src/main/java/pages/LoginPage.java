package pages;

import pages.enums.URLHolder;
import pages.enums.UserData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page {
    private String url;

    private By submit = By.name("submitLogin");
    private By pass = By.id("passwd");
    private By email = By.id("email");

    public LoginPage(WebDriver driver) {
        super(driver);
        this.url = URLHolder.LOGIN_PAGE.getURL();
    }

    public MainMenu login() {
        driver.get(url);
        driver.findElement(email).sendKeys(UserData.LOGIN.getData());
        driver.findElement(pass).sendKeys(UserData.PASS.getData());
        driver.findElement(submit).click();
        return new MainMenu(driver);
    }
}
