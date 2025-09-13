package tests.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CookieNoticeComponent {

    private final SelenideElement cookieContainer = $(".CookieNotice_cookieNotice__actionsContainer__xDf0U");
    private final SelenideElement acceptButton = $(byText("принять cookie"));
    private final SelenideElement configureButton = $(byText("настроить cookie"));

    @Step("Проверить, что баннер cookies отображается")
    public CookieNoticeComponent cookieBannerShouldBeVisible() {
        cookieContainer.shouldBe(visible);
        acceptButton.shouldBe(visible);
        configureButton.shouldBe(visible);
        return this;
    }

    @Step("Проверить, что баннер cookies скрыт")
    public CookieNoticeComponent cookieBannerShouldNotBeVisible() {
        cookieContainer.shouldNotBe(visible);
        acceptButton.shouldNotBe(visible);
        return this;
    }

    @Step("Проверить кнопку 'принять cookie'")
    public CookieNoticeComponent acceptButtonShouldBeVisible() {
        acceptButton.shouldBe(visible, enabled);
        return this;
    }

    @Step("Проверить кнопку 'настроить cookie'")
    public CookieNoticeComponent configureButtonShouldBeVisible() {
        configureButton.shouldBe(visible, enabled);
        return this;
    }

    @Step("Проверить текст кнопок cookie баннера")
    public CookieNoticeComponent shouldHaveButtonsText(String acceptText, String configureText) {
        acceptButton.shouldHave(text(acceptText));
        configureButton.shouldHave(text(configureText));
        return this;
    }

    @Step("Нажать кнопку 'принять cookie'")
    public CookieNoticeComponent clickAcceptCookies() {
        acceptButton.shouldBe(visible, enabled).click();
        return this;
    }

    @Step("Нажать кнопку 'настроить cookie'")
    public CookieNoticeComponent clickConfigureCookies() {
        configureButton.shouldBe(visible, enabled).click();
        return this;
    }

    @Step("Принять cookies")
    public CookieNoticeComponent acceptCookies() {
        return cookieBannerShouldBeVisible()
                .acceptButtonShouldBeVisible()
                .clickAcceptCookies();
    }

    @Step("Настроить cookies")
    public CookieNoticeComponent configureCookies() {
        return cookieBannerShouldBeVisible()
                .configureButtonShouldBeVisible()
                .clickConfigureCookies();
    }

    @Step("Проверить все элементы cookie баннера")
    public CookieNoticeComponent verifyAllCookieBannerElements() {
        return cookieBannerShouldBeVisible()
                .acceptButtonShouldBeVisible()
                .configureButtonShouldBeVisible();
    }
}