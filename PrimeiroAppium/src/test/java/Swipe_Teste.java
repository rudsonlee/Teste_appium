import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Swipe_Teste {

    public AppiumDriver driver;//variavel global
    public AndroidTouchAction actions;//variavel ação toque global

    @BeforeTest//Método que vem antes de qual quer ação
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities(); // valores envviados para o Appium servidor
        capabilities.setCapability("platformName", "Android"); // mostrando qual plataforma usando
        capabilities.setCapability("platformVersion", "9.0"); // versão do android
        capabilities.setCapability("deviceName", "Android Emulator");// nome do emulador
        capabilities.setCapability("app", System.getProperty("user.dir") + "/apps/ApiDemos.apk"); //direcionando app integrado
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities); //redirecionando pro servidor do appium
    }

    @Test// Ação do  teste
    public void swipe_test() { //criando classe deslizar
        AndroidElement views = (AndroidElement)
                driver.findElementByAccessibilityId("Views");//criando acesso para "views"

        //Tap
        actions = new AndroidTouchAction(driver);//criando ação para agir com o driver
        actions.tap(ElementOption.element(views)).perform();// ação para dar o toque no views


        AndroidElement gallery = (AndroidElement)
                driver.findElementByAccessibilityId("Gallery");//criando acesso para "gallery"
        actions.tap(ElementOption.element(gallery)).perform();// ação para dar o toque no gallery


        AndroidElement photo = (AndroidElement)
                driver.findElementByAccessibilityId("1. Photos");//criando acesso para "photos"
        actions.tap(ElementOption.element(photo)).perform();// ação para dar o toque no photos

        AndroidElement pic1 =  //adicionando elemento para clicar na imagem
                (AndroidElement) driver.findElements(By.className("android.widget.ImageView")).get(0);

        actions.press(ElementOption.element(pic1)) //ação para aperta o botao
                .waitAction() //esperar as ações
                .moveTo(PointOption.point(-20, 210)) //movimentar para lugar desejado(-20 e 210)
                .release()//liberação
                .perform();//executar
    }

    @AfterTest  //método final, só vai executar depois de todos os outros serem finalizados
    public void tearDown() {  // declarando variavel fechar
        if (null != driver) {
            driver.quit();
        }
    }

}