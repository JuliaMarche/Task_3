package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;

    //Кнопка "Личный кабинет"
    private final By personalAccountButton = By.xpath("//a[@href='/account']");
    //Кнопка "Войти в аккаунт"
    private final By signAccountButton = By.xpath("//button[text()='Войти в аккаунт']");
    //Раздел "Булки"
    private final By bunTab = By.xpath(".//span[text()='Булки']");
    //Раздел "Соусы"
    private final By saucesTab = By.xpath(".//span[text()='Соусы']");
    //Раздел "Начинаки"
    private final By fillingTab = By.xpath(".//span[text()='Начинки']");
    //Признак выбранного раздела
    private final By activeTab = By.xpath(".//div[contains(@class,'tab_tab_type_current__2BEPc')]/span");
    //Надпись "Соберите бургер"
    private final By burgerTitle = By.xpath("//h1[text()='Соберите бургер']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажать на кнопку 'Личный кабинет'")
    public void goToProfile() {
        driver.findElement(personalAccountButton).click();
    }

    @Step("Нажать на кнопку 'Личный кабинет'")
    public void goToAccount() {
        driver.findElement(signAccountButton).click();
    }

    @Step("Проверка наличие надписи 'Соберите бургер'")
    public void selectBun() {
        driver.findElement(bunTab).click();
    }

    @Step("Проверка наличие надписи 'Соберите бургер'")
    public void selectSauce() {
        driver.findElement(saucesTab).click();
    }

    @Step("Проверка наличие надписи 'Соберите бургер'")
    public void selectFilling() {
        driver.findElement(fillingTab).click();
    }

    @Step("Проверка наличие надписи 'Соберите бургер'")
    public boolean isBunActive() {
        return driver.findElement(activeTab).getText().equals("Булки");
    }

    @Step("Проверка наличие надписи 'Соберите бургер'")
    public boolean isSauceActive() {
        return driver.findElement(activeTab).getText().equals("Соусы");
    }

    @Step("Проверка наличие надписи 'Соберите бургер'")
    public boolean isFillingActive() {
        return driver.findElement(activeTab).getText().equals("Начинки");
    }

    @Step("Проверка наличие надписи 'Соберите бургер'")
    public boolean isMainTitleVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(burgerTitle));
        return driver.findElement(burgerTitle).isDisplayed();
    }
}
