import loger.Logger;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import pages.*;

public class HomeWorkLect3Task1 {
    public static void main(String[] args) {
        EventFiringWebDriver driver = WebDriverUtils.initDriver(args[0]);
        Logger logger = new Logger();
        LoginPage loginPage = new LoginPage(driver);
        MainMenu mainPage = loginPage.login();
        CatalogPage catalog = mainPage.clickKatalogButton();
        CategoryPage category = catalog.clickCategoryButton();
        NewCategoryPage newCategory = category.clickNewCategoryButton();
        category = newCategory.createNewCategory();
        category.sortListByName();
        category.logout();
        driver.quit();
    }
}
