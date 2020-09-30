package AlertTest.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.URL;
import java.util.Set;

public class HelperBase {
    protected WebDriver webDriver;
    protected WebDriverWait wait;


    public HelperBase(WebDriver webDriver) {

        this.webDriver = webDriver;
    }


    // function that receive locator and click on it
    protected void clickByLocator(By locator) {

        webDriver.findElement(locator).click();
    }

    // function that fill text by locator (input,text box etc)
    protected void clickAndFillTextByLocator(By locator, String text) {
        clickByLocator(locator);
        if (text != null) {//if text not null
            String existingText = webDriver.findElement(locator).getAttribute("value");//take the value
            if (!text.equals(existingText)) {
                webDriver.findElement(locator).clear();
                webDriver.findElement(locator).sendKeys(text);
            }
        }
    }

    // check if element is present and then return the element
    protected WebElement findElementByLocator(By locator) {
        if (isElementPresentByLocator(locator)) {
            WebElement element = webDriver.findElement(locator);
            return element;
        }
        return null;
    }

    // function that check if element is present
    protected boolean isElementPresentByLocator(By locator) {
        try {
            webDriver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    protected void navigateToURL(String countryURL) {
        webDriver.navigate().to(countryURL);

    }

    // Switch to new window opened
    public void switchToNewWindowAndClose() {
        String existingWindow = webDriver.getWindowHandle();
        Set<String> windows = webDriver.getWindowHandles();
        windows.remove(existingWindow);
        String newWindow = windows.iterator().next();
        webDriver.switchTo().window(newWindow);
        webDriver.close();
        webDriver.switchTo().window(existingWindow);
    }




}
