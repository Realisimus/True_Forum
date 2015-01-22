package framework;

import framework.pageObjects.Driver;
import framework.pageObjects.LoginPage;
import org.testng.Assert;

public class Login {

    public static void login(String username, String password) {
        Driver.getInstance().navigate().to("http://localhost:8080");
        LoginPage.loginField().sendKeys(username);
        LoginPage.passwordField().sendKeys(password);
        LoginPage.submitButton().click();
    }

    public static void logout() {
        LoginPage.logoutButton().click();
    }
}
