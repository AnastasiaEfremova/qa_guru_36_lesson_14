package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import tests.pages.ItJobPage;

@Tag("regress")
@DisplayName("Тестирование главной страницы MTS IT")
@Owner("Ефремова Анастасия")
public class ItJobPageTests extends BaseTest {

    ItJobPage mainPage = new ItJobPage();
    String acceptCookieText = "принять cookie";
    String configureCookieText = "настроить cookie";

    @Test
    @DisplayName("Проверка отображения cookie баннера")
    @Tag("cookie")
    void shouldDisplayCookieBannerTest() {
        mainPage.verifyAllCookieBannerElements();
    }

    @Test
    @DisplayName("Проверка текста кнопок cookie баннера")
    @Tag("cookie")
    void shouldHaveCorrectCookieButtonsTextTest() {
        mainPage.verifyCookieButtonsText(acceptCookieText, configureCookieText);
    }

    @Test
    @DisplayName("Проверка кликабельности кнопок cookie")
    @Tag("cookie")
    void shouldHaveClickableCookieButtonsTest() {
        mainPage.verifyCookieButtonsClickable();
    }

    @Test
    @DisplayName("Успешное принятие cookies")
    @Tag("cookie")
    void shouldAcceptCookiesSuccessfullyTest() {
        mainPage.acceptCookies()
                .verifyCookieBannerNotVisible();
    }

    @Test
    @DisplayName("Проверка возможности настроить cookies")
    @Tag("cookie")
    void shouldConfigureCookiesTest() {
        mainPage.configureCookies()
                .verifyCookieBannerNotVisible();
    }

    @Test
    @DisplayName("Проверка поведения при повторном открытии страницы после принятия cookies")
    @Tag("cookie")
    void shouldNotShowCookieBannerAfterRefreshTest() {
        mainPage.acceptCookies()
                .refreshPage()
                .verifyCookieBannerNotVisible();
    }

    @Test
    @DisplayName("Проверка отображения баннера выбора города")
    @Tag("city")
    void shouldDisplayCityBannerTest() {
        mainPage.acceptCookies()
                .verifyAllCityBannerElements();
    }

    @Test
    @DisplayName("Подтверждение города по умолчанию")
    @Tag("city")
    void shouldAcceptDefaultCityMoscowTest() {
        mainPage.acceptCookies()
                .acceptDefaultCity()
                .verifyCityInHeader("Москва");
    }

    @Test
    @DisplayName("Выбор города")
    @Tag("city")
    void shouldChooseKazanCityTest() {
        mainPage.acceptCookies()
                .chooseCity("Казань")
                .verifyCityInHeader("Казань");
    }

    @Test
    @DisplayName("Проверка кликабельности кнопок выбора города")
    @Tag("city")
    void shouldHaveClickableCityButtonsTest() {
        mainPage.acceptCookies()
                .verifyCityButtonsClickable();
    }

    @Test
    @DisplayName("Проверка сохранения выбора города после перезагрузки")
    @Tag("city")
    void shouldRememberCityChoiceAfterRefreshTest() {
        mainPage.acceptCookies()
                .chooseCity("Казань")
                .refreshPage()
                .verifyCityInHeader("Казань");
    }

    @Test
    @DisplayName("Принятие cookies и подтверждение города по дефолту")
    @Tag("integration")
    void fullFlowCookiesAndCityTest() {
        mainPage.verifyAllCookieBannerElements()
                .acceptCookies()
                .verifyCookieBannerNotVisible()
                .verifyAllCityBannerElements()
                .acceptDefaultCity()
                .verifyCityInHeader("Москва");
    }

    @Test
    @DisplayName("Проверка возможности настроить cookies + выбор другого города")
    @Tag("integration")
    void configureCookiesAndChooseCityTest() {
        mainPage.configureCookies()
                .verifyCookieBannerNotVisible()
                .chooseCity("Казань")
                .verifyCityInHeader("Казань");
    }
}