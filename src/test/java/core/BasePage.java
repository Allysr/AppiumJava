package core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BasePage {

    @BeforeEach
    public  void abrirDriver(){
         DriverFactory.getDriver();
    }

    @AfterEach
    public void fecharDriver(){
        DriverFactory.killDriver();
    }
}
