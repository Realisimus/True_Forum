package framework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public abstract class Driver {
    private static final int DEFAULT_TIMEOUT = 15;
    private static WebDriver instance;
    private static WebDriverWait wait;

    public static WebDriver getInstance() {
        if (instance == null) {
            instance = new FirefoxDriver();
            instance.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        }
        return instance;
    }

    public static WebDriverWait getWait() {
        if (wait == null)
            wait = new WebDriverWait(instance, DEFAULT_TIMEOUT);
        return wait;
    }

    public static void close() throws InterruptedException {
        Thread.sleep(5000);
        instance.quit();
    }
}
