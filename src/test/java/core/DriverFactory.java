package core;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static AndroidDriver driver;

    public static AndroidDriver getDriver()  {
        if(driver == null){
            createDriver();
        }
        return driver;
    }

    private static void createDriver()  {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("deviceName", "emulator-5554");
            caps.setCapability("platformName", "Android");
            caps.setCapability("automationName", "uiautomator2");
            caps.setCapability("app", "C:\\Users\\allys\\IdeaProjects\\Appium\\src\\test\\resources\\CTAppium_2_0.apk");

            driver = new AndroidDriver(
                    new URL("http://127.0.0.1:4723"), caps
            );

            driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace(); //
        }
    }

    public static void killDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }

}
