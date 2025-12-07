package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    private final WebDriver driver;

    //Кнопка "Конструктор"
    private final By constructorButton = By.xpath("//*[text()='Конструктор']");
    //Лого в хэдере
    private final By headerLogo = By.xpath("//div[contains(@class,'AppHeader_header__logo')]//a");
    //Кнопка "Выйти"
    private final By logoutButton = By.xpath("//button[text()='Выход']");
    //Кнопка "Профиль"
    private final By profileLink = By.xpath("//a[text()='Профиль']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажать на кнопку 'Конструктор'")
    public void clickConstructor() {
        driver.findElement(constructorButton).click();
    }

    @Step("Нажать на логотип хэдера")
    public void clickLogo() {
        driver.findElement(headerLogo).click();
    }

    @Step("Нажать на кнопку 'Выйти'")
    public void clickLogout() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
        driver.findElement(logoutButton).click();
    }

    @Step("Проверить наличие раздела 'Профиль'")
    public boolean isProfileTabVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(profileLink));
        return driver.findElement(profileLink).isDisplayed();
    }
}
