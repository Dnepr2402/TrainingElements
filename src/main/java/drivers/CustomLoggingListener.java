package drivers;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;


/**
 * Класс для создания скриншотов и добавления их в Allure отчет
 */
public class CustomLoggingListener extends AbstractWebDriverEventListener {

    /**
     * метод делает скриншот до клика на элемент
     */
    @Step("Before click on element: {0}")
    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        takeScreenShot(driver);
    }

    /**
     * метод делает скриншот после клика на элемент
     */
    @Step("Click on element: {0}")
    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        takeScreenShot(driver);
    }

    /**
     * метод добавляет скриншот в Allure отчет
     */
    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenShot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
