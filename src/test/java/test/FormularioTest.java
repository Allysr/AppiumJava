package test;

import core.BasePage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.FormularioPage;
import page.MenuPage;

public class FormularioTest extends BasePage {

    MenuPage menu = new MenuPage();
    FormularioPage formulario = new FormularioPage();

    @BeforeEach
    public void clicarMenu(){
        menu.acessarFormulario();
    }

    @Test
    public void validarFormularioNome(){
        formulario.digitarNome();
        Assertions.assertEquals("Alicia", formulario.obterNome());
    }

    @Test
    public void validarFormularioSelecao(){
        formulario.selecionarConsole();
        Assertions.assertEquals("Nintendo Switch", formulario.obterConsole());
    }
    @Test
    public void validarFormularioCheckboxSwitch(){
        formulario.clicarCheckbox();
        formulario.clicarSwitch();

        Assertions.assertEquals("true", formulario.checkBoxMarcado());
        Assertions.assertEquals("false", formulario.switchMarcado());

    }
    @Test
    public void validarTodosCampos(){
        formulario.digitarNome();
        formulario.selecionarConsole();
        formulario.clicarCheckbox();
        formulario.clicarSwitch();
        formulario.clicarBotaoSalvar();

        Assertions.assertEquals("Nome: Alicia", formulario.obterResultadoNome());
        Assertions.assertEquals("Console: switch", formulario.obterResultadoConsole());
        Assertions.assertEquals("Slider: 25", formulario.obterResultadoSlider());
        Assertions.assertEquals("Switch: Off", formulario.obterResultadoSwitch());
        Assertions.assertEquals("Checkbox: Marcado", formulario.obterResultadoCheckbox());
        Assertions.assertEquals("Data: 01/01/2000", formulario.obterResultadoData());
        Assertions.assertEquals("Hora: 12:00", formulario.obterResultadoHora());

    }

}
