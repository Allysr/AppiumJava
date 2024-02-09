package test;

import core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.AccordionPage;
import page.MenuPage;

public class AccordionTest extends  BasePage{

        MenuPage menu = new MenuPage();
        AccordionPage accordion = new AccordionPage();

        @BeforeEach
        public void clicarMenu(){
            menu.acessarAccordion();
        }

        @Test
        public void validarAccordion(){
            accordion.clicarOpcaoUm();
            Assertions.assertEquals("Esta é a descrição da opção 1", accordion.obterTextoAccordionUm());
        }


}
