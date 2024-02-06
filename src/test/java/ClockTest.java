import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class ClockTest {

    @Test
    public void capability() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "uiautomator2");
        caps.setCapability("appActivity", "com.android.deskclock.DeskClock");

        AndroidDriver driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"), caps
        );
        driver.quit();
    }

}
