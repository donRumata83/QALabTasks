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
        Reporter.log("Open admin page");
        LoginPage loginPage = new LoginPage(driver);
        Reporter.log("Login");
        MainMenu mainPage = loginPage.login();
        Reporter.log("Go to catalog");
        CatalogPage catalog = mainPage.clickKatalogButton();
        Reporter.log("Go to goods page");
        GoodsPage goods = catalog.clickGoodsButton();
        NewGoodPage newGoods = goods.clickNewGoodButton();
        Reporter.log("Create new good");
        String message = newGoods.createNewGood(goodName, amount, price);
        Reporter.log("Check the creating");
        Assert.assertEquals(message, "×\n" +
                "Настройки обновлены.", "The good didn't created correct");
        Reporter.log("The good is created");
    }


    @Test(dependsOnMethods = "testAdminPartForAddingTheNewProduct")
    public void testIfGoodPresentAndActual() {
        Reporter.log("Open shop page");
        UserStartPage startPage = new UserStartPage(driver);
        Reporter.log("Go to all goods");
        UserAllGoodsPage userAllGoodsPage = startPage.goToAllGoodsPage();
        Reporter.log("Find the created good");
        Assert.assertTrue(userAllGoodsPage.isElementPresent(goodName));
        Reporter.log("Open the good page");
        UserGoodPage goodPage = userAllGoodsPage.clickToGoodPage(goodName);
        Reporter.log("Check all params of the good");
        Assert.assertEquals(goodName.toUpperCase(), goodPage.getGoodName(), "The name is correct");
        Reporter.log("The name is correct");
        Assert.assertEquals(price, goodPage.getPrice(), "The price is incorrect");
        Reporter.log("The price is correct");
        Assert.assertEquals(amount, goodPage.getAmount(), "The amount is incorrect");
        Reporter.log("All params are wright, test case is passed");
    }
}
