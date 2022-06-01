package properties;

import org.aeonbits.owner.ConfigFactory;

/**
 * Класс для получения данных из проперти.
 *
 * @autor Днепровский Сергей
 */
public class TestData {
    public static PropsUrl propsUrl = ConfigFactory.create(PropsUrl.class);
    public static PropsDriver propsDriver = ConfigFactory.create(PropsDriver.class);
}
