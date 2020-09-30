package AlertTest.datatest;

import AlertTest.model.LoginAdmin;
import org.testng.annotations.DataProvider;

public class LoginAdminDataProvider {

    @DataProvider(name = "LoginAdmin")
    public static Object[][] getDataFromDataProvider() {
        return new Object[][]{
                {new LoginAdmin("admin", "admin")},

        };
    }
}
