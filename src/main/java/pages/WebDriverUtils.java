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

    public static void checkTheButtons(WebDriver driver) {
        int counter = 0;
        for (int i = 0; i < 13; i++) {
            if (i != 0) {
                driver.findElements(By.className("maintab")).get(i).click();
                waitForOneSecond(driver);
                String tempURL = driver.getCurrentUrl();
                System.out.println(tempURL);
                driver.navigate().refresh();
                waitForOneSecond(driver);
                if (tempURL.equals(driver.getCurrentUrl())) {
                    System.out.println("Is the user stays on the same page = true");
                    counter++;
                } else break;
                driver.navigate().back();
                waitForOneSecond(driver);
            } else {
                driver.findElements(By.className("maintab")).get(i).click();
                waitForOneSecond(driver);
                String tempURL = driver.getCurrentUrl();
                System.out.println(tempURL);
                driver.navigate().refresh();
                waitForOneSecond(driver);
                if (tempURL.equals(driver.getCurrentUrl())) {
                    System.out.println("Is the user stays on the same page = true");
                    counter++;
                } else break;
            }
        }
        System.out.println(counter);
    }
}
