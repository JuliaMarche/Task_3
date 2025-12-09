package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;

public class BrowserFactory {
    private WebDriver driver;

    public void initDriver(String browser) {
        switch (browser) {
            case "yandex":
                setupYandex();
                break;
            case "chrome":
            default:
                setupChrome();
                break;
        }
    }

    private void setupChrome() {
        //WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    //запуск тестов mvn test -Dbrowser=chrome

    private void setupYandex() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }
    //запуск тестов mvn test -Dbrowser=yandex "-Dwebdriver.yandex.bin=C:\Progra~2\Yandex\YandexBrowser\Application\browser.exe"

    public WebDriver getDriver() {
        return driver;
    }
}
