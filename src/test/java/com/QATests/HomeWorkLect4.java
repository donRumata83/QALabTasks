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

import static org.testng.Reporter.log;


public class HomeWorkLect4 {

    private EventFiringWebDriver driver;
    private String goodName = UserData.NEWGOOD.getData() + new Random().nextInt(100);
    private int price = new Random().nextInt(100);
    private int amount = new Random().nextInt(100);

    @BeforeMethod
    @Parameters({"driver"})
    public void setupDriver(String driver) {
        this.driver = WebDriverUtils.initDriver(driver);
        Reporter.setEscapeHtml(false);
    }

    @AfterMethod
    public void exit() {
        driver.quit();
    }

    @Test
    public void testAdminPartForAddingTheNewProduct() {
        log("Open admin page");
        LoginPage loginPage = new LoginPage(driver);
        log("Login");
        MainMenu mainPage = loginPage.login();
        log("Go to catalog");
        CatalogPage catalog = mainPage.clickKatalogButton();
        log("Go to goods page");
        GoodsPage goods = catalog.clickGoodsButton();
        NewGoodPage newGoods = goods.clickNewGoodButton();
        log("Create new good");
        String message = newGoods.createNewGood(goodName, amount, price);
        log("Check the creating");
        Assert.assertEquals(message, "×\n" +
                "Настройки обновлены.", "The good didn't created correct");
        log("The good is created");
    }


    @Test(dependsOnMethods = "testAdminPartForAddingTheNewProduct")
    public void testIfGoodPresentAndActual() {
        log("Open shop page");
        UserStartPage startPage = new UserStartPage(driver);
        log("Go to all goods");
        UserAllGoodsPage userAllGoodsPage = startPage.goToAllGoodsPage();
        log("Find the created good");
        Assert.assertTrue(userAllGoodsPage.isElementPresent(goodName));
        log("Open the good page");
        UserGoodPage goodPage = userAllGoodsPage.clickToGoodPage(goodName);
        log("Check all params of the good");
        Assert.assertEquals(goodName.toUpperCase(), goodPage.getGoodName(), "The name is correct");
        log("The name is correct");
        Assert.assertEquals(price, goodPage.getPrice(), "The price is incorrect");
        log("The price is correct");
        Assert.assertEquals(amount, goodPage.getAmount(), "The amount is incorrect");
        log("All params are wright, test case is passed");
    }
}
