package com.QATests;

import application.adminPages.*;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

public class HomeWorkLect4 {

    private EventFiringWebDriver driver;

    @Parameters ({"driver"})
    @BeforeMethod
    public void setupDriver(String driverFromXML) {
        driver = WebDriverUtils.initDriver(driverFromXML);
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

    }
}
