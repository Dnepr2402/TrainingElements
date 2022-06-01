package helpers;

import org.junit.jupiter.params.provider.Arguments;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Класс со всеми данными для тестирование.
 *
 * @autor Днепровский Сергей
 */
public class DataProvide {

    /**
     * Возвращает поток аргументов используемых в тесте
     *
     * @return Stream<Arguments> -  поток аргуентов
     */
    public static Stream<Arguments> provide() {
        List<String> listLanguageProgramming = new ArrayList<>();
        listLanguageProgramming.add("Java");
        listLanguageProgramming.add("Python");
        listLanguageProgramming.add("JavaScript");
        List<String> listForm = new ArrayList<>();
        listForm.add("Fllo");
        listForm.add("afffo");
        listForm.add("zipp");

        String text = "Привет, как дела все впорядке абрататплаорладроадордароапрдроад";
        return Stream.of(
                Arguments.of(5, listLanguageProgramming, "Protractor", "Selenium", "JavaScript", text, 2, listForm, "C:\\Users\\Сергей\\Desktop\\QA\\Bell integrator\\Код\\TrainingElements\\testingFile\nC:\\Users\\Сергей\\Desktop\\QA\\Bell integrator\\Код\\TrainingElements\\str.txt"));

    }
}
