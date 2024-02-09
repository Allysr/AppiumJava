package test;

import core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.AbaPage;
import page.MenuPage;

public class AbaTest extends BasePage {

    MenuPage menu = new MenuPage();
    AbaPage aba = new AbaPage();

    @BeforeEach
    public void clicarMenu(){
        menu.acessarAbas();
    }

    @Test
    public void validarAbas(){
        Assertions.assertEquals("Este é o conteúdo da Aba 1", aba.obterTextoAbaUm());

        aba.clicarAbaDois();
        Assertions.assertEquals("Este é o conteúdo da Aba 2", aba.obterTextoAbaDois());

    }
}
