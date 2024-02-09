package test;

import core.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.AlertaPage;
import page.MenuPage;

public class AlertaTest extends BasePage {

    MenuPage menu = new MenuPage();
    AlertaPage alerta = new AlertaPage();

    @BeforeEach
    public void clicarMenu(){
        menu.acessarAlertas();
    }

    @Test
    public void validarAlertaSimples(){
        alerta.clicarAlertaSimples();
        Assertions.assertEquals("Info", alerta.obterTituloAlerta());
        alerta.clicarBotaoOkAlerta();
    }

    @Test
    public void validarAlertaRestritivo(){
        alerta.clicarAlertaRestritivo();
        Assertions.assertEquals("Info", alerta.obterTituloAlerta());
        alerta.clicarBotaoOkAlerta();
    }

    @Test
    public void validarAlertaConfirme(){
        alerta.clicarAlertaConfirm();
        Assertions.assertEquals("Info", alerta.obterTituloAlerta());
        alerta.clicarBotaoOkAlerta();
        alerta.clicarBotaoOkAlerta();
    }


}
