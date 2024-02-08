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
    @Test
    public void validarTodosCampos(){
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Formulário' and @class='android.widget.TextView']")).click();

        driver.findElement(AppiumBy.accessibilityId("nome")).sendKeys("Alicia");
        driver.findElement(AppiumBy.accessibilityId("console")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
        driver.findElement(AppiumBy.accessibilityId("switch")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"SALVAR\" and @class=\"android.widget.TextView\"]\n")).click();

        WebElement nome  = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Nome: Alicia\" and @class=\"android.widget.TextView\"]"));
        WebElement console = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Console: switch\" and @class=\"android.widget.TextView\"]\n"));
        WebElement slider = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Slider: 25\" and @class=\"android.widget.TextView\"]"));
        WebElement elementoSwitch = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Switch: Off\" and @class=\"android.widget.TextView\"]"));
        WebElement checkbox = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Checkbox: Marcado\" and @class=\"android.widget.TextView\"]\n"));
        WebElement data = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Data: 01/01/2000\" and @class=\"android.widget.TextView\"]\n"));
        WebElement hora = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Hora: 12:00\" and @class=\"android.widget.TextView\"]\n"));


        Assertions.assertEquals("Nome: Alicia", nome.getAttribute("text"));
        Assertions.assertEquals("Console: switch", console.getAttribute("text"));
        Assertions.assertEquals("Slider: 25", slider.getAttribute("text"));
        Assertions.assertEquals("Switch: Off", elementoSwitch.getAttribute("text"));
        Assertions.assertEquals("Checkbox: Marcado", checkbox.getAttribute("text"));
        Assertions.assertEquals("Data: 01/01/2000", data.getAttribute("text"));
        Assertions.assertEquals("Hora: 12:00", hora.getAttribute("text"));

    }

    @AfterEach
    public void fecharDriver(){
        driver.quit();
    }

}
