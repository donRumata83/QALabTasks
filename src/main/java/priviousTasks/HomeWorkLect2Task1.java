package priviousTasks;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import application.adminPages.LoginPage;
import application.adminPages.MainMenu;
import application.adminPages.WebDriverUtils;

public class HomeWorkLect2Task1 {
    public static void main(String[] args) {
        EventFiringWebDriver driver = WebDriverUtils.initDriver(args[0]);
        LoginPage loginPage = new LoginPage(driver);
        MainMenu mainPage = loginPage.login();
        WebDriverUtils.waitForOneSecond(driver);
        mainPage.logout();
        WebDriverUtils.waitForOneSecond(driver);
        driver.quit();

    }

}
