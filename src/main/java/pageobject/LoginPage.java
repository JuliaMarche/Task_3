package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;

    //Поле "Email"
    private By emailInput = By.xpath("//label[text()='Email']/following-sibling::input");
    //Поле "Пароль"
    private By passwordInput = By.xpath("//label[text()='Пароль']/following-sibling::input");
    //Кнопка "Войти"
    private By loginButton = By.xpath("//button[text()='Войти']");
    //Надпись "Вход"
    private final By loginTitle = By.xpath("//h2[text()='Вход']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Заполнить поле 'Email'")
    public void fillEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    @Step("Заполнить поле 'Пароль'")
    public void fillPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    @Step("Нажать кнопку 'Войти'")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Проверка страницы для логина")
    public void isLoginTitleVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(loginTitle));
        driver.findElement(loginTitle).isDisplayed();
    }

    public void fillLoginPage(String email, String password) {
        fillEmail(email);
        fillPassword(password);
        clickLoginButton();
    }
}
