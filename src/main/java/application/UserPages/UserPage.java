package application.UserPages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserPage {
    EventFiringWebDriver driver;
    private WebDriverWait waiter;

    UserPage(EventFiringWebDriver driver) {
        this.driver = driver;
        this.waiter = new WebDriverWait(driver, 10);
    }

    void customWait(By element) {
        waiter.until(ExpectedConditions.presenceOfElementLocated(element));
    }
}
