package AlertTest.tests;
import AlertTest.appmanager.ApplicationManager;
import AlertTest.appmanager.HelperBase;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

// this is our application class that starts the browser and close
public class TestBase {

    // this is our app manager that holds all helper classes and initialize all browser drivers (chrome, firefox,explorer)
    protected static final ApplicationManager applicationManager = new ApplicationManager(BrowserType.CHROME);
    protected static final HelperBase helperBase = new HelperBase(applicationManager.getWebDriver());

    // init all browser and helper classes and make login with session helper class
    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {
        applicationManager.init("http://localhost/litecart/public_html/admin/login.php");
    }

    // stop the browser driver
    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        applicationManager.stop();
    }
}

