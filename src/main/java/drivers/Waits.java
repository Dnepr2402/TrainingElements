package drivers;

import org.openqa.selenium.*;
import properties.TestData;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Класс с ожиданиями.
 *
 * @autor Днепровский Сергей
 */
public class Waits {

    private static final WebDriverWait wait = new WebDriverWait(Manager.getChromeDriver(), TestData.propsDriver.defaultTimeout());

    /**
     * Ждем пока пропадет элемент.
     *
     * @param element - элемент
     */
    public static void waitForTheDisappearance(WebElement element) {
        wait.until(ExpectedConditions.stalenessOf(element));
    }

    /**
     * Ждем появления элемента на странице.
     *
     * @param locator - локатор элемента
     */
    public static void waitUntilElementIsVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Ждем появления элемента на странице и возвращаем его.
     *
     * @param locator - локатор элемента
     * @return WebElement
     */
    public static WebElement waitUntilElementIsVisibleAndReturnIt(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}