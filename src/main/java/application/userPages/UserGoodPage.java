package application.userPages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class UserGoodPage extends UserPage {

    private By name = By.className("h1");
    private By price = By.xpath("//*[@class=\"current-price\"]/span");
    private By amount = By.xpath("//*[@class=\"product-quantities\"]/span");


    UserGoodPage(EventFiringWebDriver driver) {
        super(driver);
    }

    public int getPrice() {
        String tmp = driver.findElement(price).getText();
        tmp = tmp.split(",")[0];
        return Integer.parseInt(tmp);
    }

    public String getGoodName() {
        return driver.findElement(name).getText();
    }


    public int getAmount() {
        String tmp = driver.findElement(amount).getText();
        tmp = tmp.split(" ")[0];
        return Integer.parseInt(tmp);
    }
}
