package test;

import api.DataUser;
import api.User;
import api.UserClient;
import config.UiEndpoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageobject.LoginPage;
import pageobject.RegisterPage;
import test.BaseTest;
import static org.junit.jupiter.api.Assertions.*;


public class RegisterTest extends BaseTest {
    private User user;
    private RegisterPage registerPage;
    private LoginPage loginPage;
    private final UserClient userClient = new UserClient();

    @BeforeEach
    public void setUpTest() {
        user = DataUser.generateDataUser();
        driver.get(UiEndpoint.REGISTER);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void successfulRegisterTest() {
        registerPage.fillRegisterPage(user.getName(), user.getEmail(), user.getPassword());
        String accessToken = userClient.getUserToken(userClient.loginUser(user));
        loginPage.isLoginTitleVisible();
        userClient.deleteUser(accessToken);
    }

    @Test
    @DisplayName("Ошибка при регистрации с некорректным паролем")
    public void errorPasswordRegisterTest() {
        String errorPassword = "test";
        registerPage.fillRegisterPage(user.getName(), user.getEmail(), errorPassword);
        assertEquals("Некорректный пароль", registerPage.getPasswordErrorMessage());
    }
}
