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

public class Calcula_Teste {

    AppiumDriver driver;      //variavel global

    @BeforeTest               //Método que vem antes de qual quer ação
    public void setUp() throws MalformedURLException {   //**
        DesiredCapabilities caps = new DesiredCapabilities();   // valores envviados para o Appium servidor
        caps.setCapability("platformName", "Android");  // mostrando qual plataforma usando
        caps.setCapability("automationName", "UiAutomator2"); // inspeção de elementos
        caps.setCapability("platformVersion", "9.0"); // versão do android
        caps.setCapability("deviceName", "Android Emulator"); // nome do emulador
        caps.setCapability("appPackage", "com.android.calculator2");//pacote de Info do app que vc quer que rode
        caps.setCapability("appActivity", ".Calculator"); //Nome da atividade que você deseja iniciar a partir do pacote do Android
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps); //redirecionando pro servidor do appium
    }

    @Test   // Ação do  teste
    public void click_test() {    // variavel click
        driver.findElement(By.id("digit_5")).click(); // encontrando elemento CLICK 5
        driver.findElement(By.id("op_add")).click();// encontrando elemento CLICK SOMA(+)
        driver.findElement(By.id("digit_5")).click();// encontrando elemento CLICK 5
        driver.findElement(By.id("eq")).click(); // encontrando elemento IGUAL (=)
        driver.findElement(By.id("op_add")).click();// encontrando elemento CLICK SOMA(+)
        driver.findElement(By.id("digit_5")).click();// encontrando elemento CLICK 5
        driver.findElement(By.id("op_add")).click();// encontrando elemento CLICK SOMA(+)
        driver.findElement(By.id("digit_5")).click();// encontrando elemento CLICK 5
        driver.findElement(By.id("eq")).click();// encontrando elemento IGUAL (=)

        Assert.assertEquals(driver.findElement(By.id("result")).getText(),"20"); // validação


    }

    @AfterTest  //método final, só vai executar depois de todos os outros serem finalizados
    public void tearDown() {  // declarando variavel fechar
        if (null != driver) {
            driver.quit();
        }
    }
}