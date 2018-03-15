package com.QATests;

import application.userPages.UserAllGoodsPage;
import application.userPages.UserGoodPage;
import application.userPages.UserStartPage;
import application.adminPages.*;
import application.enums.UserData;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.util.Random;


public class HomeWorkLect4 {

    EventFiringWebDriver driver;
    private String goodName = UserData.NEWGOOD.getData() + new Random().nextInt(100);
    private int price = new Random().nextInt(100);
    private int amount = new Random().nextInt(100);

    @BeforeMethod
    public void setupDriver() {
        this.driver = WebDriverUtils.initDriver("");
        Reporter.setEscapeHtml(false);
    }

    @AfterMethod
    public void exit() {
        driver.quit();
    }

    @Test
    public void testAdminPartForAddingTheNewProduct() {

        LoginPage loginPage = new LoginPage(driver);
        MainMenu mainPage = loginPage.login();
        CatalogPage catalog = mainPage.clickKatalogButton();
        GoodsPage goods = catalog.clickGoodsButton();
        NewGoodPage newGoods = goods.clickNewGoodButton();
        String message = newGoods.createNewGood(goodName, amount, price);
        Assert.assertEquals(message, "×\n" +
                "Настройки обновлены.", "The good didn't created correct");
    }


    @Test(dependsOnMethods = "testAdminPartForAddingTheNewProduct")
    public void testIfGoodPresentAndActual() {
        UserStartPage startPage = new UserStartPage(driver);
        UserAllGoodsPage userAllGoodsPage = startPage.goToAllGoodsPage();
        Assert.assertTrue(userAllGoodsPage.isElementPresent(goodName));
        UserGoodPage goodPage = userAllGoodsPage.clickToGoodPage(goodName);
        Assert.assertEquals(goodName, goodPage.getGoodName().toUpperCase(), "The name is correct");
        Assert.assertEquals(price, goodPage.getPrice(), "The price is incorrect");
        Assert.assertEquals(amount, goodPage.getAmount(), "The amount is incorrect");
    }
}
