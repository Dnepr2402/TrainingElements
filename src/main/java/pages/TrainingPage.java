package pages;

import drivers.Manager;
import drivers.Waits;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import properties.TestData;


import java.io.File;
import java.util.List;

public class TrainingPage {

    WebDriver chromeDriver;
    WebElement checkBox;
    WebDriverWait wait;

    public TrainingPage(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
        this.wait = new WebDriverWait(Manager.getChromeDriver(), TestData.propsDriver.defaultTimeout());
    }

    /**
     * открываем сайт для тренировки(взаимодействие с элементами)
     *
     * @param url
     */
    public void openPage(String url) {
        chromeDriver.get(url);
    }

    /**
     * Вводим стаж работы
     *
     * @param yearsExp
     */
    public void writeYearsExp(int yearsExp) {
        chromeDriver.findElement(By.xpath("//input[@id='exp']")).sendKeys(String.valueOf(yearsExp));
    }

    /**
     * Чек бокс для выбора ЯП
     */
    public void checkBoxChoiceLanguageProgramming(List<String> languageProgramming) {
        for (String nameProgram : languageProgramming) {
            checkBox = chromeDriver.findElement(By.xpath("//label[contains(., '" + nameProgram + "')]"));
            if (!checkBox.isSelected()) checkBox.click();
        }
    }

    /**
     * Выбор Selenium or Protractor
     *
     * @param choice
     */
    public void radioButton(String choice) {
        chromeDriver.findElement(By.xpath(" //label[contains(., '" + choice + "')]")).click();
        //label[contains(., 'Selenium')]
        //label[contains(., 'Protractor')]
    }

    /**
     * Выбираем Primary Skill
     *
     * @param choiceSkill
     */
    public void choicePrimarySkill(String choiceSkill) {
        chromeDriver.findElement(By.xpath("//select[@class='form-control form-control-sm']")).click();
        chromeDriver.findElement(By.xpath("//option[contains(., '" + choiceSkill + "')]")).click();
    }

    /**
     * Выбираем язык программирования
     *
     * @param choiceLanguage
     */
    public void choiceLanguage(String choiceLanguage) {
        chromeDriver.findElement(By.xpath("//option[contains(., '" + choiceLanguage + "')]")).click();
    }

    /**
     * Вписать текст в поле
     *
     * @param text
     */
    public void writeTextInNotes(String text) {
        chromeDriver.findElement(By.xpath("//textarea[@id='notes']")).sendKeys(text);
    }

    /**
     * Только чтение (Mandatory Skill (Read-Only textbox))
     *
     * @param textField
     */
    public void sendKeyInField(String textField) {
//        WebElement element = chromeDriver.findElement(By.tagName("readonly"));
        WebElement setField = chromeDriver.findElement(By.xpath("//input[@placeholder='Common Sense']"));
        ((JavascriptExecutor)chromeDriver).executeScript("arguments[0].removeAttribute('readonly','readonly')", setField);
        setField.sendKeys(textField);
    }

    /**
     * Speaks German on
     */
    public void clickOn() {
        chromeDriver.findElement(By.xpath("//label[@for='german']")).click();
    }

    /**
     * Speaks German oFF
     */
    public void clickOFF() {
        chromeDriver.findElement(By.xpath("//label[@for='german']")).click();
    }
    //span[@id='fluency_validate' and contains(., '" + number + "')]

    public void dragAndDrop(int neededValueInInput) {
        WebElement element = chromeDriver.findElement
                (By.xpath("//input[@type='range' and @min='0' and @max='5']"));
        int min = Integer.parseInt(element.getAttribute("min"));
        int max = Integer.parseInt(element.getAttribute("max"));
        int all;
        if (min == 0) all = max + 1;
        else all = max;

        int width = element.getSize().getWidth();
        int begin = -(width/2);

        int step = width/all;

        int neededSteps = 0;
        if ( neededValueInInput != 0 && min == 0) {
            neededSteps = (neededValueInInput+1) * step;
        } else if ( neededValueInInput != 0 && min != 0) {
            neededSteps = neededValueInInput * step;
        }
        Actions actions = new Actions(chromeDriver);
        actions.moveToElement(element)
                .clickAndHold()
                .moveByOffset(begin, 0)
                .moveByOffset(neededSteps, 0)
                .release()
                .perform();
        Waits.waitUntilElementIsVisible(
                By.xpath("//input[@type='range' and @min='0' and @max='5']"));
    }

    public void currentSalary(String disabledTextBox) {
        WebElement element = chromeDriver.findElement(By.xpath("//input[@placeholder='You should not provide this']"));
        ((JavascriptExecutor)chromeDriver).executeScript("arguments[0].removeAttribute('disabled','disabled')",element);
        element.sendKeys(disabledTextBox);
    }

    public void formValidation(String city, String state, String zip) {
        WebElement fieldCity = chromeDriver.findElement(By.xpath("//input[@placeholder='City']"));
        fieldCity.sendKeys(city);
        WebElement fieldState = chromeDriver.findElement(By.xpath("//input[@placeholder='State']"));
        fieldState.sendKeys(state);
        WebElement fieldZip = chromeDriver.findElement(By.xpath("//input[@placeholder='Zip']"));
        fieldZip.sendKeys(zip);
        chromeDriver.findElement(By.xpath("//label[contains(., 'Agree to terms and conditions')]")).click();
        chromeDriver.findElement(By.xpath("//button[contains(., 'Submit Form')]")).click();
    }

    public void addFile(String path) {
        WebElement upload = chromeDriver.findElement(By.id("upload_cv"));
        upload.sendKeys(path);
    }

    public void multiplyFiles(String path) {
        WebElement upload = chromeDriver.findElement(By.id("upload_files"));
        upload.sendKeys(path);
    }


}
