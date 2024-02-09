package page;

import core.DriverFactory;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AccordionPage {
    AndroidDriver driver = DriverFactory.getDriver();

    public void clicarOpcaoUm(){
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Opção 1\"]")).click();
    }

    public String obterTextoAccordionUm(){
        return driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Esta é a descrição da opção 1\"]")).getText();
    }

}
