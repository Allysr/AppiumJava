package page;

import core.DriverFactory;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AlertaPage {
    AndroidDriver driver = DriverFactory.getDriver();


    public void clicarAlertaSimples(){
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"idButtonTest\"]\n")).click();
    }

    public void clicarAlertaRestritivo(){
        driver.findElement(AppiumBy.id("idButtonTest2")).click();
    }

    public void clicarAlertaConfirm(){
        driver.findElement(AppiumBy.id("idButtonTest3")).click();
    }

    public String obterTituloAlertaSimples(){
        return driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"idButtonTest\"]\n")).getText();
    }

}
