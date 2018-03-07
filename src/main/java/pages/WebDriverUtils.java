package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class WebDriverUtils {
    public static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", new File(WebDriverUtils.class.getResource("/chromedriver.exe").getFile()).getPath());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        return new ChromeDriver(options);
    }

    public static WebDriver waitForOneSecond(WebDriver driver) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
