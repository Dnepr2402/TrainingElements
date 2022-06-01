package drivers;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import properties.TestData;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Класс для инициализации driver.
 *
 * @autor Днепровский Сергей
 */
public class Manager {

    private static WebDriver chromeDriver;

    /**
     * getter chromeDriver.
     *
     * @return WebDriver - возвращает драйвер
     */
    public static EventFiringWebDriver getChromeDriver() {
        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(chromeDriver);
        eventFiringWebDriver.register(new CustomLoggingListener());
        return eventFiringWebDriver;
    }

    /**
     * метод инициализирует chromeDriver.
     * так же использует конструкцию try catch,
     * чтобы отлавливать исключение несовместимости версии драйвера на пк с версией браузера
     */
    public static void initChrome() {
        System.setProperty("webdriver.chrome.driver", System.getenv("CHROME_DRIVER"));
        ChromeOptions options = new ChromeOptions();
        options.addArguments(List.of("start-maximized"));
        try {
            chromeDriver = new ChromeDriver(options);
        } catch (SessionNotCreatedException e) {
            Assertions.fail("Данный драйвер не совместим с текущим браузером. Используйте другой драйвер.\n" + e);
        }
        setDriverDefaultSettings();
//        initStaticObjects();
    }

    /**
     * метод устанавливает таймауты и удаляет все куки перед запуском браузера.
     *
     */
    private static void setDriverDefaultSettings() {
        chromeDriver.manage().timeouts().implicitlyWait(TestData.propsDriver.defaultTimeout(), TimeUnit.SECONDS);
        chromeDriver.manage().deleteAllCookies();
    }

    /**
     * метод устраняет ошибку запуска нескольких тестов.
     *
     */
//    private static void initStaticObjects() {
//        utils.Actions.action = new org.openqa.selenium.interactions.Actions(Manager.getChromeDriver());
//    }

    /**
     * метод присваивает chromeDriver = null, чтобы уничтожить chromeDriver
     * вызывается метод quit(), чтобы закрыть браузер.
     *
     */
    public static void killChromeDriver() {
        if (chromeDriver != null) {
            chromeDriver.quit();
            chromeDriver = null;
        }
    }
}
