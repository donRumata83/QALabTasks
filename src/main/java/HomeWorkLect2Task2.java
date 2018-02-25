import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomeWorkLect2Task2 {
    public static void main(String[] args) {
        WebDriver driver = WebDriverUtils.initChromeDriver();
        WebDriverUtils.login(driver);
        WebDriverUtils.waitForOneSecond(driver);
        WebDriverUtils.checkTheButtons(driver);
        if (driver.findElement(By.className("img-thumbnail")).isDisplayed()) {
            WebDriverUtils.logout(driver);
        }
        driver.quit();
    }
}
