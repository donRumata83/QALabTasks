package com.QATests;

import application.Good;
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
    private Good newGood = new Good();

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
        String message = newGoods.createNewGood(newGood.getName(), newGood.getAmount(), newGood.getPrice());
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
        Assert.assertTrue(userAllGoodsPage.isElementPresent(newGood.getName()));
        log("Open the good page");
        UserGoodPage goodPage = userAllGoodsPage.clickToGoodPage(newGood.getName());
        log("Check all params of the good");
        Assert.assertEquals(newGood.getName().toUpperCase(), goodPage.getGoodName(), "The name is correct");
        log("The name is correct");
        Assert.assertEquals(newGood.getPrice(), goodPage.getPrice(), "The price is incorrect");
        log("The price is correct");
        Assert.assertEquals(newGood.getPrice(), goodPage.getAmount(), "The amount is incorrect");
        log("All params are wright, test case is passed");
    }
}
