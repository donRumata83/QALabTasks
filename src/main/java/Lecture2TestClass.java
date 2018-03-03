import Pages.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

public class Lecture2TestClass {
    public static void main(String[] args) {
        WebDriver webDriver = WebDriverUtils.initChromeDriver();
        webDriver.get("https://www.bing.com");
        WebElement fieldSearch = webDriver.findElement(By.id("sb_form_q"));
        fieldSearch.sendKeys("selenium");
        WebElement button = webDriver.findElement(By.name("go"));
        button.click();
        List<WebElement> refers = webDriver.findElements(By.className("b_algo"));
        System.out.println(refers.size());
        webDriver.navigate().back();
        webDriver.quit();

    }
}
