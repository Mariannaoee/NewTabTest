package AlertTest.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CountryPageHelper extends HelperBase {

    public CountryPageHelper(WebDriver webDriver) {
        super(webDriver);
    }

    public void countryPageURL() {
        navigateToURL("http://localhost/litecart/public_html/admin/?app=countries&doc=countries");

    }

    public void clickAddNewCountryButton() {
        clickByLocator(By.linkText("Add New Country"));
    }

    public void clickNewWindow() {
        clickByLocator(By.className("fa-external-link"));
    }

    public List<WebElement> getListLinks() {
        List<WebElement> rows = webDriver.findElements(By.className("fa-external-link"));
        return rows;


    }

}

