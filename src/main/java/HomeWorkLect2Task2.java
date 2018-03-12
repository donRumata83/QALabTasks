import org.openqa.selenium.support.events.EventFiringWebDriver;
import application.pages.LoginPage;
import application.pages.MainMenu;
import application.pages.WebDriverUtils;


public class HomeWorkLect2Task2 {
    public static void main(String[] args) {
        EventFiringWebDriver driver = WebDriverUtils.initDriver(WebDriverUtils.getBrowserFromArgs(args));
        LoginPage loginPage = new LoginPage(driver);
        MainMenu mainPage = loginPage.login();
        WebDriverUtils.waitForOneSecond(driver);
        mainPage.checkForAllMenuButtons();
        mainPage.logout();
        WebDriverUtils.waitForOneSecond(driver);
        driver.quit();
    }
}
