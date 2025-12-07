package test;

import api.DataUser;
import api.User;
import api.UserClient;
import config.UiEndpoint;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageobject.*;
import test.BaseTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {
    private User user;
    private MainPage mainPage;
    private RegisterPage registerPage;
    private ForgotPasswordPage forgotPasswordPage;
    private LoginPage loginPage;
    private ProfilePage profilePage;
    private final UserClient userClient = new UserClient();

    @BeforeEach
    public void setUpTest() {
        user = DataUser.generateDataUser();
        userClient.createUser(user);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        registerPage = new RegisterPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
    }

    @AfterEach
    public void tearDownTest() {
        String accessToken = userClient.getUserToken(userClient.loginUser(user));
        userClient.deleteUser(accessToken);
    }

    @Test
    @DisplayName("Вход по кнопке 'Войти в аккаунт' на главной")
    public void loginMainPageTest() {
        driver.get(UiEndpoint.BASE_URL);
        mainPage.goToAccount();
        loginPage.fillLoginPage(user.getEmail(), user.getPassword());
        mainPage.goToProfile();
        assertTrue(profilePage.isProfileTabVisible(), "Раздел 'Профиль' не отображается");
    }

    @Test
    @DisplayName("Вход по клику на 'Личный кабинет'")
    public void loginProfileTest() {
        driver.get(UiEndpoint.BASE_URL);
        mainPage.goToProfile();
        loginPage.fillLoginPage(user.getEmail(), user.getPassword());
        mainPage.goToProfile();
        assertTrue(profilePage.isProfileTabVisible(), "Раздел 'Профиль' не отображается");
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginRegisterTest() {
        driver.get(UiEndpoint.REGISTER);
        registerPage.loginFromRegister();
        loginPage.fillLoginPage(user.getEmail(), user.getPassword());
        mainPage.goToProfile();
        assertTrue(profilePage.isProfileTabVisible(), "Раздел 'Профиль' не отображается");
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginForgotPasswordTest() {
        driver.get(UiEndpoint.FORGOTPASS);
        forgotPasswordPage.loginFromForgotPassword();
        loginPage.fillLoginPage(user.getEmail(), user.getPassword());
        mainPage.goToProfile();
        assertTrue(profilePage.isProfileTabVisible(), "Раздел 'Профиль' не отображается");
    }
}
