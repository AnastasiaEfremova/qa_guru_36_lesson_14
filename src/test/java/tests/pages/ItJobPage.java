package tests.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import tests.components.CityConfirmComponent;
import tests.components.CookieNoticeComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ItJobPage {

    CookieNoticeComponent cookieNoticeComponent = new CookieNoticeComponent();
    CityConfirmComponent cityConfirmComponent = new CityConfirmComponent();

    private final SelenideElement locationButton = $(".LocationButton_locationButton_text__UFX5G");

    @Step("Открыть главную страницу MTS IT")
    public ItJobPage openMainPage() {
        open("/it");
        return this;
    }

    @Step("Обновить страницу")
    public ItJobPage refreshPage() {
        Selenide.refresh();
        return this;
    }

    // Cookie методы
    @Step("Принять cookies")
    public ItJobPage acceptCookies() {
        cookieNoticeComponent.acceptCookies();
        return this;
    }

    @Step("Настроить cookies")
    public ItJobPage configureCookies() {
        cookieNoticeComponent.configureCookies();
        return this;
    }

    @Step("Проверить, что cookie баннер скрыт")
    public ItJobPage verifyCookieBannerNotVisible() {
        cookieNoticeComponent.cookieBannerShouldNotBeVisible();
        return this;
    }

    @Step("Проверить все элементы cookie баннера")
    public ItJobPage verifyAllCookieBannerElements() {
        cookieNoticeComponent.verifyAllCookieBannerElements();
        return this;
    }

    @Step("Проверить текст кнопок cookie баннера")
    public ItJobPage verifyCookieButtonsText(String acceptText, String configureText) {
        cookieNoticeComponent.shouldHaveButtonsText(acceptText, configureText);
        return this;
    }

    @Step("Проверить кликабельность кнопок cookie")
    public ItJobPage verifyCookieButtonsClickable() {
        cookieNoticeComponent.acceptButtonShouldBeVisible();
        cookieNoticeComponent.configureButtonShouldBeVisible();
        return this;
    }

    // City методы
    @Step("Подтвердить город по умолчанию")
    public ItJobPage acceptDefaultCity() {
        cityConfirmComponent.acceptCityMoscow();
        return this;
    }

    @Step("Выбрать город: {cityName}")
    public ItJobPage chooseCity(String cityName) {
        cityConfirmComponent.chooseNewCity(cityName);
        return this;
    }

    @Step("Проверить отображение города в хедере: {expectedCity}")
    public ItJobPage verifyCityInHeader(String expectedCity) {
        locationButton.shouldHave(text(expectedCity));
        return this;
    }

    @Step("Проверить все элементы баннера города")
    public ItJobPage verifyAllCityBannerElements() {
        cityConfirmComponent.verifyAllCityBannerElements();
        return this;
    }

    @Step("Проверить кликабельность кнопок выбора города")
    public ItJobPage verifyCityButtonsClickable() {
        cityConfirmComponent.acceptCityButtonShouldBeVisible();
        cityConfirmComponent.chooseCityButtonShouldBeVisible();
        return this;
    }
}