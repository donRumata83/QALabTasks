import org.openqa.selenium.support.events.EventFiringWebDriver;
import pages.LoginPage;
import pages.MainMenu;
import pages.WebDriverUtils;


public class HomeWorkLect2Task2 {
    public static void main(String[] args) {
        EventFiringWebDriver driver = WebDriverUtils.initDriver(args[0]);
        LoginPage loginPage = new LoginPage(driver);
        MainMenu mainPage = loginPage.login();
        WebDriverUtils.waitForOneSecond(driver);
        mainPage.checkForAllMenuButtons();
        mainPage.logout();
        WebDriverUtils.waitForOneSecond(driver);
        driver.quit();
    }
}
