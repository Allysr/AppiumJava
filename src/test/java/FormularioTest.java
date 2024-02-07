import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class FormularioTest {

    AndroidDriver driver;

    @BeforeEach
    public void abrirDriver() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "uiautomator2");
        caps.setCapability("app", "C:\\Users\\allys\\IdeaProjects\\Appium\\src\\test\\resources\\CTAppium_2_0.apk");

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"), caps
        );

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void validarFormularioNome(){
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Formulário' and @class='android.widget.TextView']")).click();

        WebElement campoNome = driver.findElement(AppiumBy.accessibilityId("nome"));
        campoNome.sendKeys("Alicia");
        String nome = campoNome.getText();

        Assertions.assertEquals("Alicia", nome);

    }
    @Test
    public void validarFormularioSelecao(){
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Formulário' and @class='android.widget.TextView']")).click();

        driver.findElement(AppiumBy.accessibilityId("console")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
        String opcaoSelecionada = driver.findElement(AppiumBy.xpath("//android.widget.Spinner/android.widget.TextView")).getText();

        Assertions.assertEquals("Nintendo Switch", opcaoSelecionada);
    }

    @Test
    public void validarFormularioCheckboxSwitch(){
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Formulário' and @class='android.widget.TextView']")).click();

        WebElement checkbox = driver.findElement(AppiumBy.className("android.widget.CheckBox"));
        Assertions.assertEquals("false", checkbox.getAttribute("checked"));

        WebElement elementoSwitch = driver.findElement(AppiumBy.accessibilityId("switch"));
        Assertions.assertEquals("true", elementoSwitch.getAttribute("checked"));

        checkbox.click();
        elementoSwitch.click();

        Assertions.assertEquals("true", checkbox.getAttribute("checked"));
        Assertions.assertEquals("false", elementoSwitch.getAttribute("checked"));

    }

    @AfterEach
    public void fecharDriver(){
        driver.quit();
    }

}
