package properties;
import org.aeonbits.owner.Config;

/**
 * Интерфейс для чтения данных из файла url.properties.
 *
 * @autor Днепровский Сергей
 */
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:url.properties"
})
public interface PropsUrl extends Config {

    /**
     * метод считывает из файла(url.properties) url.
     *
     * @return String - возвращает url страницы из файла
     */
    @Key("base.url")
    String baseURL();
}
