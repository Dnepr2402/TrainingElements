package training;

import drivers.Manager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

/**
 * Базовый класс для тестирования
 */
public class BaseTest {

    private WebDriver chromeDriver;

    /**
     * Запуск chromeDriver
     */
    @BeforeEach
    public void before() {
        Manager.initChrome();
        chromeDriver = Manager.getChromeDriver();
    }

    /**
     * Закрываем chromeDriver
     */
    @AfterEach
    public void closeTest() {
        Manager.killChromeDriver();
    }
}
