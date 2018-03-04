import org.openqa.selenium.WebDriver;
import pages.*;

public class HomeWorkLect3Task1 {
    public static void main(String[] args) {
        WebDriver driver = WebDriverUtils.initChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        MainMenu mainPage = loginPage.login();
        CatalogPage catalog = mainPage.clickKatalogButton();
        CategoryPage category = catalog.clickCategoryButton();
        NewCategoryPage newCategory = category.clickNewCategoryButton();
        category = newCategory.createNewCategory();
category.sortListByName();
    }
}
