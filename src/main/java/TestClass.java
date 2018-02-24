import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {
    public static void main(String[] args) {

        WebDriver webDriver = initChromeDriver();
    }

    public static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
        return new  ChromeDriver();
    }
}
