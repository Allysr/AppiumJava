package page;

import core.DriverFactory;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AbaPage {
    AndroidDriver driver = DriverFactory.getDriver();

    public String obterTextoAbaUm(){
        return driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Este é o conteúdo da Aba 1\"]")).getText();
    }

    public void clicarAbaDois(){
        driver.findElement(AppiumBy.xpath("(//android.view.View[@class=\"android.view.View\"])[3]\n")).click();
    }

    public  String obterTextoAbaDois(){
        return driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Este é o conteúdo da Aba 2\"]")).getText();
    }

}
