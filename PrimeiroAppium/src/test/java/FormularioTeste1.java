import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FormularioTeste1 {

    public AppiumDriver driver;


    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "9.0");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("app", System.getProperty("user.dir") + "/apps/Browser2/Browser2.apk");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    @Test
    public void UserLogin() {
        driver.findElements(By.className("android.widget.TextView"));



    }

    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }

}