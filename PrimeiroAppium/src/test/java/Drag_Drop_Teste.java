import io.appium.java_client.AppiumDriver;
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

public class Drag_Drop_Teste {

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
    public void drag_drop() { //criando classe segurar e arrastar
        AndroidElement views =
                (AndroidElement) driver.findElementByAccessibilityId("Views");//criando acesso para "views"

        actions = new AndroidTouchAction(driver);//criando ação para agir com o driver
        actions.tap(ElementOption.element(views)).perform();// ação para dar o toque no views

        AndroidElement drag_drop =
                (AndroidElement) driver.findElementByAccessibilityId("Drag and Drop");//criando acesso até drag drop
        actions.tap(ElementOption.element(drag_drop)).perform();//selecionando elemento drag drop

        AndroidElement drag = (AndroidElement) driver.findElement(By.id("drag_dot_3")); //adicionando elemento drag3(arrastar)
        AndroidElement drop = (AndroidElement) driver.findElement(By.id("drag_dot_2"));//adicionando elemento dot2(soltar)

        actions.longPress(ElementOption.element(drag)) //adicionando elemento de click longo no drag(arrastar)
                .waitAction().moveTo(ElementOption.element(drop)) // movendo e soltar
                .release() //liberação
                .perform(); //executar
    }

    @AfterTest  //método final, só vai executar depois de todos os outros serem finalizados
    public void tearDown() {  // declarando variavel fechar
        if (null != driver) {
            driver.quit();
        }
    }

}