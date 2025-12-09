package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegisterPage {
    private final WebDriver driver;

    //Поле "Имя"
    private By nameInput = By.xpath("//label[text()='Имя']/following-sibling::input");
    //Поле "Email"
    private By emailInput = By.xpath("//label[text()='Email']/following-sibling::input");
    //Поле "Пароль"
    private By passwordInput = By.xpath("//label[text()='Пароль']/following-sibling::input");
    //Кнопка "Зарегестрироваться"
    private By registerButton = By.xpath("//button[text()='Зарегистрироваться']");
    //Ошибка "Некорректный пароль"
    private final By errorPassword = By.className("input__error");
    //Кнопка "Войти"
    private By loginButton = By.xpath("//a[text()='Войти']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Заполнить поле 'Имя'")
    private void fillName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    @Step("Заполнить поле 'Email'")
    private void fillEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    @Step("Заполнить поле 'Пароль'")
    private void fillPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    @Step("Нажать кнопку 'Зарегестироваться'")
    private void clickRegisterButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(registerButton));
        driver.findElement(registerButton).click();
    }

    @Step("Получить текст ошибки пароля")
    public String getPasswordErrorMessage() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(errorPassword));
        return driver.findElement(errorPassword).getText();
    }

    @Step("Нажать на кнопку 'Войти' в форме регистрации")
    public void loginFromRegister() {
        driver.findElement(loginButton).click();
    }

    public void fillRegisterPage(String name, String email, String password) {
        fillName(name);
        fillEmail(email);
        fillPassword(password);
        clickRegisterButton();
    }
}
