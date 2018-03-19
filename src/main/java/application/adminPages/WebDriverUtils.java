package application.adminPages;


import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import io.github.bonigarcia.wdm.OperaDriverManager;
import application.loger.Logger;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;


public class WebDriverUtils {
    public static EventFiringWebDriver initDriver(String arg) {
        WebDriver driver = getDriver(arg);
        EventFiringWebDriver webDriver = new EventFiringWebDriver(driver);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.register(new Logger());
        return webDriver;
    }

    public static WebDriver waitForOneSecond(WebDriver driver) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver;
    }

    private static WebDriver getChrome() {
        ChromeDriverManager.getInstance().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        return new ChromeDriver(options);
    }

    private static WebDriver getDriver(String driver) {
        switch (driver) {
            case "chrome":
                return getChrome();
            case "ie":
                return getIE();
            case "firefox":
                return getFireFox();
            case "opera":
                return getOpera();
            default:
                return getChrome();
        }
    }

    private static WebDriver getOpera() {
        OperaDriverManager.getInstance().setup();
        return new OperaDriver();
    }

    private static WebDriver getFireFox() {
        FirefoxDriverManager.getInstance().setup();
        return new FirefoxDriver();
    }

    private static WebDriver getIE() {
        InternetExplorerDriverManager.getInstance().setup();
        InternetExplorerOptions options = new InternetExplorerOptions().requireWindowFocus().
                setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT).enablePersistentHovering().destructivelyEnsureCleanSession();
        options.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        return new InternetExplorerDriver(options);
    }

    public static String getBrowserFromArgs(String[] arg) {
        if (arg.length != 0) {
            return arg[0];
        } else return "";
    }
}
