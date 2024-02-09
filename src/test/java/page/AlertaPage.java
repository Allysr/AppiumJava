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
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"idButtonTest2\"]\n")).click();
    }

    public void clicarAlertaConfirm(){
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"idButtonTest3\"]\n")).click();
    }

    public void clicarBotaoOkAlerta(){
        driver.findElement(AppiumBy.id("android:id/button1")).click();
    }

    public String obterTituloAlerta(){
        return driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
    }

}
