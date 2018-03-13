package application.adminPages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.Random;

class NewGoodPage extends Page {

    private By nameOfGood = By.id("form_step1_name_1");
    private By amounts = By.xpath("//*[@id=\"tab_step3\"]/a");
    private By amountField = By.xpath("//*[@id=\"form_step3_qty_0\"]");
    private By priceField = By.xpath("//*[@id=\"form_step2_price\"]");
    private By submitButton = By.id("submit");

    private NewGoodPage(EventFiringWebDriver driver) {
        super(driver);
    }


    public NewGoodPage createNewGood(String nameOfGoodToCreate) {
        clearAndSend(nameOfGood, nameOfGoodToCreate);
        driver.findElement(amounts).click();
        clearAndSend(amountField, getRandom());
        clearAndSend(priceField, getRandom());
        driver.findElement(submitButton).click();
        return this;
    }

    private void clearAndSend(By field, String text) {
        driver.findElement(field).clear();
        driver.findElement(field).sendKeys(text);
    }
    private String getRandom() {
        int tmp =new Random().nextInt(100);
        return "" + tmp;
    }
}
