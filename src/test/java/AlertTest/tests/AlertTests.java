package AlertTest.tests;

import AlertTest.appmanager.CountryPageHelper;
import AlertTest.appmanager.HelperBase;
import AlertTest.appmanager.LoginAdminHelper;
import AlertTest.datatest.LoginAdminDataProvider;
import AlertTest.model.LoginAdmin;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class AlertTests extends TestBase {
    private WebDriverWait wait;
    private LoginAdminHelper loginAdminHelper;
    private CountryPageHelper countryPageHelper;
    private HelperBase helperBase;

    @BeforeTest
    public void init() {

        loginAdminHelper = new LoginAdminHelper(applicationManager.getWebDriver());
        countryPageHelper = new CountryPageHelper(applicationManager.getWebDriver());
        wait = new WebDriverWait(applicationManager.getWebDriver(), Duration.ofSeconds(10));
        helperBase = new HelperBase(applicationManager.getWebDriver());

    }

    @Test(dataProvider = "LoginAdmin", dataProviderClass = LoginAdminDataProvider.class)
    public void testLoginAdmin(LoginAdmin loginAdminTest) {
        loginAdminHelper.fillAdminLogin(loginAdminTest);
        wait.until(titleContains("My Store"));
        countryPageHelper.countryPageURL();
        wait.until(titleContains("Countries | My Store"));
        countryPageHelper.clickAddNewCountryButton();

        List<WebElement> allClicks = countryPageHelper.getListLinks();//get list with all <a>
//        Assert.assertFalse(allClicks.isEmpty());// will fail if allclicks  less than 1
        for (int i = 0; i < allClicks.size(); i++) {
            WebElement ElementToClick = allClicks.get(i);
            ElementToClick.click();
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
            testNewWindow();
        }
    }

    public void testNewWindow() {
        helperBase.switchToNewWindowAndClose();
    }
}

