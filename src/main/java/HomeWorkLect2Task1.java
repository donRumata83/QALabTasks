import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeWorkLect2Task1 {
    public static void main(String[] args) {
        WebDriver driver = WebDriverUtils.initChromeDriver();
        WebDriverUtils.login(driver);
        WebDriverUtils.waitForOneSecond(driver);
        if (driver.findElement(By.className("img-thumbnail")).isDisplayed()) {
            WebDriverUtils.logout(driver);
        }
        driver.quit();
    }

}
