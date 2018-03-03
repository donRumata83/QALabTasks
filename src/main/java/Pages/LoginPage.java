package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page {
    private String url;


    private String emailLocator = "email";
    private String passLocator = "passwd";
    private String submitLocator = "submitLogin";

    public LoginPage(WebDriver driver) {
        super(driver);
        this.url = URLHolder.LOGIN_PAGE.getURL();
    }

    public MainMenu login() {
        driver.get(url);
        driver.findElement(By.id(emailLocator)).sendKeys(UserData.LOGIN.getData());
        driver.findElement(By.id(passLocator)).sendKeys(UserData.PASS.getData());
        driver.findElement(By.name(submitLocator)).click();
        return new MainMenu(driver);
    }
}
