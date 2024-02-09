package page;

import core.DriverFactory;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FormularioPage {
    AndroidDriver driver = DriverFactory.getDriver();

    public void digitarNome(){
        WebElement campoNome = driver.findElement(AppiumBy.accessibilityId("nome"));
        campoNome.sendKeys("Alicia");
    }

    public String obterNome(){
        return driver.findElement(AppiumBy.accessibilityId("nome")).getText();
    }

    public void selecionarConsole(){
        driver.findElement(AppiumBy.accessibilityId("console")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
    }

    public String obterConsole(){
        return driver.findElement(AppiumBy.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
    }

    public void clicarCheckbox(){
        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
    }

    public  void clicarSwitch(){
        driver.findElement(AppiumBy.accessibilityId("switch")).click();
    }

    public String checkBoxMarcado(){
        WebElement checkbox = driver.findElement(AppiumBy.className("android.widget.CheckBox"));
        return checkbox.getAttribute("checked");
    }

    public String switchMarcado(){
        WebElement elementoSwitch = driver.findElement(AppiumBy.accessibilityId("switch"));
        return elementoSwitch.getAttribute("checked");
    }

    public void clicarBotaoSalvar(){
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"SALVAR\" and @class=\"android.widget.TextView\"]\n")).click();
    }

    public void clicarBotaoLimpar(){
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"LIMPAR\"]")).click();
    }

    public String obterResultadoNome(){
        return driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Nome: Alicia\" and @class=\"android.widget.TextView\"]")).getAttribute("text");
    }

    public String obterResultadoConsole(){
        return driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Console: switch\" and @class=\"android.widget.TextView\"]\n")).getAttribute("text");
    }

    public String obterResultadoSlider(){
        return driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Slider: 25\" and @class=\"android.widget.TextView\"]")).getAttribute("text");
    }

    public String obterResultadoSwitch(){
        return driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Switch: Off\" and @class=\"android.widget.TextView\"]")).getAttribute("text");
    }

    public String obterResultadoCheckbox(){
        return driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Checkbox: Marcado\" and @class=\"android.widget.TextView\"]\n")).getAttribute("text");
    }

    public String obterResultadoData(){
        return driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Data: 01/01/2000\" and @class=\"android.widget.TextView\"]\n")).getAttribute("text");
    }

    public String obterResultadoHora(){
        return driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Hora: 12:00\" and @class=\"android.widget.TextView\"]\n")).getAttribute("text");
    }

}
