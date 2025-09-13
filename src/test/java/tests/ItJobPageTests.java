package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import tests.helpers.Attach;
import tests.pages.ItJobPage;

import static com.codeborne.selenide.Selenide.*;

@DisplayName("Тестирование главной страницы MTS IT")
public class ItJobPageTests extends BaseTest {

    ItJobPage mainPage = new ItJobPage();
    String acceptCookieText = "принять cookie";
    String configureCookieText = "настроить cookie";

    @BeforeEach
    void beforeEachTest() {
        mainPage.openMainPage();
        clearBrowserCookies();
        clearBrowserLocalStorage();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }

    @Test
    @DisplayName("Проверка отображения cookie баннера")
    @Tag("cookie")
    void shouldDisplayCookieBanner() {
        mainPage.verifyAllCookieBannerElements();
    }

    @Test
    @DisplayName("Проверка текста кнопок cookie баннера")
    @Tag("cookie")
    void shouldHaveCorrectCookieButtonsText() {
        mainPage.verifyCookieButtonsText(acceptCookieText, configureCookieText);
    }

    @Test
    @DisplayName("Проверка кликабельности кнопок cookie")
    @Tag("cookie")
    void shouldHaveClickableCookieButtons() {
        mainPage.verifyCookieButtonsClickable();
    }

    @Test
    @DisplayName("Успешное принятие cookies")
    @Tag("cookie")
    void shouldAcceptCookiesSuccessfully() {
        mainPage.acceptCookies()
                .verifyCookieBannerNotVisible();
    }

    @Test
    @DisplayName("Проверка возможности настроить cookies")
    @Tag("cookie")
    void shouldConfigureCookies() {
        mainPage.configureCookies()
                .verifyCookieBannerNotVisible();
    }

    @Test
    @DisplayName("Проверка поведения при повторном открытии страницы после принятия cookies")
    @Tag("cookie")
    void shouldNotShowCookieBannerAfterRefresh() {
        mainPage.acceptCookies()
                .refreshPage()
                .verifyCookieBannerNotVisible();
    }

    @Test
    @DisplayName("Проверка отображения баннера выбора города")
    @Tag("city")
    void shouldDisplayCityBanner() {
        mainPage.acceptCookies()
                .verifyAllCityBannerElements();
    }

    @Test
    @DisplayName("Подтверждение города по умолчанию")
    @Tag("city")
    void shouldAcceptDefaultCityMoscow() {
        mainPage.acceptCookies()
                .acceptDefaultCity()
                .verifyCityInHeader("Москва");
    }

    @Test
    @DisplayName("Выбор города")
    @Tag("city")
    void shouldChooseKazanCity() {
        mainPage.acceptCookies()
                .chooseCity("Казань")
                .verifyCityInHeader("Казань");
    }

    @Test
    @DisplayName("Проверка кликабельности кнопок выбора города")
    @Tag("city")
    void shouldHaveClickableCityButtons() {
        mainPage.acceptCookies()
                .verifyCityButtonsClickable();
    }

    @Test
    @DisplayName("Проверка сохранения выбора города после перезагрузки")
    @Tag("city")
    void shouldRememberCityChoiceAfterRefresh() {
        mainPage.acceptCookies()
                .chooseCity("Казань")
                .refreshPage()
                .verifyCityInHeader("Казань");
    }

    @Test
    @DisplayName("Принятие cookies и подтверждение города по дефолту")
    @Tag("integration")
    void fullFlowCookiesAndCity() {
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
    void configureCookiesAndChooseCity() {
        mainPage.configureCookies()
                .verifyCookieBannerNotVisible()
                .chooseCity("Казань")
                .verifyCityInHeader("Казань");
    }
}