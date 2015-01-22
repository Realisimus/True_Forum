import framework.Login;
import framework.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import framework.pageObjects.Driver;

public class LoginTest {

    @DataProvider
    public Object [] [] wrongCredentialsData() {
        return new Object [] [] {
                {null, null},
                {"test", "test"},
                {"admin", "123456"}
        };
    }
    @AfterClass
    public static void close() throws InterruptedException {
        Driver.close();
    }
    @Test(dataProvider = "wrongCredentialsData", priority = 0)
    public static void wrongCredentials(String username, String password) {
        Login.login(username, password);
        Assert.assertTrue(LoginPage.loginError().isDisplayed());
    }

    @Test(priority = 1)
    public static void login() {
        Login.login("admin", "12345");
        Assert.assertTrue(LoginPage.logoutButton().isDisplayed());
    }

    @Test(dependsOnMethods = {"login"})
    public static void logout() {
        Login.logout();
        Assert.assertTrue(LoginPage.submitButton().isDisplayed());
    }

}
