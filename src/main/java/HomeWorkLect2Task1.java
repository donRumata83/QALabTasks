import Pages.LoginPage;
import Pages.MainMenu;
import org.openqa.selenium.WebDriver;

public class HomeWorkLect2Task1 {
    public static void main(String[] args) {
        WebDriver driver = WebDriverUtils.initChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        MainMenu mainPage = loginPage.login();
        WebDriverUtils.waitForOneSecond(driver);
        mainPage.logout();
        WebDriverUtils.waitForOneSecond(driver);
        driver.quit();
    }

}
