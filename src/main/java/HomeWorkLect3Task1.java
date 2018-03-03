import org.openqa.selenium.WebDriver;
import pages.*;

public class HomeWorkLect3Task1 {
    public static void main(String[] args) {
        WebDriver driver = WebDriverUtils.initChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        MainMenu mainPage = loginPage.login();
        KatalogPage katalog = mainPage.clickKatalogButton();
        KategoryPage kategory = katalog.clickCategoryButton();

    }
}
