import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class FormularioTeste {

    @Test
    public void deveInstalarAPK() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "uiautomator2");
        caps.setCapability("app", "C:\\Users\\allys\\IdeaProjects\\Appium\\src\\test\\resources\\CTAppium_2_0.apk");

        AndroidDriver driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"), caps
        );
        driver.quit();
    }

}
