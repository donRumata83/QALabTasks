import Pages.LoginPage;
import Pages.MainMenu;
import Pages.WebDriverUtils;
import org.openqa.selenium.WebDriver;


public class HomeWorkLect2Task2 {
    public static void main(String[] args) {
        WebDriver driver = WebDriverUtils.initChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        MainMenu mainPage = loginPage.login();
        WebDriverUtils.waitForOneSecond(driver);
        mainPage.checkForAllMenuButtons();
        mainPage.logout();
        WebDriverUtils.waitForOneSecond(driver);
        driver.quit();
    }
}
