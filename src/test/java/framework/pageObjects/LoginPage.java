package framework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage {

    private static WebElement waitElement(By loc) {
        return Driver.getWait().until(ExpectedConditions.presenceOfElementLocated(loc));
    }

    public static WebElement loginField() {
        return waitElement(By.name("login"));
    }

    public static WebElement passwordField() {
        return waitElement(By.name("password"));
    }

    public static WebElement submitButton() {
        return waitElement(By.name("submit"));
    }

    public static WebElement loginError() {
        return waitElement(By.xpath("/html/body/h3"));
    }

    public static WebElement logoutButton() {
        return waitElement(By.xpath("/html/body/a[1]"));
    }

}
