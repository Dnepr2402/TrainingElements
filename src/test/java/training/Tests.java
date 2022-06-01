package training;
import drivers.Manager;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.TrainingPage;
import properties.TestData;

import java.util.List;

public class Tests extends BaseTest {

    @ParameterizedTest(name = "{displayName}")
    @MethodSource("helpers.DataProvide#provide")
    public void testDemo(int yearsExp, List<String> languageProgramming,
                         String choice, String choiceSkill, String choiceLanguage, String text, int number, List<String> listForm, String pathFile) throws InterruptedException {
        TrainingPage page = new TrainingPage(Manager.getChromeDriver());
        page.openPage(TestData.propsUrl.baseURL());
        page.writeYearsExp(yearsExp);
        page.checkBoxChoiceLanguageProgramming(languageProgramming);
        page.radioButton(choice);
        page.choicePrimarySkill(choiceSkill);
        page.choiceLanguage(choiceLanguage);
        page.writeTextInNotes(text);
        page.clickOn();
        page.clickOFF();
        page.sendKeyInField(text);
        page.dragAndDrop(number);
        page.currentSalary(text);
        page.formValidation(listForm.get(0),listForm.get(1), listForm.get(2));
//        page.addFile(pathFile);
        page.multiplyFiles(pathFile);
    }
}
