package tests.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import tests.components.CityConfirmComponent;
import tests.components.CookieNoticeComponent;
import tests.helpers.Attach;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    CookieNoticeComponent cookieNoticeComponent = new CookieNoticeComponent();
    CityConfirmComponent cityConfirmComponent = new CityConfirmComponent();

    private final SelenideElement locationButton = $(".LocationButton_locationButton_text__UFX5G");

    @Step("Открыть главную страницу MTS IT")
    public MainPage openMainPage() {
        open("/it");
        return this;
    }

    @Step("Обновить страницу")
    public MainPage refreshPage() {
        Selenide.refresh();
        return this;
    }

    // Cookie методы
    @Step("Принять cookies")
    public MainPage acceptCookies() {
        cookieNoticeComponent.acceptCookies();
        return this;
    }

    @Step("Настроить cookies")
    public MainPage configureCookies() {
        cookieNoticeComponent.configureCookies();
        return this;
    }

    @Step("Проверить, что cookie баннер скрыт")
    public MainPage verifyCookieBannerNotVisible() {
        cookieNoticeComponent.cookieBannerShouldNotBeVisible();
        return this;
    }

    @Step("Проверить все элементы cookie баннера")
    public MainPage verifyAllCookieBannerElements() {
        cookieNoticeComponent.verifyAllCookieBannerElements();
        return this;
    }

    @Step("Проверить текст кнопок cookie баннера")
    public MainPage verifyCookieButtonsText(String acceptText, String configureText) {
        cookieNoticeComponent.shouldHaveButtonsText(acceptText, configureText);
        return this;
    }

    @Step("Проверить кликабельность кнопок cookie")
    public MainPage verifyCookieButtonsClickable() {
        cookieNoticeComponent.acceptButtonShouldBeVisible();
        cookieNoticeComponent.configureButtonShouldBeVisible();
        return this;
    }

    // City методы
    @Step("Подтвердить город по умолчанию")
    public MainPage acceptDefaultCity() {
        cityConfirmComponent.acceptCityMoscow();
        return this;
    }

    @Step("Выбрать город: {cityName}")
    public MainPage chooseCity(String cityName) {
        cityConfirmComponent.chooseNewCity(cityName);
        return this;
    }

    @Step("Проверить отображение города в хедере: {expectedCity}")
    public MainPage verifyCityInHeader(String expectedCity) {
        locationButton.shouldHave(text(expectedCity));
        return this;
    }

    @Step("Проверить все элементы баннера города")
    public MainPage verifyAllCityBannerElements() {
        cityConfirmComponent.verifyAllCityBannerElements();
        return this;
    }

    @Step("Проверить кликабельность кнопок выбора города")
    public MainPage verifyCityButtonsClickable() {
        cityConfirmComponent.acceptCityButtonShouldBeVisible();
        cityConfirmComponent.chooseCityButtonShouldBeVisible();
        return this;
    }
}