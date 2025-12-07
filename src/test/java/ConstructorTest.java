package test;

import config.UiEndpoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageobject.*;
import test.BaseTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConstructorTest extends BaseTest {
    private MainPage mainPage;

    @BeforeEach
    public void setUpTest() {
        mainPage = new MainPage(driver);
        driver.get(UiEndpoint.BASE_URL);
    }

    @Test
    @DisplayName("Проверка раздела 'Булки'")
    public void selectBunTest() {
        mainPage.selectSauce();
        mainPage.selectBun();
        assertTrue(mainPage.isBunActive(), "Раздел 'Булки' не активен");
    }

    @Test
    @DisplayName("Проверка раздела 'Соусы'")
    public void selectSauceTest() {
        mainPage.selectSauce();
        assertTrue(mainPage.isSauceActive(), "Раздел 'Соусы' не активен");
    }

    @Test
    @DisplayName("Проверка раздела 'Начинки'")
    public void selectFillingTest() {
        mainPage.selectFilling();
        assertTrue(mainPage.isFillingActive(), "Раздел 'Начинки' не активен");
    }
}
