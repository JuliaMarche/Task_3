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

public class ProfileTest extends BaseTest {
    private User user;
    private MainPage mainPage;
    private LoginPage loginPage;
    private ProfilePage profilePage;
    private final UserClient userClient = new UserClient();

    @BeforeEach
    public void setUpTest() {
        user = DataUser.generateDataUser();
        userClient.createUser(user);
        driver.get(UiEndpoint.LOGIN);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
    }

    @AfterEach
    public void tearDownTest() {
        String accessToken = userClient.getUserToken(userClient.loginUser(user));
        userClient.deleteUser(accessToken);
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по кнопке 'Конструктор'")
    public void goToConstructorButtonTest() {
        loginPage.fillLoginPage(user.getEmail(), user.getPassword());
        mainPage.goToProfile();
        profilePage.clickConstructor();
        mainPage.isMainTitleVisible();
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по логотипу")
    public void goToConstructorLogoTest() {
        loginPage.fillLoginPage(user.getEmail(), user.getPassword());
        mainPage.goToProfile();
        profilePage.clickLogo();
        mainPage.isMainTitleVisible();
    }
}
