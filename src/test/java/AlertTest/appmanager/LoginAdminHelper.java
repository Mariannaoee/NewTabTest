package AlertTest.appmanager;

import AlertTest.model.LoginAdmin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginAdminHelper extends HelperBase {

    public LoginAdminHelper(WebDriver webDriver) {

        super(webDriver);
    }
    //login admin
    public void fillAdminLogin(LoginAdmin loginAdmin){
     clickAndFillTextByLocator(By.name("username"), loginAdmin.getName());
     clickAndFillTextByLocator(By.name("password"),loginAdmin.getPassword());
     clickByLocator(By.name("login"));
    }



}
