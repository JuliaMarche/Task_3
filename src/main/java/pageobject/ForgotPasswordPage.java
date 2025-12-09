package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private final WebDriver driver;

    //Кнопка "Войти"
    private final By loginButton = By.xpath("//a[text()='Войти']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажать на кнопку 'Войти'")
    public void loginFromForgotPassword() {
        driver.findElement(loginButton).click();
    }
}
