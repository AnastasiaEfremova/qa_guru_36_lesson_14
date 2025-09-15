package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import tests.pages.ItJobPage;

@Tag("regress")
@DisplayName("Тестирование главной страницы MTS IT")
public class ItJobPageTests extends BaseTest {

    ItJobPage mainPage = new ItJobPage();
    String acceptCookieText = "принять cookie";
    String configureCookieText = "настроить cookie";

    @Test
    @Owner("Ефремова Анастасия")
    @DisplayName("Проверка отображения cookie баннера")
    @Tag("cookie")
    void shouldDisplayCookieBannerTest() {
        mainPage.verifyAllCookieBannerElements();
    }

    @Test
    @Owner("Ефремова Анастасия")
    @DisplayName("Проверка текста кнопок cookie баннера")
    @Tag("cookie")
    void shouldHaveCorrectCookieButtonsTextTest() {
        mainPage.verifyCookieButtonsText(acceptCookieText, configureCookieText);
    }

    @Test
    @Owner("Ефремова Анастасия")
    @DisplayName("Проверка кликабельности кнопок cookie")
    @Tag("cookie")
    void shouldHaveClickableCookieButtonsTest() {
        mainPage.verifyCookieButtonsClickable();
    }

    @Test
    @Owner("Ефремова Анастасия")
    @DisplayName("Успешное принятие cookies")
    @Tag("cookie")
    void shouldAcceptCookiesSuccessfullyTest() {
        mainPage.acceptCookies()
                .verifyCookieBannerNotVisible();
    }

    @Test
    @Owner("Ефремова Анастасия")
    @DisplayName("Проверка возможности настроить cookies")
    @Tag("cookie")
    void shouldConfigureCookiesTest() {
        mainPage.configureCookies()
                .verifyCookieBannerNotVisible();
    }

    @Test
    @Owner("Ефремова Анастасия")
    @DisplayName("Проверка поведения при повторном открытии страницы после принятия cookies")
    @Tag("cookie")
    void shouldNotShowCookieBannerAfterRefreshTest() {
        mainPage.acceptCookies()
                .refreshPage()
                .verifyCookieBannerNotVisible();
    }

    @Test
    @Owner("Ефремова Анастасия")
    @DisplayName("Проверка отображения баннера выбора города")
    @Tag("city")
    void shouldDisplayCityBannerTest() {
        mainPage.acceptCookies()
                .verifyAllCityBannerElements();
    }

    @Test
    @Owner("Ефремова Анастасия")
    @DisplayName("Подтверждение города по умолчанию")
    @Tag("city")
    void shouldAcceptDefaultCityMoscowTest() {
        mainPage.acceptCookies()
                .acceptDefaultCity()
                .verifyCityInHeader("Москва");
    }

    @Test
    @Owner("Ефремова Анастасия")
    @DisplayName("Выбор города")
    @Tag("city")
    void shouldChooseKazanCityTest() {
        mainPage.acceptCookies()
                .chooseCity("Казань")
                .verifyCityInHeader("Казань");
    }

    @Test
    @Owner("Ефремова Анастасия")
    @DisplayName("Проверка кликабельности кнопок выбора города")
    @Tag("city")
    void shouldHaveClickableCityButtonsTest() {
        mainPage.acceptCookies()
                .verifyCityButtonsClickable();
    }

    @Test
    @Owner("Ефремова Анастасия")
    @DisplayName("Проверка сохранения выбора города после перезагрузки")
    @Tag("city")
    void shouldRememberCityChoiceAfterRefreshTest() {
        mainPage.acceptCookies()
                .chooseCity("Казань")
                .refreshPage()
                .verifyCityInHeader("Казань");
    }

    @Test
    @Owner("Ефремова Анастасия")
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
    @Owner("Ефремова Анастасия")
    @DisplayName("Проверка возможности настроить cookies + выбор другого города")
    @Tag("integration")
    void configureCookiesAndChooseCityTest() {
        mainPage.configureCookies()
                .verifyCookieBannerNotVisible()
                .chooseCity("Казань")
                .verifyCityInHeader("Казань");
    }
}