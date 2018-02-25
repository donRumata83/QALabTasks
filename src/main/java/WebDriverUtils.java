import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class WebDriverUtils {
    private static final String URL = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";
    private static final String EMAIL = "webinar.test@gmail.com";
    private static final String PASS = "Xcg7299bnSmMuRLp9ITw";

    public static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        return new ChromeDriver(options);
    }

    public static WebDriver login(WebDriver driver) {
        driver.get(URL);
        driver.findElement(By.name("email")).sendKeys(EMAIL);
        driver.findElement(By.name("passwd")).sendKeys(PASS);
        driver.findElement(By.name("submitLogin")).click();
        return driver;
    }

    public static WebDriver waitForOneSecond(WebDriver driver) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver;
    }

    public static WebDriver logout(WebDriver driver) {
        driver.findElement(By.className("img-thumbnail")).click();
        driver.findElement(By.id("header_logout")).click();
        return driver;
    }

    public static void checkTheButtons(WebDriver driver) {
        List<WebElement> buttonsOnMainTab = driver.findElements(By.className("maintab"));
        System.out.println(buttonsOnMainTab.size());
        System.out.println(buttonsOnMainTab.get(0));
        for (WebElement element : buttonsOnMainTab) {
            element.click();
            waitForOneSecond(driver);
            String tempURL = driver.getCurrentUrl();
            System.out.println(tempURL);
            driver.navigate().refresh();
            waitForOneSecond(driver);
            System.out.println("Is the user stays on the same page = " + tempURL.equals(driver.getCurrentUrl()));
            driver.navigate().back();
            waitForOneSecond(driver);
        }
    }
}
