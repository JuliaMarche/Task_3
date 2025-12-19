package test;

import factory.BrowserFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected WebDriver driver;
    private BrowserFactory browserFactory;

    @BeforeEach
    protected void setUp() {
        String browser = System.getProperty("browser", "chrome");
        browserFactory = new BrowserFactory();
        browserFactory.initDriver(browser);
        driver = browserFactory.getDriver();
        //driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}