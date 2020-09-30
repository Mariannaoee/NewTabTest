package AlertTest.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    // web driver
    WebDriver webDriver;

    // web browser that we choose
    private String browser;


    // constructor that receive the browser type

    public ApplicationManager(String browser) {

        this.browser = browser;
    }

    public void init(String webUrl) {
        // initialize Browser
        initializeBrowser();
        webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get(webUrl);


    }

    // initialize browser by browser type that received from constructor
    private void initializeBrowser() {

        if (browser.equals(BrowserType.FIREFOX)) {
            webDriver = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            webDriver = new ChromeDriver();
        } else if (browser.equals(BrowserType.IE)) {
            webDriver = new InternetExplorerDriver();
        }
    }

    // stop the web driver
    public void stop() {

        webDriver.quit();
    }



    public WebDriver getWebDriver() {

        return webDriver;
    }


}

