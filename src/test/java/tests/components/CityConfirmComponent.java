package tests.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CityConfirmComponent {

    private final SelenideElement cityContainer = $(".Location_cityConfrim__6exZw");
    private final SelenideElement cityConfirmTitle = $(".Location_cityConfrim__title___bOZo");
    private final SelenideElement acceptCityButton = $(byText("Все верно"));
    private final SelenideElement chooseCityButton = $(byText("Выбрать город"));
    private final SelenideElement searchCityField = $("#cityField");
    private final SelenideElement resultSearchCity = $(".Location_location__viewportBody__vUdRD");

    @Step("Проверить, что баннер выбора города отображается")
    public CityConfirmComponent cityBannerShouldBeVisible() {
        cityContainer.shouldBe(visible);
        return this;
    }

    @Step("Проверить заголовок баннера города")
    public CityConfirmComponent cityConfirmTitleShouldBeVisible() {
        cityConfirmTitle.shouldBe(visible);
        return this;
    }

    @Step("Проверить кнопку 'Все верно'")
    public CityConfirmComponent acceptCityButtonShouldBeVisible() {
        acceptCityButton.shouldBe(visible, enabled);
        return this;
    }

    @Step("Проверить кнопку 'Выбрать город'")
    public CityConfirmComponent chooseCityButtonShouldBeVisible() {
        chooseCityButton.shouldBe(visible, enabled);
        return this;
    }

    @Step("Проверить поле поиска города")
    public CityConfirmComponent searchCityFieldShouldBeVisible() {
        searchCityField.shouldBe(visible, enabled);
        return this;
    }

    @Step("Нажать кнопку 'Все верно'")
    public CityConfirmComponent clickAcceptCity() {
        acceptCityButton.shouldBe(visible, enabled).click();
        return this;
    }

    @Step("Нажать кнопку 'Выбрать город'")
    public CityConfirmComponent clickChooseCity() {
        chooseCityButton.shouldBe(visible, enabled).click();
        return this;
    }

    @Step("Ввести город в поле поиска: {cityName}")
    public CityConfirmComponent setCityName(String cityName) {
        searchCityField
                .shouldBe(visible, enabled)
                .setValue(cityName);
        return this;
    }

    @Step("Проверить результат поиска города: {expectedCity}")
    public CityConfirmComponent verifySearchResult(String expectedCity) {
        resultSearchCity.shouldHave(text(expectedCity));
        return this;
    }

    @Step("Выбрать город из результатов поиска: {cityName}")
    public CityConfirmComponent selectCityFromResults(String cityName) {
        $(byText(cityName))
                .shouldBe(visible, enabled)
                .click();
        return this;
    }

    @Step("Подтвердить текущий город Москва")
    public CityConfirmComponent acceptCityMoscow() {
        return cityBannerShouldBeVisible()
                .acceptCityButtonShouldBeVisible()
                .clickAcceptCity();
    }

    @Step("Выбрать новый город: {cityName}")
    public CityConfirmComponent chooseNewCity(String cityName) {
        return cityBannerShouldBeVisible()
                .chooseCityButtonShouldBeVisible()
                .clickChooseCity()
                .searchCityFieldShouldBeVisible()
                .setCityName(cityName)
                .verifySearchResult(cityName)
                .selectCityFromResults(cityName);
    }

    @Step("Проверить все элементы баннера города")
    public CityConfirmComponent verifyAllCityBannerElements() {
        return cityBannerShouldBeVisible()
                .cityConfirmTitleShouldBeVisible()
                .acceptCityButtonShouldBeVisible()
                .chooseCityButtonShouldBeVisible();
    }
}