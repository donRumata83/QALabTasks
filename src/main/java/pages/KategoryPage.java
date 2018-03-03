package pages;

import org.openqa.selenium.WebDriver;
import pages.enums.URLHolder;

public class KategoryPage extends Page {
    private String url;

    KategoryPage(WebDriver driver) {
        super(driver);
        this.url = URLHolder.KATEGORY.getURL();
    }


}
