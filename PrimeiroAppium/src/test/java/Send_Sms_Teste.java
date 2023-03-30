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
        DesiredCapabilities caps = new DesiredCapabilities();   // valores envviados para o Appium servidor
        caps.setCapability("platformName", "Android");  // mostrando qual plataforma usando
        caps.setCapability("automationName", "UiAutomator2"); // inspeção de elementos
        caps.setCapability("platformVersion", "9.0"); // versão do android
        caps.setCapability("deviceName", "Android Emulator"); // nome do emulador
        caps.setCapability("appPackage", "com.google.android.apps.messaging");//pacote de Info do app que vc quer que rode
        caps.setCapability("appActivity", ".ui.ConversationListActivity");//Nome da atividade que você deseja iniciar a partir do pacote do Android
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);//redirecionando pro servidor do appium
    }

    @Test
    public void send_SMS() {// variavel mandando mensagem
        driver.sendSMS("555-123-4567", "Me busca na farmacia RONI"); //mandando msg


    }

    @AfterTest  //método final, só vai executar depois de todos os outros serem finalizados
    public void tearDown() {  // declarando variavel fechar
        if (null != driver) {
            driver.quit();
        }
    }
}