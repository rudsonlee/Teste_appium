import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Android_Chrome_Test {

    private AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformVersion", "10.0");
        capabilities.setCapability("deviceName", "Pixel 6 API 29");
        capabilities.setCapability("browserName", "Chrome");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    @Test
public void Userlogin (){
        driver.get ("https://the-internet.herokuapp.com/login");
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);
        WebElement username = driver.findElementByCssSelector("input#username");
        username.sendKeys("tomsmith");
        WebElement password = driver.findElementByCssSelector("input#password");
        password.sendKeys("SuperSecretPassword!");
        WebElement LoginBtn = driver.findElementByCssSelector("button#radius");
        LoginBtn.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("secure"));
        System.out.println(driver.getCurrentUrl());
        







    }
    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }

}