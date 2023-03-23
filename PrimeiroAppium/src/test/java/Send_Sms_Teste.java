import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Send_Sms_Teste {

    public AndroidDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "9.0");
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("appPackage", "com.google.android.apps.messaging");
        caps.setCapability("appActivity", ".ui.ConversationListActivity");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    @Test
    public void send_SMS() {
        driver.sendSMS("555-123-4567", "Me busca na farmacia RONI");


    }

    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}