import application.pages.enums.UserData;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import application.pages.*;

public class HomeWorkLect3Task1 {
    public static void main(String[] args) {
        EventFiringWebDriver driver = WebDriverUtils.initDriver(WebDriverUtils.getBrowserFromArgs(args));
        LoginPage loginPage = new LoginPage(driver);
        MainMenu mainPage = loginPage.login();
        CatalogPage catalog = mainPage.clickKatalogButton();
        CategoryPage category = catalog.clickCategoryButton();
        NewCategoryPage newCategory = category.clickNewCategoryButton();
        category = newCategory.createNewCategory(UserData.NEW_CATEGORY.getData(), UserData.CPU.getData());
        category.sortListByName(UserData.NEW_CATEGORY.getData());
        category.logout();
        driver.quit();
    }
}
