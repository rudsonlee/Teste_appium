import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Treino {
    private AppiumDriver driver;


    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformVersion", "10.0");
        capabilities.setCapability("deviceName", "Pixel 6 API 29");
        capabilities.setCapability("browserName", "Chrome");
//        Ccapabilities.setCapability("appActivity", "WebView Browser Tester");
//       capabilities.setCapability("chromedriverExecutable", "J:/Downloads/app/chromedriver");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    @Test
    public void open_URL() {
        driver.get("https://the-internet.herokuapp.com/login");
        //driver.findElement(By.id("id")).click();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}