import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class FormularioTeste {

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
    public void validarFormulario(){
        WebElement el = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Formulário' and @class='android.widget.TextView']"));
        el.click();
    }


    @AfterEach
    public void fecharDriver(){
        driver.quit();
    }

}
