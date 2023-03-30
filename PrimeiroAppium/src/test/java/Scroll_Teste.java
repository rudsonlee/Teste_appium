import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Scroll_Teste {

    public AppiumDriver driver;  //variavel global
    public AndroidTouchAction actions; //variavel ação toque global

    @BeforeTest //Método que vem antes de qual quer ação
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities(); // valores envviados para o Appium servidor
        capabilities.setCapability("platformName", "Android"); // mostrando qual plataforma usando
        capabilities.setCapability("platformVersion", "9.0"); // versão do android
        capabilities.setCapability("deviceName", "Android Emulator");// nome do emulador
        capabilities.setCapability("app", System.getProperty("user.dir") + "/apps/ApiDemos.apk"); //direcionando app integrado
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities); //redirecionando pro servidor do appium
    }

    private void scrollDown() { //criando uma classe privada para rolar pra baixo
        Dimension dimension = driver.manage().window().getSize(); // criando dimensão
        int scrollStart = (int) (dimension.getHeight() * 0.8); //primeira dimensão rolagem inicial
        int scrollEnd = (int) (dimension.getHeight() * 0.1); //segundo dimensão rolagem  final

        actions = new AndroidTouchAction(driver) //nova ação de toque
                .press(PointOption.point(0, scrollStart)) //ponto  de inicio da rolagem
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3))) //ação de espera
                .moveTo(PointOption.point(0, scrollEnd)) //fim da rolagem
                .release() //liberação
                .perform(); //executar
    }

    @Test // Ação do  teste
    public void scroll_test() {//criando classe para rolagem
        AndroidElement views =
                (AndroidElement) driver.findElementByAccessibilityId("Views"); //criando acesso para "views"
        // Tap
        actions = new AndroidTouchAction(driver); //criando ação para agir com o driver
        actions.tap(ElementOption.element(views)).perform(); // ação para dar o toque no views
        // ScrollDown
        scrollDown(); // metodo de rolagem
        AndroidElement lists = (AndroidElement) driver.findElementByAccessibilityId("Lists");// criando acesso até lists
        actions.tap(ElementOption.element(lists)).perform();//selecionando elemento lists
    }

    @AfterTest  //método final, só vai executar depois de todos os outros serem finalizados
    public void tearDown() {  // declarando variavel fechar
        if (null != driver) {
            driver.quit();
        }
    }

}