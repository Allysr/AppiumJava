package page;

import core.DriverFactory;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;


public class MenuPage {
    AndroidDriver driver = DriverFactory.getDriver();

    public void acessarFormulario(){
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Formulário' and @class='android.widget.TextView']")).click();
    }

    public void acessarAlertas(){
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Alertas\" and @class=\"android.widget.TextView\"]")).click();
    }

    public void acessarAbas(){
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Abas\" and @class=\"android.widget.TextView\"]\n")).click();
    }

    public  void acessarAccordion(){
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Accordion\" and @class=\"android.widget.TextView\"]\n")).click();
    }
}
