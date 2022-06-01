package properties;

import org.aeonbits.owner.Config;

/**
 * Интерфейс для чтения данных из файла driver.properties.
 *
 * @autor Днепровский Сергей
 */
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:driver.properties"
})
public interface PropsDriver extends Config {

    /**
     * метод считывает из файла(driver.properties) заданное количество времени.
     *
     * @return int - возвращает заданное кол-во времени в секундах
     */
    @Key("default.timeout")
    int defaultTimeout();
}

